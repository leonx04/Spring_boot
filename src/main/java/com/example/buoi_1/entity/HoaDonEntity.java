package com.example.buoi_1.entity;

import java.sql.Date;
import java.time.LocalDate;

import jakarta.persistence.*;
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
@Entity
@Table(name = "HoaDon")
public class HoaDonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    @NotNull
    private Integer id;
//    @Column(name = "IdNV")
//    @NotNull(message = "ID nhân viên không được để trống")
//    private Integer nhanVien;
    @ManyToOne
    @JoinColumn(name = "IdNV", referencedColumnName = "ID")
    private NhanVienEntity nhanVien;
//    @Column(name = "IdKH")
//    @NotNull(message = "ID khách hàng không được để trống")
//    private Integer khachHang;

    @ManyToOne
    @JoinColumn(name = "IdKH", referencedColumnName = "ID")
    private KhachHangEntity khachHang;
    @Column(name = "NgayMuaHang")
    private LocalDate ngayMua;

    @Column(name = "TrangThai")
    @NotNull
    @Digits(integer = 1, fraction = 0)
    private int trangThai;
}