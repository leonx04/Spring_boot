package com.example.buoi_1.controllers;

import com.example.buoi_1.entity.HoaDonChiTietEntity;
import com.example.buoi_1.entity.HoaDonEntity;
import com.example.buoi_1.entity.SanPhamChiTietEntity;
import com.example.buoi_1.repository.asm2.HoaDonChiTietRepo;
import com.example.buoi_1.repository.asm2.HoaDonRepo;
import com.example.buoi_1.repository.asm2.SanPhamChiTietRepo;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    @Autowired
    private HoaDonChiTietRepo hdctRepo;
    @Autowired
    private HoaDonRepo hoaDonRepo;

    @Autowired
    private SanPhamChiTietRepo spctRepo;

    @GetMapping("/index")
    public String index(@RequestParam(name = "limit", defaultValue = "10") int pageSize,
                        @RequestParam(name = "page", defaultValue = "1") int pageNumber,
                        @RequestParam(name = "idHoaDon", required = false) Integer idHoaDon,
                        Model model) {
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize);
        Page<HoaDonChiTietEntity> page;

        if (idHoaDon != null) {
            page = hdctRepo.findDistinctByIdHoaDonOrderByIdAsc(idHoaDon, pageable);
        } else {
            page = hdctRepo.findAllByOrderByIdAsc(pageable);
        }

        model.addAttribute("data", page);
        model.addAttribute("currentPage", pageNumber);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("idHoaDon", idHoaDon);

        return "hoa_don_chi_tiet/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("data", new HoaDonChiTietEntity());
        return "hoa_don_chi_tiet/create";
    }

    @PostMapping("/store")
    public String store(@Valid @ModelAttribute("data") HoaDonChiTietEntity hdct, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            bindingResult.getFieldErrors().forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
            model.addAttribute("errors", errors);
            return "hoa_don_chi_tiet/create";
        }
        hdctRepo.save(hdct);
        return "redirect:/hoa-don-chi-tiet/index";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model) {
        HoaDonChiTietEntity hdct = hdctRepo.findById(id).orElseThrow();
        model.addAttribute("data", hdct);

        // Thêm danh sách Hóa đơn
        List<HoaDonEntity> listHoaDon = hoaDonRepo.findAll();
        model.addAttribute("listHoaDon", listHoaDon);

        // Thêm danh sách Sản phẩm chi tiết
        List<SanPhamChiTietEntity> listSanPhamChiTiet = spctRepo.findAll();
        model.addAttribute("listSanPhamChiTiet", listSanPhamChiTiet);

        return "hoa_don_chi_tiet/edit";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") Integer id, @Valid @ModelAttribute("data") HoaDonChiTietEntity hdct, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            bindingResult.getFieldErrors().forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
            model.addAttribute("errors", errors);
            return "hoa_don_chi_tiet/edit";
        }
        hdctRepo.save(hdct);
        return "redirect:/hoa-don-chi-tiet/index";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        hdctRepo.deleteById(id);
        return "redirect:/hoa-don-chi-tiet/index";
    }
}