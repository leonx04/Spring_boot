package com.example.buoi_1.controllers;

import com.example.buoi_1.entity.SanPhamChiTietEntity;
import com.example.buoi_1.entity.SanPhamEntity;
import com.example.buoi_1.repository.asm1.SanPhamChiTietRepo;
import com.example.buoi_1.repository.asm1.SanPhamRepo;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("san-pham-chi-tiet")
public class SanPhamChiTietController {
    private SanPhamChiTietRepo spctRepo;
    private SanPhamRepo spRepo;

    public SanPhamChiTietController() {
        this.spctRepo = new SanPhamChiTietRepo();
        this.spRepo = new SanPhamRepo();
    }

    @GetMapping("/index")
    public String index(Model model, @RequestParam(value = "sp", required = false) Integer idSanPham,
            @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "2") int pageSize) {
        List<SanPhamChiTietEntity> dsspct;
        List<SanPhamEntity> dssp = this.spRepo.findAll();
        model.addAttribute("sp", dssp);

        if (idSanPham != null) {
            dsspct = this.spctRepo.findByIdSanPhamPaging(idSanPham, page, pageSize);
            int totalProducts = this.spctRepo.getTotalProductsByIdSanPham(idSanPham);
            int totalPages = (int) Math.ceil((double) totalProducts / pageSize);
            model.addAttribute("currentPage", page);
            model.addAttribute("totalPages", totalPages);
            model.addAttribute("keyword", idSanPham);
        } else {
            dsspct = this.spctRepo.findAllPaging(page, pageSize);
            int totalPages = this.spctRepo.getTotalPages(pageSize);
            model.addAttribute("currentPage", page);
            model.addAttribute("totalPages", totalPages);
        }

        model.addAttribute("data", dsspct);
        return "san_pham_chi_tiet/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("data", new SanPhamChiTietEntity());
        return "san_pham_chi_tiet/create";
    }

    @PostMapping("/store")
    public String store(@Valid @ModelAttribute("data") SanPhamChiTietEntity spct, BindingResult bindingResult,
            Model model) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            bindingResult.getFieldErrors().forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
            model.addAttribute("errors", errors);
            return "san_pham_chi_tiet/create";
        }
        spctRepo.create(spct);
        return "redirect:/san-pham-chi-tiet/index";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") int id, Model model) {
        SanPhamChiTietEntity spct = spctRepo.findById(id);
        model.addAttribute("data", spct);
        return "san_pham_chi_tiet/edit";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") int id, @Valid @ModelAttribute("data") SanPhamChiTietEntity spct,
            BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            bindingResult.getFieldErrors().forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
            model.addAttribute("errors", errors);
            return "san_pham_chi_tiet/edit";
        }
        spctRepo.update(spct);
        return "redirect:/san-pham-chi-tiet/index";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        spctRepo.deleteById(id);
        return "redirect:/san-pham-chi-tiet/index";
    }
}