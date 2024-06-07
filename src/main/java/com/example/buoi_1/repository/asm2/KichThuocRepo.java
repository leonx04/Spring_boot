package com.example.buoi_1.repository.asm2;

import com.example.buoi_1.entity.KichThuocEntity;
import com.example.buoi_1.entity.SanPhamEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface KichThuocRepo extends JpaRepository<KichThuocEntity, Integer> {
    Page<KichThuocEntity> findByTenContainingIgnoreCase(String keyword, Pageable pageable);

    @Query("SELECT DISTINCT kt FROM KichThuocEntity kt")
    List<KichThuocEntity> findDistinct();
}
