package com.example.buoi_1.entity;

import jakarta.persistence.*;
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
@Entity
@Table(name = "NhanVien")
public class NhanVienEntity {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(message = "ID không được để trống")
    private Integer id;
    @Column(name = "Ma")
    @NotBlank(message = "Mã không được để trống")
    private String ma;
    @Column(name = "Ten")
    @NotBlank(message = "Tên không được để trống")
    private String ten;
    @Column(name = "TenDangNhap")
    @NotBlank(message = "Tên đăng nhập không được để trống")
    private String tenDN;
    @Column(name = "MatKhau")
    @NotBlank(message = "Mật khẩu không được để trống")
    private String matKhau;
    @Column(name = "TrangThai")
    @NotNull
    @Digits(integer = 1, fraction = 0)
    private int trangThai;
}