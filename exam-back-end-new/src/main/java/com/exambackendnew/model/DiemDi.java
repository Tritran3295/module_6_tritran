package com.exambackendnew.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class DiemDi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String tenDiemDi;

    @JsonBackReference
    @OneToMany(mappedBy = "diemDi")
    private List<BenXe> benXes;

    public DiemDi() {
    }

    public DiemDi(int id, String tenDiemDi, List<BenXe> benXes) {
        this.id = id;
        this.tenDiemDi = tenDiemDi;
        this.benXes = benXes;
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTenDiemDi() {
        return tenDiemDi;
    }

    public void setTenDiemDi(String tenDiemDi) {
        this.tenDiemDi = tenDiemDi;
    }

    public List<BenXe> getBenXes() {
        return benXes;
    }

    public void setBenXes(List<BenXe> benXes) {
        this.benXes = benXes;
    }
}
