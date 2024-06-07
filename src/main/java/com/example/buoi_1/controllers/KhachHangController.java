package com.example.buoi_1.controllers;

import com.example.buoi_1.entity.KhachHangEntity;
import com.example.buoi_1.repository.asm2.KhachHangRepo;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("khach-hang")
public class KhachHangController {
    @Autowired
    private KhachHangRepo khRepo;

    @GetMapping("/index")
    public String index(@RequestParam(name = "limit", defaultValue = "10") int pageSize,
                        @RequestParam(name = "page", defaultValue = "1") int pageNumber, Model model) {
        Pageable p = PageRequest.of(pageNumber - 1, pageSize);
        Page<KhachHangEntity> page = this.khRepo.findAll(p);

        model.addAttribute("data", page);
        model.addAttribute("currentPage", pageNumber);
        model.addAttribute("totalPages", page.getTotalPages());

        return "khach_hang/list";
    }

    @GetMapping("/create")
    public String create(@ModelAttribute("data") KhachHangEntity khachHangEntity) {
        return "khach_hang/create";
    }

    @PostMapping("/store")
    public String store(Model model, @Valid KhachHangEntity khachHangEntity, BindingResult validate) {
        if (validate.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError e : validate.getFieldErrors()) {
                errors.put(e.getField(), e.getDefaultMessage());
            }
            model.addAttribute("data", khachHangEntity);
            model.addAttribute("errors", errors);
            return "khach_hang/create";
        }
        this.khRepo.save(khachHangEntity);
        return "redirect:/khach-hang/index";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        this.khRepo.deleteById(id);
        return "redirect:/khach-hang/index";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model) {
        KhachHangEntity kh = this.khRepo.findById(id).get();
        model.addAttribute("data", kh);
        return "khach_hang/edit";
    }

    @PostMapping("update/{id}")
    public String update(@PathVariable("id") Integer id, @Valid KhachHangEntity kh, BindingResult validate, Model model) {
        if (validate.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError e : validate.getFieldErrors()) {
                errors.put(e.getField(), e.getDefaultMessage());
            }
            model.addAttribute("data", kh);
            model.addAttribute("errors", errors);
            return "khach_hang/edit";
        }

        this.khRepo.save(kh);
        return "redirect:/khach-hang/index";
    }

    @GetMapping("/search")
    public String search(@RequestParam(defaultValue = "") String keyword,
                         @RequestParam(defaultValue = "1") int page,
                         @RequestParam(defaultValue = "10") int size,
                         Model model) {
        Pageable pageable = PageRequest.of(page - 1, size);
        Page<KhachHangEntity> result;

        if (keyword.isEmpty()) {
            result = khRepo.findAll(pageable);
        } else {
            result = khRepo.findByTenContainingIgnoreCase(keyword, pageable);
        }

        model.addAttribute("data", result);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", result.getTotalPages());
        model.addAttribute("keyword", keyword);

        return "khach_hang/list";
    }

}