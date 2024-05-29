package com.example.buoi_1.repository.asm1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.example.buoi_1.entity.NhanVienEntity;

public class NhanVienRepo {
    private List<NhanVienEntity> dsnv;

    public NhanVienRepo() {
        this.dsnv = new ArrayList<>();
        this.dsnv.add(new NhanVienEntity(1, "NV01", "Nguyen Xuan Dung", "DUNGNX", "dungnx123", 1));
        this.dsnv.add(new NhanVienEntity(2, "NV02", "Le Van Anh", "AnhLV", "anhlv123", 0));
        this.dsnv.add(new NhanVienEntity(3, "NV03", "Le Van Nam", "NamLV", "namlv123", 1));
    }

    public List<NhanVienEntity> findAllPaging(int page, int pageSize) {
        int start = (page - 1) * pageSize;
        int end = start + pageSize;
        return dsnv.subList(start, Math.min(end, dsnv.size()));
    }

    public int getTotalPages(int pageSize) {
        return (int) Math.ceil((double) dsnv.size() / pageSize);
    }

    public List<NhanVienEntity> findByTen(String keyword) {
        return dsnv.stream()
                .filter(nv -> nv.getTen().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<NhanVienEntity> findByTenPaging(String keyword, int page, int pageSize) {
        List<NhanVienEntity> filteredList = findByTen(keyword);
        int start = (page - 1) * pageSize;
        int end = start + pageSize;
        return filteredList.subList(start, Math.min(end, filteredList.size()));
    }

    public int getTotalProductsByTen(String keyword) {
        return findByTen(keyword).size();
    }

    public List<NhanVienEntity> findAllNV() {
        return this.dsnv;
    }

    public void create(NhanVienEntity nv) {
        this.dsnv.add(nv);
    }

    public void deleteById(int id) {
        for (int i = 0; i < this.dsnv.size(); i++) {
            NhanVienEntity nv = this.dsnv.get(i);
            if (nv.getId() == id) {
                this.dsnv.remove(i);
                break;
            }
        }
    }

    public NhanVienEntity findById(int id) {
        for (int i = 0; i < this.dsnv.size(); i++) {
            NhanVienEntity nv = this.dsnv.get(i);
            if (nv.getId() == id) {
                return nv;
            }
        }
        return null;
    }

    public void update(NhanVienEntity nvEntity) {
        for (int i = 0; i < this.dsnv.size(); i++) {
            NhanVienEntity nv = this.dsnv.get(i);
            if (nv.getId() == nvEntity.getId()) {
                this.dsnv.set(i, nvEntity);
                break;
            }
        }
    }

    public NhanVienEntity findByTenDNAndMatKhau(String tenDN, String matKhau) {
        for (NhanVienEntity nv : dsnv) {
            if (nv.getTenDN().equals(tenDN) && nv.getMatKhau().equals(matKhau)) {
                return nv;
            }
        }
        return null;
    }
}