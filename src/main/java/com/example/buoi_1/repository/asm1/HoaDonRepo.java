package com.example.buoi_1.repository.asm1;

import java.util.ArrayList;
import java.util.List;
import java.sql.Date;
import java.time.LocalDate;
import java.util.stream.Collectors;

import com.example.buoi_1.entity.HoaDonEntity;

public class HoaDonRepo {
    private List<HoaDonEntity> ds;

//    public HoaDonRepo() {
//        this.ds = new ArrayList<>();
//        this.ds.add(new HoaDonEntity(1, 1, 1, LocalDate.of(2023, 5, 1), 1));
//        this.ds.add(new HoaDonEntity(2, 2, 2, LocalDate.of(2023, 5, 2), 0));
//    }

    public List<HoaDonEntity> findAllPaging(int page, int pageSize) {
        int start = (page - 1) * pageSize;
        int end = start + pageSize;
        return ds.subList(start, Math.min(end, ds.size()));
    }

    public int getTotalPages(int pageSize) {
        return (int) Math.ceil((double) ds.size() / pageSize);
    }

    public List<HoaDonEntity> findByNgayTaoHD(String keyword) {
        return ds.stream()
                .filter(hd -> hd.getNgayMua().toString().contains(keyword))
                .collect(Collectors.toList());
    }

    public List<HoaDonEntity> findByNgayTaoHDPaging(String keyword, int page, int pageSize) {
        List<HoaDonEntity> filteredList = findByNgayTaoHD(keyword);
        int start = (page - 1) * pageSize;
        int end = start + pageSize;
        return filteredList.subList(start, Math.min(end, filteredList.size()));
    }

    public int getTotalProductsByNgayTaoHD(String keyword) {
        return findByNgayTaoHD(keyword).size();
    }

    public List<HoaDonEntity> findAll() {
        return this.ds;
    }

    public void create(HoaDonEntity hd) {
        // Lấy ngày hiện tại
        LocalDate currentDate = LocalDate.now();

        // Tạo một đối tượng HoaDonEntity mới với ngày hiện tại
        HoaDonEntity newHd = new HoaDonEntity(hd.getId(), hd.getNhanVien(), hd.getKhachHang(), currentDate,
                hd.getTrangThai());

        this.ds.add(newHd);
    }

    public void deleteById(int id) {
        for (int i = 0; i < this.ds.size(); i++) {
            HoaDonEntity hd = this.ds.get(i);
            if (hd.getId() == id) {
                this.ds.remove(i);
                break;
            }
        }
    }

    public HoaDonEntity findById(int id) {
        for (int i = 0; i < this.ds.size(); i++) {
            HoaDonEntity hd = this.ds.get(i);
            if (hd.getId() == id) {
                return hd;
            }
        }
        return null;
    }

    public void update(HoaDonEntity hdEntity) {
        for (int i = 0; i < this.ds.size(); i++) {
            HoaDonEntity hd = this.ds.get(i);
            if (hd.getId() == hdEntity.getId()) {
                this.ds.set(i, hdEntity);
            }
        }
    }
}