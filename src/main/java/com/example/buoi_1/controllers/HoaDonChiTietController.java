package com.example.buoi_1.controllers;

import com.example.buoi_1.entity.HoaDonChiTietEntity;
import com.example.buoi_1.repository.asm1.HoaDonChiTietRepo;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("hoa-don-chi-tiet")
public class HoaDonChiTietController {
    private HoaDonChiTietRepo hdctRepo;

    public HoaDonChiTietController() {
        this.hdctRepo = new HoaDonChiTietRepo();
    }

    @GetMapping("/index")
    public String index(Model model, @RequestParam(value = "hd", required = false) String idHoaDon,
            @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "2") int pageSize) {
        Integer idHoaDonInt = null;
        try {
            idHoaDonInt = idHoaDon != null ? Integer.parseInt(idHoaDon) : null;
        } catch (NumberFormatException e) {
            model.addAttribute("message", "Vui lòng nhập ID hóa đơn là một số nguyên");
        }

        if (idHoaDonInt != null) {
            List<HoaDonChiTietEntity> dshd = hdctRepo.findByIdHoaDonPaging(idHoaDonInt, page, pageSize);
            int totalProducts = hdctRepo.getTotalProductsByIdHoaDon(idHoaDonInt);
            int totalPages = (int) Math.ceil((double) totalProducts / pageSize);
            model.addAttribute("data", dshd);
            model.addAttribute("currentPage", page);
            model.addAttribute("totalPages", totalPages);
            model.addAttribute("keyword", idHoaDonInt);
            if (totalProducts == 0) {
                model.addAttribute("message", "Không có hóa đơn chi tiết trùng với ID hóa đơn " + idHoaDonInt);
            }
        } else {
            model.addAttribute("data", hdctRepo.findAllPaging(page, pageSize));
            int totalPages = hdctRepo.getTotalPages(pageSize);
            model.addAttribute("currentPage", page);
            model.addAttribute("totalPages", totalPages);
        }
        return "hoa_don_chi_tiet/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("data", new HoaDonChiTietEntity());
        return "hoa_don_chi_tiet/create";
    }

    @PostMapping("/store")
    public String store(@Valid @ModelAttribute("data") HoaDonChiTietEntity hdct, BindingResult bindingResult,
            Model model) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            bindingResult.getFieldErrors().forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
            model.addAttribute("errors", errors);
            return "hoa_don_chi_tiet/create";
        }
        hdctRepo.create(hdct);
        return "redirect:/hoa-don-chi-tiet/index";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") int id, Model model) {
        HoaDonChiTietEntity hdct = hdctRepo.findById(id);
        model.addAttribute("data", hdct);
        return "hoa_don_chi_tiet/edit";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") int id, @Valid @ModelAttribute("data") HoaDonChiTietEntity hdct,
            BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            bindingResult.getFieldErrors().forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
            model.addAttribute("errors", errors);
            return "hoa_don_chi_tiet/edit";
        }
        hdctRepo.update(hdct);
        return "redirect:/hoa-don-chi-tiet/index";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        hdctRepo.deleteById(id);
        return "redirect:/hoa-don-chi-tiet/index";
    }
}