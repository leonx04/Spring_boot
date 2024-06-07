package com.example.buoi_1.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.example.buoi_1.entity.SanPhamEntity;
import com.example.buoi_1.repository.asm2.SanPhamRepo;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("san-pham")
public class SanPhamController {
    @Autowired
    private SanPhamRepo spRepo;

    @GetMapping("/index")
    public String index(@RequestParam(name = "limit", defaultValue = "10") int pageSize,
                        @RequestParam(name = "page",defaultValue="1") int pageNumber , Model model) {
        Pageable p = PageRequest.of(pageNumber - 1, pageSize); // Thay đổi ở đây

        Page<SanPhamEntity> page = this.spRepo.findAll(p);

        model.addAttribute("data", page);
        model.addAttribute("currentPage", pageNumber);
        model.addAttribute("totalPages", page.getTotalPages());

        return "san_pham/list";
    }

    // @RequestMapping("san-pham/create")
    @GetMapping("/create")
    public String create(@ModelAttribute("data") SanPhamEntity sanPhamEntity) {
        return "san_pham/create";
    }
    @PostMapping("/store")
    public String store(Model model, @Valid SanPhamEntity sanPhamEntity, BindingResult validate) {
        if (validate.hasErrors()) {
            //Loi
            model.addAttribute("data", sanPhamEntity);
            Map<String, String> errors = new HashMap<>();
            for (FieldError e : validate.getFieldErrors()) {
                errors.put(e.getField(),e.getDefaultMessage());
            }
            model.addAttribute("data", sanPhamEntity);
            model.addAttribute("errors", errors);
            return "san_pham/create";
        }
        this.spRepo.save(sanPhamEntity);
        return "redirect:/san-pham/index";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        this.spRepo.deleteById(id);
        return "redirect:/san-pham/index";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model) {
        SanPhamEntity sp = this.spRepo.findById(id).get();
        model.addAttribute("data", sp);
        return "san_pham/edit";
    }

    @PostMapping("update/{id}")
    public String update(@PathVariable("id") Integer id, @Valid SanPhamEntity sp, BindingResult validate, Model model) {
        if (validate.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError e : validate.getFieldErrors()) {
                errors.put(e.getField(), e.getDefaultMessage());
            }
            model.addAttribute("data", sp);
            model.addAttribute("errors", errors);
            return "san_pham/edit";
        }
        this.spRepo.save(sp);
        return "redirect:/san-pham/index";
    }

    @GetMapping("/search")
    public String search(@RequestParam(defaultValue = "") String keyword,
                         @RequestParam(defaultValue = "1") int page,
                         @RequestParam(defaultValue = "10") int size,
                         Model model) {
        Pageable pageable = PageRequest.of(page - 1, size);
        Page<SanPhamEntity> result;

        if (keyword.isEmpty()) {
            result = spRepo.findAll(pageable);
        } else {
            result = spRepo.findByTenContainingIgnoreCase(keyword, pageable);
        }

        model.addAttribute("data", result);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", result.getTotalPages());
        model.addAttribute("keyword", keyword);

        return "san_pham/list";
    }
}
