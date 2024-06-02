package com.example.buoi_1.entity;

import java.sql.Date;
import java.time.LocalDate;
import java.math.BigDecimal;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.example.buoi_1.entity.KhachHangEntity;
import com.example.buoi_1.entity.NhanVienEntity;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "HoaDonChiTiet")
public class HoaDonChiTietEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "IdHoaDon")
    @NotNull(message = "ID hóa đơn không được để trống")
    private Integer idHD;
    @Column(name = "IdSPCT")
    @NotNull(message = "ID sản phẩm chi tiết không được để trống")
    private Integer idSPCT;
    @Column(name = "SoLuong")
    @NotNull(message = "Số lượng không được để trống")
    private Integer soLuong;
    @Column(name = "DonGia")
    @NotNull(message = "Đơn giá không được để trống")
    private BigDecimal donGia;
    @Column(name = "ThoiGian")
    private LocalDate thoiGian;
    @Column(name = "TrangThai")
    private int trangThai;
}
