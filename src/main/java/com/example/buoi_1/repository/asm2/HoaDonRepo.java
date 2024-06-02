package com.example.buoi_1.repository.asm2;

import com.example.buoi_1.entity.HoaDonEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface HoaDonRepo extends JpaRepository<HoaDonEntity, Integer> {


    @Query("SELECT hd FROM HoaDonEntity hd JOIN hd.nhanVien nv WHERE nv.id = :idNhanVien")
    Page<HoaDonEntity> findByIdNV(@Param("idNhanVien") Integer idNhanVien, Pageable pageable);

    // Thêm phương thức tìm kiếm theo khách hàng
    @Query("SELECT hd FROM HoaDonEntity hd JOIN hd.khachHang kh WHERE kh.id = :idKhachHang")
    Page<HoaDonEntity> findByIdKH(@Param("idKhachHang") Integer idKhachHang, Pageable pageable);

    @Query("SELECT hd FROM HoaDonEntity hd JOIN hd.nhanVien nv JOIN hd.khachHang kh WHERE nv.id = :idNhanVien AND kh.id = :idKhachHang")
    Page<HoaDonEntity> findByIdNVAndIdKH(@Param("idNhanVien") Integer idNhanVien, @Param("idKhachHang") Integer idKhachHang, Pageable pageable);
}