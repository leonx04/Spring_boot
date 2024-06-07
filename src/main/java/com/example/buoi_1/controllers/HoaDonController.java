package com.example.buoi_1.controllers;

import com.example.buoi_1.entity.HoaDonEntity;
import com.example.buoi_1.entity.KhachHangEntity;
import com.example.buoi_1.entity.NhanVienEntity;
import com.example.buoi_1.repository.asm2.HoaDonRepo;
import com.example.buoi_1.repository.asm2.KhachHangRepo;
import com.example.buoi_1.repository.asm2.NhanVienRepo;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("hoa-don")
public class HoaDonController {
    @Autowired
    private HoaDonRepo hdRepo;

    @Autowired
    private NhanVienRepo nvRepo;

    @Autowired
    private KhachHangRepo khRepo;

    @GetMapping("/index")
    public String index(@RequestParam(name = "limit", defaultValue = "10") int pageSize,
                        @RequestParam(name = "page", defaultValue = "1") int pageNumber,
                        @RequestParam(name = "idNhanVien", required = false) Integer idNhanVien,
                        @RequestParam(name = "idKhachHang", required = false) Integer idKhachHang,
                        Model model) {
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize);
        Page<HoaDonEntity> page;
        List<NhanVienEntity> dsnv = nvRepo.findAll(Sort.by(Sort.Direction.ASC, "ten")); // Sắp xếp tên nhân viên theo thứ tự A-Z
        List<KhachHangEntity> dskh = khRepo.findAll(Sort.by(Sort.Direction.ASC, "ten")); // Sắp xếp tên khách hàng theo thứ tự A-Z
        model.addAttribute("nv", dsnv);
        model.addAttribute("kh", dskh);

        if (idNhanVien != null && idKhachHang != null) {
            page = hdRepo.findByIdNVAndIdKH(idNhanVien, idKhachHang, pageable);
        } else if (idNhanVien != null) {
            page = hdRepo.findByIdNV(idNhanVien, pageable);
        } else if (idKhachHang != null) {
            page = hdRepo.findByIdKH(idKhachHang, pageable);
        } else {
            page = hdRepo.findAll(pageable);
        }

        model.addAttribute("data", page);
        model.addAttribute("currentPage", pageNumber);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("idNhanVien", idNhanVien);
        model.addAttribute("idKhachHang", idKhachHang);

        return "hoa_don/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("data", new HoaDonEntity());
        List<NhanVienEntity> dsnv = nvRepo.findAll(Sort.by(Sort.Direction.ASC, "ten"));
        List<KhachHangEntity> dskh = khRepo.findAll(Sort.by(Sort.Direction.ASC, "ten"));
        model.addAttribute("nv", dsnv);
        model.addAttribute("kh", dskh);
        return "hoa_don/create";
    }



    @PostMapping("/store")
    public String store(@Valid @ModelAttribute("data") HoaDonEntity hoaDon, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            bindingResult.getFieldErrors().forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
            model.addAttribute("errors", errors);
            return "hoa_don/create";
        }
        hdRepo.save(hoaDon);
        return "redirect:/hoa-don/index";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model) {
        HoaDonEntity hoaDon = hdRepo.findById(id).orElseThrow();
        model.addAttribute("data", hoaDon);
        List<NhanVienEntity> dsnv = nvRepo.findAll(Sort.by(Sort.Direction.ASC, "ten"));
        List<KhachHangEntity> dskh = khRepo.findAll(Sort.by(Sort.Direction.ASC, "ten"));
        model.addAttribute("nv", dsnv);
        model.addAttribute("kh", dskh);
        return "hoa_don/edit";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") Integer id, @Valid @ModelAttribute("data") HoaDonEntity hoaDon, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            bindingResult.getFieldErrors().forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
            model.addAttribute("errors", errors);
            List<NhanVienEntity> dsnv = nvRepo.findAll(Sort.by(Sort.Direction.ASC, "ten"));
            List<KhachHangEntity> dskh = khRepo.findAll(Sort.by(Sort.Direction.ASC, "ten"));
            model.addAttribute("nv", dsnv);
            model.addAttribute("kh", dskh);
            return "hoa_don/edit";
        }

        // Tìm đối tượng KhachHangEntity tương ứng
        Integer khachHangId = hoaDon.getKhachHang().getId();
        KhachHangEntity khachHang = khRepo.findById(khachHangId).orElse(null);
        hoaDon.setKhachHang(khachHang); // Gán đối tượng KhachHangEntity cho thuộc tính khachHang

        // Tìm đối tượng NhanVienEntity tương ứng (nếu cần)
        Integer nhanVienId = hoaDon.getNhanVien().getId();
        NhanVienEntity nhanVien = nvRepo.findById(nhanVienId).orElse(null);
        hoaDon.setNhanVien(nhanVien);

        hdRepo.save(hoaDon);
        return "redirect:/hoa-don/index";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        hdRepo.deleteById(id);
        return "redirect:/hoa-don/index";
    }
}