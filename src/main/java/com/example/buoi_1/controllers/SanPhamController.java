package com.example.buoi_1.controllers;

import java.util.List;

import jakarta.validation.Valid;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.example.buoi_1.entity.SanPhamEntity;
import com.example.buoi_1.repository.asm1.SanPhamRepo;
import jakarta.validation.Valid;


@Controller
@RequestMapping("san-pham")
public class SanPhamController {
    private SanPhamRepo spRepo;

    public SanPhamController()
    {
        this.spRepo = new SanPhamRepo();
    }


    /**
     * @param model
     * @return
     */
    @GetMapping("/index")
    public String index(@RequestParam(defaultValue = "1") int page, Model model) {
        int pageSize = 2; // Số bản ghi hiển thị trên mỗi trang
        List<SanPhamEntity> ds = this.spRepo.findAllPaging(page, pageSize);
        int totalPages = this.spRepo.getTotalPages(pageSize);

        model.addAttribute("data", ds);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);
        return "san_pham/list";
    }

    // @RequestMapping("san-pham/create")
    @GetMapping("/create")
    public String create(@ModelAttribute("data") SanPhamEntity sanPhamEntity) {
        return "san_pham/create";
    }
    @PostMapping("/store")
    public String store( Model model,@Valid SanPhamEntity sanPhamEntity, BindingResult validate) {
        if (validate.hasErrors()) {
            //Loi
            model.addAttribute("data", sanPhamEntity);
            Map<String, String> errors = new HashMap<>();
            for (FieldError e : validate.getFieldErrors()) {
                errors.put(e.getField(),e.getDefaultMessage());
            }
            model.addAttribute("data", sanPhamEntity);
            model.addAttribute("errors", errors);
            return "san_pham/create";
        }
        this.spRepo.create(sanPhamEntity);
        return "redirect:/san-pham/index";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        this.spRepo.deleteByIn(id);
        return "redirect:/san-pham/index";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model) {
        SanPhamEntity sp = this.spRepo.findById(id);
        model.addAttribute("data", sp);
        return "san_pham/edit";
    }

    @PostMapping("update/{id}")
    public String update(@PathVariable("id") Integer id, @Valid SanPhamEntity sp, BindingResult validate, Model model) {
        if (validate.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError e : validate.getFieldErrors()) {
                errors.put(e.getField(), e.getDefaultMessage());
            }
            model.addAttribute("data", sp);
            model.addAttribute("errors", errors);
            return "san_pham/edit";
        }

        this.spRepo.update(sp);
        return "redirect:/san-pham/index";
    }

    @GetMapping("/search")
    public String search(@RequestParam("keyword") String keyword,
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "2") int pageSize,
            Model model) {
        List<SanPhamEntity> result = this.spRepo.findByNamePaging(keyword, page, pageSize);
        int totalProducts = this.spRepo.getTotalProductsByName(keyword);
        int totalPages = (int) Math.ceil((double) totalProducts / pageSize);

        model.addAttribute("data", result);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("keyword", keyword);
        return "san_pham/list";
    }

}
