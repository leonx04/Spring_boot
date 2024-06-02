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
@Table(name = "KhachHang")
public class KhachHangEntity {
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
    @Column(name = "SDT")
    @NotBlank(message = "Số điện thoại không được để trống")
    private String sdt;
    @Column(name = "TrangThai")
    @NotNull
    @Digits(integer = 1, fraction = 0)
    private int trangThai;
}