package com.example.buoi_1.repository.asm2;

import com.example.buoi_1.entity.MauSacEntity;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MauSacRepo extends JpaRepository<MauSacEntity, Integer> {
    Page<MauSacEntity> findByTenContainingIgnoreCase(String keyword, Pageable pageable);

    @Query("SELECT DISTINCT ms FROM MauSacEntity ms")
    List<MauSacEntity> findDistinct();
}
