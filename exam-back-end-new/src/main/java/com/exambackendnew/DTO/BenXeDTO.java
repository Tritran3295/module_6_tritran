package com.exambackendnew.DTO;

import com.exambackendnew.model.DiemDen;
import com.exambackendnew.model.DiemDi;

import javax.validation.constraints.NotEmpty;

public class BenXeDTO {
    private Integer id;
    private Integer soXe;
    private String loaiXe;
    private String tenNhaXe;
    private String soDienThoai;
    private String email;
    private String gioDi;
    private String gioDen;
    private DiemDen diemDen;
    private DiemDi diemDi;

    public BenXeDTO() {
    }

    public BenXeDTO(Integer id, Integer soXe, String loaiXe, String tenNhaXe, String soDienThoai, String email, String gioDi, String gioDen, DiemDen diemDen, DiemDi diemDi) {
        this.id = id;
        this.soXe = soXe;
        this.loaiXe = loaiXe;
        this.tenNhaXe = tenNhaXe;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.gioDi = gioDi;
        this.gioDen = gioDen;
        this.diemDen = diemDen;
        this.diemDi = diemDi;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSoXe() {
        return soXe;
    }

    public void setSoXe(Integer soXe) {
        this.soXe = soXe;
    }

    public String getLoaiXe() {
        return loaiXe;
    }

    public void setLoaiXe(String loaiXe) {
        this.loaiXe = loaiXe;
    }

    public String getTenNhaXe() {
        return tenNhaXe;
    }

    public void setTenNhaXe(String tenNhaXe) {
        this.tenNhaXe = tenNhaXe;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGioDi() {
        return gioDi;
    }

    public void setGioDi(String gioDi) {
        this.gioDi = gioDi;
    }

    public String getGioDen() {
        return gioDen;
    }

    public void setGioDen(String gioDen) {
        this.gioDen = gioDen;
    }

    public DiemDen getDiemDen() {
        return diemDen;
    }

    public void setDiemDen(DiemDen diemDen) {
        this.diemDen = diemDen;
    }

    public DiemDi getDiemDi() {
        return diemDi;
    }

    public void setDiemDi(DiemDi diemDi) {
        this.diemDi = diemDi;
    }
}
