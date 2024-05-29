package com.example.buoi_1.repository.asm1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.example.buoi_1.entity.SanPhamChiTietEntity;

public class SanPhamChiTietRepo {
    private List<SanPhamChiTietEntity> dscpct;

    public SanPhamChiTietRepo() {
        this.dscpct = new ArrayList<>();
        this.dscpct.add(new SanPhamChiTietEntity(1, "SPCT01", 1, 1, 1, 10, "1000", 1));
        this.dscpct.add(new SanPhamChiTietEntity(2, "SPCT02", 1, 1, 2, 20, "2000", 1));
        this.dscpct.add(new SanPhamChiTietEntity(3, "SPCT03", 1, 1, 1, 30, "3000", 1));
    }

    public List<SanPhamChiTietEntity> findAllPaging(int page, int pageSize) {
        int start = (page - 1) * pageSize;
        int end = start + pageSize;
        return dscpct.subList(start, Math.min(end, dscpct.size()));
    }

    public int getTotalPages(int pageSize) {
        return (int) Math.ceil((double) dscpct.size() / pageSize);
    }

    public List<SanPhamChiTietEntity> findAllspct() {
        return this.dscpct;
    }

    public void create(SanPhamChiTietEntity spct) {
        spct.setId(this.dscpct.size() + 1);
        this.dscpct.add(spct);
    }

    public List<SanPhamChiTietEntity> findByIdSanPhamPaging(int idSanPham, int page, int pageSize) {
        List<SanPhamChiTietEntity> filteredList = findByIdSanPham(idSanPham);
        int start = (page - 1) * pageSize;
        int end = start + pageSize;
        return filteredList.subList(start, Math.min(end, filteredList.size()));
    }

    public int getTotalProductsByIdSanPham(int idSanPham) {
        return findByIdSanPham(idSanPham).size();
    }

    public void deleteById(int id) {
        for (int i = 0; i < this.dscpct.size(); i++) {
            SanPhamChiTietEntity spct = this.dscpct.get(i);
            if (spct.getId() == id) {
                this.dscpct.remove(i);
                break;
            }
        }
    }

    public SanPhamChiTietEntity findById(int id) {
        for (SanPhamChiTietEntity spct : dscpct) {
            if (spct.getId() == id) {
                return spct;
            }
        }
        return null;
    }

    public void update(SanPhamChiTietEntity spct) {
        for (int i = 0; i < dscpct.size(); i++) {
            if (dscpct.get(i).getId() == spct.getId()) {
                dscpct.set(i, spct);
                break;
            }
        }
    }

    public List<SanPhamChiTietEntity> findByIdSanPham(int idSanPham) {
        return dscpct.stream()
                .filter(spct -> spct.getIdSP() == idSanPham)
                .collect(Collectors.toList());
    }
}