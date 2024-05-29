package com.example.buoi_1.repository.asm1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.example.buoi_1.entity.KichThuocEntity;

public class KichThuocRepo {
    private List<KichThuocEntity> dskt;

    public KichThuocRepo() {
        this.dskt = new ArrayList<>();
        this.dskt.add(new KichThuocEntity(1, "KT01", "S", 1));
        this.dskt.add(new KichThuocEntity(2, "KT02", "M", 0));
    }

    public List<KichThuocEntity> findAllPaging(int page, int pageSize) {
        int start = (page - 1) * pageSize;
        int end = start + pageSize;
        return dskt.subList(start, Math.min(end, dskt.size()));
    }

    public int getTotalPages(int pageSize) {
        return (int) Math.ceil((double) dskt.size() / pageSize);
    }

    public List<KichThuocEntity> findByTen(String keyword) {
        return dskt.stream()
                .filter(kt -> kt.getTen().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<KichThuocEntity> findByTenPaging(String keyword, int page, int pageSize) {
        List<KichThuocEntity> filteredList = findByTen(keyword);
        int start = (page - 1) * pageSize;
        int end = start + pageSize;
        return filteredList.subList(start, Math.min(end, filteredList.size()));
    }

    public int getTotalProductsByTen(String keyword) {
        return findByTen(keyword).size();
    }

    public List<KichThuocEntity> findAllKT() {
        return this.dskt;
    }

    public void create(KichThuocEntity kt) {
        this.dskt.add(kt);
    }

    public void deleteById(int id) {
        for (int i = 0; i < this.dskt.size(); i++) {
            KichThuocEntity kt = this.dskt.get(i);
            if (kt.getId() == id) {
                this.dskt.remove(i);
                break;
            }
        }
    }

    public KichThuocEntity findById(int id) {
        for (int i = 0; i < this.dskt.size(); i++) {
            KichThuocEntity kt = this.dskt.get(i);
            if (kt.getId() == id) {
                return kt;
            }
        }
        return null;
    }

    public void update(KichThuocEntity ktEntity) {
        for (int i = 0; i < this.dskt.size(); i++) {
            KichThuocEntity kt = this.dskt.get(i);
            if (kt.getId() == ktEntity.getId()) {
                this.dskt.set(i, ktEntity);
                break;
            }
        }
    }
}