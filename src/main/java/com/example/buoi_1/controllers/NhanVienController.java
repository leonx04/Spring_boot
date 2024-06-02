package com.example.buoi_1.controllers;

import com.example.buoi_1.entity.NhanVienEntity;
import com.example.buoi_1.repository.asm2.NhanVienRepo;
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

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("nhan-vien")
public class NhanVienController {
    @Autowired
    private NhanVienRepo nvRepo;

    @GetMapping("/index")
    public String index(@RequestParam(name = "limit", defaultValue = "10") int pageSize,
                        @RequestParam(name = "page", defaultValue = "1") int pageNumber, Model model) {
        Pageable p = PageRequest.of(pageNumber - 1, pageSize);
        Page<NhanVienEntity> page = this.nvRepo.findAll(p);

        model.addAttribute("data", page);
        model.addAttribute("currentPage", pageNumber);
        model.addAttribute("totalPages", page.getTotalPages());

        return "nhan_vien/list";
    }

    @GetMapping("/create")
    public String create(@ModelAttribute("data") NhanVienEntity nhanVienEntity) {
        return "nhan_vien/create";
    }

    @PostMapping("/store")
    public String store(@Valid @ModelAttribute("data") NhanVienEntity nhanVienEntity, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError error : bindingResult.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }
            model.addAttribute("errors", errors);
            return "nhan_vien/create";
        }
        this.nvRepo.save(nhanVienEntity);
        return "redirect:/nhan-vien/index";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        this.nvRepo.deleteById(id);
        return "redirect:/nhan-vien/index";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model) {
        NhanVienEntity nv = this.nvRepo.findById(id).get();
        model.addAttribute("data", nv);
        return "nhan_vien/edit";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") Integer id, @Valid @ModelAttribute("data") NhanVienEntity nhanVienEntity,
                         BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError error : bindingResult.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }
            model.addAttribute("errors", errors);
            return "nhan_vien/edit";
        }

        this.nvRepo.save(nhanVienEntity);
        return "redirect:/nhan-vien/index";
    }

    @GetMapping("/search")
    public String search(@RequestParam(defaultValue = "") String keyword,
                         @RequestParam(defaultValue = "1") int page,
                         @RequestParam(defaultValue = "10") int size,
                         Model model) {
        Pageable pageable = PageRequest.of(page - 1, size);
        Page<NhanVienEntity> result;

        if (keyword.isEmpty()) {
            result = nvRepo.findAll(pageable);
        } else {
            result = nvRepo.findByTenContainingIgnoreCase(keyword, pageable);
        }

        model.addAttribute("data", result);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", result.getTotalPages());
        model.addAttribute("keyword", keyword);

        return "nhan_vien/list";
    }
}