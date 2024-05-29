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

import com.example.buoi_1.entity.KhachHangEntity;
import com.example.buoi_1.repository.asm1.KhachHangRepo;

import jakarta.validation.Valid;

@Controller
@RequestMapping("khach-hang")
public class KhachHangController {
    private KhachHangRepo khRepo;

    public KhachHangController() {
        this.khRepo = new KhachHangRepo();
    }

    @GetMapping("/index")
    public String index(@RequestParam(defaultValue = "1") int page, Model model) {
        int pageSize = 2;
        List<KhachHangEntity> ds = this.khRepo.findAllPaging(page, pageSize);
        int totalPages = this.khRepo.getTotalPages(pageSize);

        model.addAttribute("data", ds);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);
        return "khach_hang/list";
    }

    @GetMapping("/create")
    public String create(@ModelAttribute("data") KhachHangEntity khachHangEntity) {
        return "khach_hang/create";
    }

    @PostMapping("/store")
    public String store(@Valid @ModelAttribute("data") KhachHangEntity khachHangEntity, BindingResult bindingResult,
            Model model) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError error : bindingResult.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }
            model.addAttribute("errors", errors);
            return "khach_hang/create";
        }
        this.khRepo.create(khachHangEntity);
        return "redirect:/khach-hang/index";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        this.khRepo.deleteById(id);
        return "redirect:/khach-hang/index";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model) {
        KhachHangEntity kh = this.khRepo.findById(id);
        model.addAttribute("data", kh);
        return "khach_hang/edit";
    }

    @PostMapping("update/{id}")
    public String update(@PathVariable("id") Integer id, @Valid @ModelAttribute("data") KhachHangEntity khachHangEntity,
            BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError error : bindingResult.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }
            model.addAttribute("errors", errors);
            return "khach_hang/edit";
        }

        this.khRepo.update(khachHangEntity);
        return "redirect:/khach-hang/index";
    }

    @GetMapping("/search")
    public String search(@RequestParam("keyword") String keyword,
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "2") int pageSize,
            Model model) {
        List<KhachHangEntity> result = this.khRepo.findByTenPaging(keyword, page, pageSize);
        int totalProducts = this.khRepo.getTotalProductsByTen(keyword);
        int totalPages = (int) Math.ceil((double) totalProducts / pageSize);

        model.addAttribute("data", result);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("keyword", keyword);
        return "khach_hang/list";
    }
}