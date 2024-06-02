package com.example.buoi_1.controllers;

import com.example.buoi_1.entity.MauSacEntity;
import com.example.buoi_1.repository.asm2.MauSacRepo;
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
@RequestMapping("mau-sac")
public class MauSacController {
    @Autowired
    private MauSacRepo msRepo;

    @GetMapping("/index")
    public String index(@RequestParam(name = "limit", defaultValue = "10") int pageSize,
                        @RequestParam(name = "page", defaultValue = "1") int pageNumber, Model model) {
        Pageable p = PageRequest.of(pageNumber - 1, pageSize);
        Page<MauSacEntity> page = this.msRepo.findAll(p);

        model.addAttribute("data", page);
        model.addAttribute("currentPage", pageNumber);
        model.addAttribute("totalPages", page.getTotalPages());

        return "mau_sac/list";
    }

    @GetMapping("/create")
    public String create(@ModelAttribute("data") MauSacEntity mauSacEntity) {
        return "mau_sac/create";
    }

    @PostMapping("/store")
    public String store(Model model, @Valid MauSacEntity mauSacEntity, BindingResult validate) {
        if (validate.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError e : validate.getFieldErrors()) {
                errors.put(e.getField(), e.getDefaultMessage());
            }
            model.addAttribute("data", mauSacEntity);
            model.addAttribute("errors", errors);
            return "mau_sac/create";
        }
        this.msRepo.save(mauSacEntity);
        return "redirect:/mau-sac/index";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        this.msRepo.deleteById(id);
        return "redirect:/mau-sac/index";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model) {
        MauSacEntity ms = this.msRepo.findById(id).get();
        model.addAttribute("data", ms);
        return "mau_sac/edit";
    }

    @PostMapping("update/{id}")
    public String update(@PathVariable("id") Integer id, @Valid MauSacEntity ms, BindingResult validate, Model model) {
        if (validate.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError e : validate.getFieldErrors()) {
                errors.put(e.getField(), e.getDefaultMessage());
            }
            model.addAttribute("data", ms);
            model.addAttribute("errors", errors);
            return "mau_sac/edit";
        }

        this.msRepo.save(ms);
        return "redirect:/mau-sac/index";
    }

    @GetMapping("/search")
    public String search(@RequestParam(defaultValue = "") String keyword,
                         @RequestParam(defaultValue = "1") int page,
                         @RequestParam(defaultValue = "10") int size,
                         Model model) {
        Pageable pageable = PageRequest.of(page - 1, size);
        Page<MauSacEntity> result;

        if (keyword.isEmpty()) {
            result = msRepo.findAll(pageable);
        } else {
            result = msRepo.findByTenContainingIgnoreCase(keyword, pageable);
        }

        model.addAttribute("data", result);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", result.getTotalPages());
        model.addAttribute("keyword", keyword);

        return "mau_sac/list";
    }
}