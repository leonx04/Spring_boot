package com.example.buoi_1.entity;

import java.math.BigDecimal;

import jakarta.annotation.Generated;
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

    private Integer id;
    @NotBlank(message = "Mã không được để trống")
    private String ma;
    @NotNull(message = "Kích thước không được để trống")
    private Integer idKT;
    @NotNull(message = "Màu sắc không được để trống")
    private Integer idMS;
    @NotNull(message = "Sản phẩm không được để trống")
    private Integer idSP;
    @NotNull(message = "Số lượng không được để trống")
    @Min(value = 1, message = "Số lượng phải lớn hơn hoặc bằng 1")
    private Integer soLuong;
    @NotBlank(message = "Đơn giá không được để trống")
    private String donGia;
    @NotNull(message = "Trạng thái không được để trống")
    @Digits(integer = 1, fraction = 0, message = "Trạng thái phải là số nguyên")
    private int trangThai;
}
