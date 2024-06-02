package com.example.buoi_1.repository.asm2;

import com.example.buoi_1.entity.KhachHangEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KhachHangRepo extends JpaRepository <KhachHangEntity, Integer> {
    Page<KhachHangEntity> findByTenContainingIgnoreCase(String keyword, Pageable pageable);
}
