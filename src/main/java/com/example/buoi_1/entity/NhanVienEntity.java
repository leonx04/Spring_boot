package com.example.buoi_1.entity;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NhanVienEntity {
    @NotNull(message = "ID không được để trống")
    private Integer id;
    @NotBlank(message = "Mã không được để trống")
    private String ma;
    @NotBlank(message = "Tên không được để trống")
    private String ten;
    @NotBlank(message = "Tên đăng nhập không được để trống")
    private String tenDN;
    @NotBlank(message = "Mật khẩu không được để trống")
    private String matKhau;
    @NotNull
    @Digits(integer = 1, fraction = 0)
    private int trangThai;
}