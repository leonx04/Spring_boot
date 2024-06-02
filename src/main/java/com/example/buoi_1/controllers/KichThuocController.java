package com.example.buoi_1.controllers;

import com.example.buoi_1.entity.KichThuocEntity;
import com.example.buoi_1.repository.asm2.KichThuocRepo;
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
@RequestMapping("kich-thuoc")
public class KichThuocController {
    @Autowired
    private KichThuocRepo ktRepo;

    @GetMapping("/index")
    public String index(@RequestParam(name = "limit", defaultValue = "10") int pageSize,
                        @RequestParam(name = "page", defaultValue = "1") int pageNumber, Model model) {
        Pageable p = PageRequest.of(pageNumber - 1, pageSize);
        Page<KichThuocEntity> page = this.ktRepo.findAll(p);

        model.addAttribute("data", page);
        model.addAttribute("currentPage", pageNumber);
        model.addAttribute("totalPages", page.getTotalPages());

        return "kich_thuoc/list";
    }

    @GetMapping("/create")
    public String create(@ModelAttribute("data") KichThuocEntity kichThuocEntity) {
        return "kich_thuoc/create";
    }

    @PostMapping("/store")
    public String store(Model model, @Valid KichThuocEntity kichThuocEntity, BindingResult validate) {
        if (validate.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError e : validate.getFieldErrors()) {
                errors.put(e.getField(), e.getDefaultMessage());
            }
            model.addAttribute("data", kichThuocEntity);
            model.addAttribute("errors", errors);
            return "kich_thuoc/create";
        }
        this.ktRepo.save(kichThuocEntity);
        return "redirect:/kich-thuoc/index";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        this.ktRepo.deleteById(id);
        return "redirect:/kich-thuoc/index";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model) {
        KichThuocEntity kt = this.ktRepo.findById(id).get();
        model.addAttribute("data", kt);
        return "kich_thuoc/edit";
    }

    @PostMapping("update/{id}")
    public String update(@PathVariable("id") Integer id, @Valid KichThuocEntity kt, BindingResult validate, Model model) {
        if (validate.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError e : validate.getFieldErrors()) {
                errors.put(e.getField(), e.getDefaultMessage());
            }
            model.addAttribute("data", kt);
            model.addAttribute("errors", errors);
            return "kich_thuoc/edit";
        }

        this.ktRepo.save(kt);
        return "redirect:/kich-thuoc/index";
    }

    @GetMapping("/search")
    public String search(@RequestParam(defaultValue = "") String keyword,
                         @RequestParam(defaultValue = "1") int page,
                         @RequestParam(defaultValue = "10") int size,
                         Model model) {
        Pageable pageable = PageRequest.of(page - 1, size);
        Page<KichThuocEntity> result;

        if (keyword.isEmpty()) {
            result = ktRepo.findAll(pageable);
        } else {
            result = ktRepo.findByTenContainingIgnoreCase(keyword, pageable);
        }

        model.addAttribute("data", result);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", result.getTotalPages());
        model.addAttribute("keyword", keyword);

        return "kich_thuoc/list";
    }
}