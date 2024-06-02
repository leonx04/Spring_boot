package com.example.buoi_1.repository.asm2;

import com.example.buoi_1.entity.SanPhamEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SanPhamRepo extends JpaRepository<SanPhamEntity, Integer> {
    Page<SanPhamEntity> findByTenContainingIgnoreCase(String keyword, Pageable pageable);
}