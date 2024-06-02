package com.example.buoi_1.controllers;

import com.example.buoi_1.entity.NhanVienEntity;
import com.example.buoi_1.entity.UserSession;
import com.example.buoi_1.repository.asm2.NhanVienRepo;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
    @Autowired
    private NhanVienRepo nvRepo;

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("data", new NhanVienEntity());
        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session, HttpServletRequest request) {
        session.removeAttribute("userSession");
        return "home";
    }

    @GetMapping("/home")
    public String showHome(Model model) {
        return "home";
    }

    @GetMapping("/alert")
    public String showAlert(Model model) {
        return "alert";
    }

    @PostMapping("/login")
    public String handleLogin(@ModelAttribute("data") NhanVienEntity data, Model model, HttpSession session) {
        String tenDN = data.getTenDN();
        String matKhau = data.getMatKhau();

        if (tenDN == null || tenDN.trim().isEmpty()) {
            model.addAttribute("errorTenDN", "Tên đăng nhập không được để trống.");
        }

        if (matKhau == null || matKhau.trim().isEmpty()) {
            model.addAttribute("errorMatKhau", "Mật khẩu không được để trống.");
        }

        if (model.asMap().containsKey("errorTenDN") || model.asMap().containsKey("errorMatKhau")) {
            return "login";
        }

        NhanVienEntity nv = nvRepo.findByTenDNAndMatKhau(tenDN, matKhau);

        if (nv == null) {
            model.addAttribute("errorMessage", "Tên đăng nhập hoặc mật khẩu không đúng.");
            return "login";
        } else {
            UserSession userSession = new UserSession();
            userSession.setLoggedIn(true);
            userSession.setLoggedInUser(nv);
            if (nv.getTrangThai() == 1) {
                userSession.setRole("ADMIN");
                model.addAttribute("successMessage", "Đăng nhập thành công với quyền Admin.");
            } else {
                userSession.setRole("USER");
                model.addAttribute("successMessage", "Đăng nhập thành công với quyền Nhân viên.");
            }
            session.setAttribute("userSession", userSession);
            return "redirect:/home";
        }
    }
}