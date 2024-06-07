package com.example.buoi_1.repository.asm2;

import com.example.buoi_1.entity.SanPhamChiTietEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SanPhamChiTietRepo extends JpaRepository<SanPhamChiTietEntity, Integer> {
//    @Query("SELECT spct FROM SanPhamChiTietEntity spct WHERE spct.idSP = :idSanPham")
//    Page<SanPhamChiTietEntity> findByIdSP(@Param("idSanPham") Integer idSanPham, Pageable pageable);

    @Query("SELECT spct FROM SanPhamChiTietEntity spct JOIN spct.kichThuoc kt JOIN spct.mauSac ms WHERE spct.sp.id = :idSanPham")
    Page<SanPhamChiTietEntity> findBySpId(@Param("idSanPham") Integer idSanPham, Pageable pageable);


}