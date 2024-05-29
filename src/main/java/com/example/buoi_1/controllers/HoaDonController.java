package com.example.buoi_1.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.example.buoi_1.entity.HoaDonEntity;
import com.example.buoi_1.repository.asm1.HoaDonRepo;

import jakarta.validation.Valid;

@Controller
@RequestMapping("hoa-don")
public class HoaDonController {
    private HoaDonRepo hdRepo;

    public HoaDonController() {
        this.hdRepo = new HoaDonRepo();
    }

    @GetMapping("/index")
    public String index(@RequestParam(defaultValue = "1") int page, Model model) {
        int pageSize = 2;
        List<HoaDonEntity> ds = this.hdRepo.findAllPaging(page, pageSize);
        int totalPages = this.hdRepo.getTotalPages(pageSize);

        model.addAttribute("data", ds);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);
        return "hoa_don/list";
    }

    @GetMapping("/create")
    public String create(@ModelAttribute("data") HoaDonEntity hoaDonEntity) {
        return "hoa_don/create";
    }

    @PostMapping("/store")
    public String store(@Valid @ModelAttribute("data") HoaDonEntity hoaDonEntity, BindingResult bindingResult,
            Model model) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError error : bindingResult.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }
            model.addAttribute("errors", errors);
            return "hoa_don/create";
        }
        this.hdRepo.create(hoaDonEntity);
        return "redirect:/hoa-don/index";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        this.hdRepo.deleteById(id);
        return "redirect:/hoa-don/index";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model) {
        HoaDonEntity hd = this.hdRepo.findById(id);
        model.addAttribute("data", hd);
        return "hoa_don/edit";
    }

    @PostMapping("update/{id}")
    public String update(@PathVariable("id") Integer id, @Valid @ModelAttribute("data") HoaDonEntity hoaDonEntity,
            BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError error : bindingResult.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }
            model.addAttribute("errors", errors);
            return "hoa_don/edit";
        }

        this.hdRepo.update(hoaDonEntity);
        return "redirect:/hoa-don/index";
    }

    @GetMapping("/search")
    public String search(@RequestParam("keyword") String keyword,
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "2") int pageSize,
            Model model) {
        List<HoaDonEntity> result = this.hdRepo.findByNgayTaoHDPaging(keyword, page, pageSize);
        int totalProducts = this.hdRepo.getTotalProductsByNgayTaoHD(keyword);
        int totalPages = (int) Math.ceil((double) totalProducts / pageSize);

        model.addAttribute("data", result);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("keyword", keyword);
        return "hoa_don/list";
    }
}