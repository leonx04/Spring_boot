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

import com.example.buoi_1.entity.NhanVienEntity;
import com.example.buoi_1.repository.asm1.NhanVienRepo;

import jakarta.validation.Valid;

@Controller
@RequestMapping("nhan-vien")
public class NhanVienController {
    private NhanVienRepo nvRepo;

    public NhanVienController() {
        this.nvRepo = new NhanVienRepo();
    }

    @GetMapping("/index")
    public String index(@RequestParam(defaultValue = "1") int page, Model model) {
        int pageSize = 2;
        List<NhanVienEntity> ds = this.nvRepo.findAllPaging(page, pageSize);
        int totalPages = this.nvRepo.getTotalPages(pageSize);

        model.addAttribute("data", ds);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);
        return "nhan_vien/list";
    }

    @GetMapping("/create")
    public String create(@ModelAttribute("data") NhanVienEntity nhanVienEntity) {
        return "nhan_vien/create";
    }

    @PostMapping("/store")
    public String store(@Valid @ModelAttribute("data") NhanVienEntity nhanVienEntity, BindingResult bindingResult,
            Model model) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError error : bindingResult.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }
            model.addAttribute("errors", errors);
            return "nhan_vien/create";
        }
        this.nvRepo.create(nhanVienEntity);
        return "redirect:/nhan-vien/index";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        this.nvRepo.deleteById(id);
        return "redirect:/nhan-vien/index";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model) {
        NhanVienEntity nv = this.nvRepo.findById(id);
        model.addAttribute("data", nv);
        return "nhan_vien/edit";
    }

    @PostMapping("update/{id}")
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

        this.nvRepo.update(nhanVienEntity);
        return "redirect:/nhan-vien/index";
    }

    @GetMapping("/search")
    public String search(@RequestParam("keyword") String keyword,
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "2") int pageSize,
            Model model) {
        List<NhanVienEntity> result = this.nvRepo.findByTenPaging(keyword, page, pageSize);
        int totalProducts = this.nvRepo.getTotalProductsByTen(keyword);
        int totalPages = (int) Math.ceil((double) totalProducts / pageSize);

        model.addAttribute("data", result);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("keyword", keyword);
        return "nhan_vien/list";
    }
}