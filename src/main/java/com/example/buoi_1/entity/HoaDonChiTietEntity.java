package com.example.buoi_1.entity;

import java.sql.Date;
import java.time.LocalDate;
import java.math.BigDecimal;
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
public class HoaDonChiTietEntity {
    private Integer id;
    @NotNull(message = "ID hóa đơn không được để trống")
    private Integer idHD;
    @NotNull(message = "ID sản phẩm chi tiết không được để trống")
    private Integer idSPCT;
    @NotNull(message = "Số lượng không được để trống")
    private Integer soLuong;
    @NotNull(message = "Đơn giá không được để trống")
    private BigDecimal donGia;
    private int trangThai;
}
