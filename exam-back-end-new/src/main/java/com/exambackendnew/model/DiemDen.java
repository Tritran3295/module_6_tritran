package com.exambackendnew.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class DiemDen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String tenDiemDen;

    @JsonBackReference
    @OneToMany(mappedBy = "diemDen")
    private List<BenXe> benXes;

    public DiemDen() {
    }

    public DiemDen(int id, String tenDiemDen, List<BenXe> benXes) {
        this.id = id;
        this.tenDiemDen = tenDiemDen;
        this.benXes = benXes;
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTenDiemDen() {
        return tenDiemDen;
    }

    public void setTenDiemDen(String tenDiemDen) {
        this.tenDiemDen = tenDiemDen;
    }

    public List<BenXe> getBenXes() {
        return benXes;
    }

    public void setBenXes(List<BenXe> benXes) {
        this.benXes = benXes;
    }
}
