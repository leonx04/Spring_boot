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

import com.example.buoi_1.entity.KichThuocEntity;
import com.example.buoi_1.repository.asm1.KichThuocRepo;

import jakarta.validation.Valid;

@Controller
@RequestMapping("kich-thuoc")
public class KichThuocController {
    private KichThuocRepo ktRepo;

    public KichThuocController() {
        this.ktRepo = new KichThuocRepo();
    }

    @GetMapping("/index")
    public String index(@RequestParam(defaultValue = "1") int page, Model model) {
        int pageSize = 2;
        List<KichThuocEntity> ds = this.ktRepo.findAllPaging(page, pageSize);
        int totalPages = this.ktRepo.getTotalPages(pageSize);

        model.addAttribute("data", ds);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);
        return "kich_thuoc/list";
    }

    @GetMapping("/create")
    public String create(@ModelAttribute("data") KichThuocEntity kichThuocEntity) {
        return "kich_thuoc/create";
    }

    @PostMapping("/store")
    public String store(@Valid @ModelAttribute("data") KichThuocEntity kichThuocEntity, BindingResult bindingResult,
            Model model) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError error : bindingResult.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }
            model.addAttribute("errors", errors);
            return "kich_thuoc/create";
        }
        this.ktRepo.create(kichThuocEntity);
        return "redirect:/kich-thuoc/index";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        this.ktRepo.deleteById(id);
        return "redirect:/kich-thuoc/index";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model) {
        KichThuocEntity kt = this.ktRepo.findById(id);
        model.addAttribute("data", kt);
        return "kich_thuoc/edit";
    }

    @PostMapping("update/{id}")
    public String update(@PathVariable("id") Integer id, @Valid @ModelAttribute("data") KichThuocEntity kichThuocEntity,
            BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError error : bindingResult.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }
            model.addAttribute("errors", errors);
            return "kich_thuoc/edit";
        }

        this.ktRepo.update(kichThuocEntity);
        return "redirect:/kich-thuoc/index";
    }

    @GetMapping("/search")
    public String search(@RequestParam("keyword") String keyword,
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "2") int pageSize,
            Model model) {
        List<KichThuocEntity> result = this.ktRepo.findByTenPaging(keyword, page, pageSize);
        int totalProducts = this.ktRepo.getTotalProductsByTen(keyword);
        int totalPages = (int) Math.ceil((double) totalProducts / pageSize);

        model.addAttribute("data", result);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("keyword", keyword);
        return "kich_thuoc/list";
    }
}