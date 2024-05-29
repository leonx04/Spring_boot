package com.example.buoi_1.repository.asm1;

import com.example.buoi_1.entity.KhachHangEntity;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class KhachHangRepo {
    private List<KhachHangEntity> dskh;

    public KhachHangRepo() {
        this.dskh = new ArrayList<>();
        this.dskh.add(new KhachHangEntity(1, "KH01", "Nguyen Xuan Dung", "0123456789", 1));
        this.dskh.add(new KhachHangEntity(2, "KH02", "Hoang Ba Manh", "0123456789", 0));
    }

    public List<KhachHangEntity> findAllPaging(int page, int pageSize) {
        int start = (page - 1) * pageSize;
        int end = start + pageSize;
        return dskh.subList(start, Math.min(end, dskh.size()));
    }

    public int getTotalPages(int pageSize) {
        return (int) Math.ceil((double) dskh.size() / pageSize);
    }

    public List<KhachHangEntity> findByTen(String keyword) {
        return dskh.stream()
                .filter(kh -> kh.getTen().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<KhachHangEntity> findByTenPaging(String keyword, int page, int pageSize) {
        List<KhachHangEntity> filteredList = findByTen(keyword);
        int start = (page - 1) * pageSize;
        int end = start + pageSize;
        return filteredList.subList(start, Math.min(end, filteredList.size()));
    }

    public int getTotalProductsByTen(String keyword) {
        return findByTen(keyword).size();
    }

    public List<KhachHangEntity> findAllKH() {
        return this.dskh;
    }

    public void create(KhachHangEntity kh) {
        this.dskh.add(kh);
    }

    public void deleteById(int id) {
        for (int i = 0; i < this.dskh.size(); i++) {
            KhachHangEntity kh = this.dskh.get(i);
            if (kh.getId() == id) {
                this.dskh.remove(i);
                break;
            }
        }
    }

    public KhachHangEntity findById(int id) {
        for (int i = 0; i < this.dskh.size(); i++) {
            KhachHangEntity kh = this.dskh.get(i);
            if (kh.getId() == id) {
                return kh;
            }
        }
        return null;
    }

    public void update(KhachHangEntity khEntity) {
        for (int i = 0; i < this.dskh.size(); i++) {
            KhachHangEntity kh = this.dskh.get(i);
            if (kh.getId() == khEntity.getId()) {
                this.dskh.set(i, khEntity);
                break;
            }
        }
    }
}