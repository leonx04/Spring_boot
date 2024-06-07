package com.example.buoi_1.controllers;

import com.example.buoi_1.entity.HoaDonChiTietEntity;
import com.example.buoi_1.entity.HoaDonEntity;
import com.example.buoi_1.entity.SanPhamChiTietEntity;
import com.example.buoi_1.repository.asm2.HoaDonChiTietRepo;
import com.example.buoi_1.repository.asm2.HoaDonRepo;
import com.example.buoi_1.repository.asm2.SanPhamChiTietRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("ban-hang")
public class BanHangControllers {

    @Autowired
    private HoaDonRepo hoaDonRepo;

    @Autowired
    private HoaDonChiTietRepo hoaDonChiTietRepo;

    @Autowired
    private SanPhamChiTietRepo sanPhamChiTietRepo;

    @GetMapping("/index")
    public String index(@RequestParam(name = "limit", defaultValue = "10") int pageSize,
                        @RequestParam(name = "page", defaultValue = "1") int pageNumber,
                        Model model) {
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize);

        Page<HoaDonEntity> pageHoaDon = hoaDonRepo.findAll(pageable);
        Page<SanPhamChiTietEntity> pageSanPhamChiTiet = sanPhamChiTietRepo.findAll(pageable);

        model.addAttribute("dataHoaDon", pageHoaDon);
        model.addAttribute("dataSanPhamChiTiet", pageSanPhamChiTiet);
        model.addAttribute("currentPage", pageNumber);
        model.addAttribute("totalPages", pageHoaDon.getTotalPages());

        return "banhang";
    }
}