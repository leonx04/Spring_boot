package com.example.buoi_1.repository.asm2;

import com.example.buoi_1.entity.HoaDonChiTietEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface HoaDonChiTietRepo extends JpaRepository<HoaDonChiTietEntity, Integer> {
    //    @Query("SELECT hdct FROM HoaDonChiTietEntity hdct WHERE hdct.idHD = :idHoaDon")
//    Page<HoaDonChiTietEntity> findByIdHoaDon(@Param("idHoaDon") Integer idHoaDon, Pageable pageable);
    @Query("SELECT DISTINCT hdct FROM HoaDonChiTietEntity hdct WHERE hdct.idHD = :idHoaDon")
    Page<HoaDonChiTietEntity> findDistinctByIdHoaDon(@Param("idHoaDon") Integer idHoaDon, Pageable pageable);
}