package com.example.buoi_1.repository.asm1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.example.buoi_1.entity.MauSacEntity;
import com.example.buoi_1.entity.MauSacEntity;
public class MauSacRepo {
    private List<MauSacEntity> dsms;

    public MauSacRepo() {
        this.dsms = new ArrayList<>();
        this.dsms.add(new MauSacEntity(1, "MS01", "Xám", 1));
        this.dsms.add(new MauSacEntity(2, "MS02", "Đen", 0));
    }

    public List<MauSacEntity> findAllPaging(int page, int pageSize) {
        int start = (page - 1) * pageSize;
        int end = start + pageSize;
        return dsms.subList(start, Math.min(end, dsms.size()));
    }

    public int getTotalPages(int pageSize) {
        return (int) Math.ceil((double) dsms.size() / pageSize);
    }

    public List<MauSacEntity> findAllMS() {
        return this.dsms;
    }

    public List<MauSacEntity> findByTen(String keyword) {
        return dsms.stream()
                .filter(ms -> ms.getTen().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<MauSacEntity> findByTenPaging(String keyword, int page, int pageSize) {
        List<MauSacEntity> filteredList = findByTen(keyword);
        int start = (page - 1) * pageSize;
        int end = start + pageSize;
        return filteredList.subList(start, Math.min(end, filteredList.size()));
    }

    public int getTotalProductsByTen(String keyword) {
        return findByTen(keyword).size();
    }


    public void create(MauSacEntity ms) {
        this.dsms.add(ms);
    }

    public void deleteByIn(int id) {
        for (int i = 0; i < this.dsms.size(); i++) {
            MauSacEntity ms = this.dsms.get(i);
            if (ms.getId() == id) {
                this.dsms.remove(i);
            }
        }
    }
    public MauSacEntity findById(int id) {
        MauSacEntity ketqua = null;
        for (int i = 0; i < this.dsms.size(); i++) {
            MauSacEntity ms = this.dsms.get(i);
            if (ms.getId() == id) {
                ketqua = ms;
            }
        }
        return ketqua;
    }

    public void update(MauSacEntity msEntity) {
        for (int i = 0; i < this.dsms.size(); i++) {
            MauSacEntity ms = this.dsms.get(i);
            if (ms.getId() == msEntity.getId()) {
                this.dsms.set(i, msEntity);
            }
        }
    }
}
