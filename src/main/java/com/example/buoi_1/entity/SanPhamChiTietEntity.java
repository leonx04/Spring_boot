package com.example.buoi_1.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "SanPhamChiTiet")
public class SanPhamChiTietEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "MaSPCT")
    @NotBlank(message = "Mã không được để trống")
    private String ma;
    @ManyToOne
    @JoinColumn(name = "IdKichThuoc",referencedColumnName = "ID" )
    private KichThuocEntity kichThuoc;

    @ManyToOne
    @JoinColumn(name = "IdMauSac" , referencedColumnName = "ID")
    private MauSacEntity mauSac;

    @ManyToOne
    @JoinColumn(name = "IdSanPham", referencedColumnName = "ID")
    private SanPhamEntity sp;
    @Column(name = "SoLuong")
    @NotNull(message = "Số lượng không được để trống")
    @Min(value = 1, message = "Số lượng phải lớn hơn hoặc bằng 1")
    private Integer soLuong;
    @Column(name = "DonGia")
    @NotBlank(message = "Đơn giá không được để trống")
    private String donGia;
    @Column(name = "TrangThai")
    @NotNull(message = "Trạng thái không được để trống")
    @Digits(integer = 1, fraction = 0, message = "Trạng thái phải là số nguyên")
    private int trangThai;
}
