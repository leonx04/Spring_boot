package com.example.buoi_1.repository.asm1;

import java.util.ArrayList;
import java.util.List;

import com.example.buoi_1.entity.SanPhamEntity;

public class SanPhamRepo {
    private List<SanPhamEntity> ds;

    public SanPhamRepo() {
        this.ds = new ArrayList<>();
        this.ds.add(new SanPhamEntity(1, "SP01", "Polo Nam", 1));
        this.ds.add(new SanPhamEntity(2, "SP02", "Polo Girl", 0));
    }

    public List<SanPhamEntity> findByNamePaging(String keyword, int page, int pageSize) {
        List<SanPhamEntity> filteredList = findByName(keyword);
        int start = (page - 1) * pageSize;
        int end = start + pageSize;
        return filteredList.subList(start, Math.min(end, filteredList.size()));
    }

    public int getTotalProductsByName(String keyword) {
        return findByName(keyword).size();
    }

    public List<SanPhamEntity> findAllPaging(int page, int pageSize) {
        int start = (page - 1) * pageSize; // Tính chỉ số bắt đầu của trang
        int end = start + pageSize; // Tính chỉ số kết thúc của trang
        return ds.subList(start, Math.min(end, ds.size())); // Trả về danh sách con từ start đến end
    }

    public int getTotalPages(int pageSize) {
        return (int) Math.ceil((double) ds.size() / pageSize); // Tính tổng số trang
    }

    public List<SanPhamEntity> findAll() {
        return this.ds;
    }

    public List<SanPhamEntity> findByName(String keyword) {
        List<SanPhamEntity> result = new ArrayList<>();
        for (SanPhamEntity sp : ds) {
            if (sp.getTen().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(sp);
            }
        }
        return result;
    }

    public void create(SanPhamEntity sp) {
        // sp.setId(this.ds.size() + 1);
        this.ds.add(sp);
    }

    public void deleteByIn(int id) {
        for (int i = 0; i < this.ds.size(); i++) {
            SanPhamEntity sp = this.ds.get(i);
            if (sp.getId() == id) {
                this.ds.remove(i);
            }
        }
    }

    public SanPhamEntity findById(int id) {
        SanPhamEntity ketqua = null;
        for (int i = 0; i < this.ds.size(); i++) {
            SanPhamEntity sp = this.ds.get(i);
            if (sp.getId() == id) {
                ketqua = sp;
            }
        }
        return ketqua;
    }

    public void update(SanPhamEntity sPhamEntity) {
        for (int i = 0; i < this.ds.size(); i++) {
            SanPhamEntity sp = this.ds.get(i);
            if (sp.getId() == sPhamEntity.getId()) {
                this.ds.set(i, sPhamEntity);
            }
        }
    }

}
