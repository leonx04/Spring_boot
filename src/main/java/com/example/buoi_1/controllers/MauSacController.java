package com.example.buoi_1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.buoi_1.entity.MauSacEntity;
import com.example.buoi_1.entity.MauSacEntity;
import com.example.buoi_1.repository.asm1.MauSacRepo;

import jakarta.validation.Valid;

@Controller
@RequestMapping("mau-sac")
public class MauSacController {
    private MauSacRepo msRepo;

    public MauSacController() {
        this.msRepo = new MauSacRepo();
    }

    @GetMapping("/index")
    public String index(@RequestParam(defaultValue = "1") int page, Model model) {
        int pageSize = 2; // Số bản ghi hiển thị trên mỗi trang
        List<MauSacEntity> ds = this.msRepo.findAllPaging(page, pageSize);
        int totalPages = this.msRepo.getTotalPages(pageSize);

        model.addAttribute("data", ds);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);
        return "mau_sac/list";
    }

    @GetMapping("/create")
    public String create(@ModelAttribute("data") MauSacEntity mauSacEntity) {
        return "mau_sac/create";
    }

    @PostMapping("/store")
    public String store(@Valid @ModelAttribute("data") MauSacEntity mauSacEntity, BindingResult bindingResult,
            Model model) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError error : bindingResult.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }
            model.addAttribute("errors", errors);
            return "mau_sac/create";
        }
        this.msRepo.create(mauSacEntity);
        return "redirect:/mau-sac/index";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        this.msRepo.deleteByIn(id);
        return "redirect:/mau-sac/index";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model) {
        MauSacEntity ms = this.msRepo.findById(id);
        model.addAttribute("data", ms);
        return "mau_sac/edit";
    }

    @PostMapping("update/{id}")
    public String update(@PathVariable("id") Integer id, @Valid @ModelAttribute("data") MauSacEntity mauSacEntity,
            BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError error : bindingResult.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }
            model.addAttribute("errors", errors);
            return "mau_sac/edit";
        }
        this.msRepo.update(mauSacEntity);
        return "redirect:/mau-sac/index";
    }

    @GetMapping("/search")
    public String search(@RequestParam("keyword") String keyword,
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "2") int pageSize,
            Model model) {
        List<MauSacEntity> result = this.msRepo.findByTenPaging(keyword, page, pageSize);
        int totalProducts = this.msRepo.getTotalProductsByTen(keyword);
        int totalPages = (int) Math.ceil((double) totalProducts / pageSize);

        model.addAttribute("data", result);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("keyword", keyword);
        return "mau_sac/list";
    }
}
