package com.example.buoi_1.repository.asm2;

import com.example.buoi_1.entity.NhanVienEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface NhanVienRepo extends JpaRepository<NhanVienEntity, Integer> {
    Page<NhanVienEntity> findByTenContainingIgnoreCase(String keyword, Pageable pageable);

    @Query("SELECT nv FROM NhanVienEntity nv WHERE nv.tenDN = :tenDN AND nv.matKhau = :matKhau")
    NhanVienEntity findByTenDNAndMatKhau(@Param("tenDN") String tenDN, @Param("matKhau") String matKhau);
}