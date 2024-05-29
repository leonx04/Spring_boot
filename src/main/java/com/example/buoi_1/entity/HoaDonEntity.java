package com.example.buoi_1.entity;

import java.sql.Date;
import java.time.LocalDate;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HoaDonEntity {
    @NotNull
    private Integer id;
    @NotNull(message = "ID nhân viên không được để trống")
    private Integer nhanVien;
    @NotNull(message = "ID khách hàng không được để trống")
    private Integer khachHang;
    
    private LocalDate ngayMua;
    @NotNull
    @Digits(integer = 1, fraction = 0)
    private int trangThai;
}