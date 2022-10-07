package com.exambackendnew.service.Impl;

import com.exambackendnew.model.BenXe;
import com.exambackendnew.repository.BenXeRepository;
import com.exambackendnew.service.IBenXeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BenXeServiceImpl implements IBenXeService {
    @Autowired
    private BenXeRepository benXeRepository;

    @Override
    public Page<BenXe> findAllBenXe(Pageable pageable, String searchName) {
        return benXeRepository.findAllBenXe(pageable,"%" + searchName + "%");
    }


    @Override
    public BenXe findById(Integer id) {
        return benXeRepository.findBenXeById(id);
    }

    @Override
    public void editBenXe(BenXe benXe) {
        benXeRepository.editBenXe(benXe.getSoXe(),benXe.getLoaiXe(),benXe.getTenNhaXe(),benXe.getSoDienThoai()
                ,benXe.getEmail(),benXe.getGioDi(),benXe.getGioDen(),benXe.getDiemDen().getId(),benXe.getDiemDi().getId(),benXe.getId());
    }

    @Override
    public void delete(Integer id) {
        benXeRepository.deleteBenXe(id);
    }

    @Override
    public void createBenXe(BenXe benXe) {
        benXeRepository.createBenXe(benXe.getSoXe(),benXe.getLoaiXe(),benXe.getTenNhaXe(),benXe.getSoDienThoai()
        ,benXe.getEmail(),benXe.getGioDi(),benXe.getGioDen(),benXe.getDiemDen().getId(),benXe.getDiemDi().getId());
    }


}
