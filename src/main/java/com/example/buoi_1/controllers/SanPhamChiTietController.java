package com.example.buoi_1.controllers;

import com.example.buoi_1.entity.KichThuocEntity;
import com.example.buoi_1.entity.MauSacEntity;
import com.example.buoi_1.entity.SanPhamChiTietEntity;
import com.example.buoi_1.entity.SanPhamEntity;
import com.example.buoi_1.repository.asm2.KichThuocRepo;
import com.example.buoi_1.repository.asm2.MauSacRepo;
import com.example.buoi_1.repository.asm2.SanPhamChiTietRepo;
import com.example.buoi_1.repository.asm2.SanPhamRepo;
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
import java.util.stream.Collectors;

@Controller
@RequestMapping("san-pham-chi-tiet")
public class SanPhamChiTietController {
    @Autowired
    private SanPhamChiTietRepo spctRepo;

    @Autowired
    private SanPhamRepo spRepo;

    @Autowired
    private MauSacRepo mauSacRepo;

    @Autowired
    private KichThuocRepo kichThuocRepo;

    @GetMapping("/index")
    public String index(@RequestParam(name = "limit", defaultValue = "10") int pageSize,
                        @RequestParam(name = "page", defaultValue = "1") int pageNumber,
                        @RequestParam(name = "idSanPham", required = false) Integer idSanPham,
                        Model model) {
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize);
        Page<SanPhamChiTietEntity> page;
        List<SanPhamEntity> dssp = spRepo.findAll();
        model.addAttribute("sp", dssp);

        if (idSanPham != null) {
            page = spctRepo.findBySpId(idSanPham, pageable);
        } else {
            page = spctRepo.findAll(pageable);
        }

        model.addAttribute("data", page);
        model.addAttribute("currentPage", pageNumber);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("idSanPham", idSanPham);

        return "san_pham_chi_tiet/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        List<MauSacEntity> listMauSac = mauSacRepo.findAll();
        List<KichThuocEntity> listKichThuoc = kichThuocRepo.findAll();
        List<SanPhamEntity> listSanPham = spRepo.findAll();

        model.addAttribute("listMauSac", listMauSac);
        model.addAttribute("listKichThuoc", listKichThuoc);
        model.addAttribute("listSanPham", listSanPham);
        model.addAttribute("data", new SanPhamChiTietEntity());

        return "san_pham_chi_tiet/create";
    }

    @PostMapping("/store")
    public String store(@Valid @ModelAttribute("data") SanPhamChiTietEntity spct, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            bindingResult.getFieldErrors().forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
            model.addAttribute("errors", errors);

            // Thêm dữ liệu cho các danh sách sản phẩm, màu sắc và kích thước
            List<MauSacEntity> listMauSac = mauSacRepo.findAll();
            List<KichThuocEntity> listKichThuoc = kichThuocRepo.findAll();
            List<SanPhamEntity> listSanPham = spRepo.findAll();

            model.addAttribute("listMauSac", listMauSac);
            model.addAttribute("listKichThuoc", listKichThuoc);
            model.addAttribute("listSanPham", listSanPham);

            return "san_pham_chi_tiet/create";
        }
        spctRepo.save(spct);
        return "redirect:/san-pham-chi-tiet/index";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model) {
        SanPhamChiTietEntity spct = spctRepo.findById(id).orElseThrow();
        List<SanPhamEntity> listSanPham = spRepo.findAll();
//                .stream().limit(30).collect(Collectors.toList());
        List<KichThuocEntity> listKichThuoc = kichThuocRepo.findAll();
        List<MauSacEntity> listMauSac = mauSacRepo.findAll();

        model.addAttribute("data", spct);
        model.addAttribute("listSanPham", listSanPham);
        model.addAttribute("listKichThuoc", listKichThuoc);
        model.addAttribute("listMauSac", listMauSac);

        return "san_pham_chi_tiet/edit";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") Integer id, @Valid @ModelAttribute("data") SanPhamChiTietEntity spct, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            bindingResult.getFieldErrors().forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
            model.addAttribute("errors", errors);
            return "san_pham_chi_tiet/edit";
        }
        spctRepo.save(spct);
        return "redirect:/san-pham-chi-tiet/index";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        spctRepo.deleteById(id);
        return "redirect:/san-pham-chi-tiet/index";
    }


}