package com.example.buoi_1.repository.asm1;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.example.buoi_1.entity.HoaDonChiTietEntity;

public class HoaDonChiTietRepo {
    private List<HoaDonChiTietEntity> dshd;

//    public HoaDonChiTietRepo() {
//        this.dshd = new ArrayList<>();
//        this.dshd.add(new HoaDonChiTietEntity(1, 1, 1, 2, new BigDecimal(20000), 1));
//        this.dshd.add(new HoaDonChiTietEntity(2, 2, 2, 3, new BigDecimal(30000), 0));
//    }

    public List<HoaDonChiTietEntity> findAllPaging(int page, int pageSize) {
        int start = (page - 1) * pageSize;
        int end = start + pageSize;
        return dshd.subList(start, Math.min(end, dshd.size()));
    }

    public int getTotalPages(int pageSize) {
        return (int) Math.ceil((double) dshd.size() / pageSize);
    }

    public List<HoaDonChiTietEntity> findAll() {
        return this.dshd;
    }

    public void create(HoaDonChiTietEntity hdct) {
        hdct.setId(this.dshd.size() + 1);
        this.dshd.add(hdct);
    }

    public List<HoaDonChiTietEntity> findByIdHoaDonPaging(int idHoaDon, int page, int pageSize) {
        List<HoaDonChiTietEntity> filteredList = findByIdHoaDon(idHoaDon);
        int totalItems = filteredList.size();
        int totalPages = (int) Math.ceil((double) totalItems / pageSize);

        if (page > totalPages && totalPages > 0) {
            page = totalPages;
        }

        int start = (page - 1) * pageSize;
        int end = Math.min(start + pageSize, totalItems);

        return filteredList.subList(start, end);
    }

    public int getTotalProductsByIdHoaDon(int idHoaDon) {
        return findByIdHoaDon(idHoaDon).size();
    }

    public void deleteById(int id) {
        for (int i = 0; i < this.dshd.size(); i++) {
            HoaDonChiTietEntity hdct = this.dshd.get(i);
            if (hdct.getId() == id) {
                this.dshd.remove(i);
                break;
            }
        }
    }

    public HoaDonChiTietEntity findById(int id) {
        for (HoaDonChiTietEntity hdct : dshd) {
            if (hdct.getId() == id) {
                return hdct;
            }
        }
        return null;
    }

    public void update(HoaDonChiTietEntity hdct) {
        for (int i = 0; i < dshd.size(); i++) {
            if (dshd.get(i).getId() == hdct.getId()) {
                dshd.set(i, hdct);
                break;
            }
        }
    }

    public List<HoaDonChiTietEntity> findByIdHoaDon(int idHoaDon) {
        return dshd.stream()
                .filter(hdct -> hdct.getIdHD() == idHoaDon)
                .collect(Collectors.toList());
    }
}