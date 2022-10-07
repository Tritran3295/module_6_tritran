package com.exambackendnew.service.Impl;

import com.exambackendnew.model.DiemDen;
import com.exambackendnew.repository.DiemDenRepository;
import com.exambackendnew.service.IDiemDenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiemDenServiceImpl implements IDiemDenService {
    @Autowired
    private DiemDenRepository diemDenRepository;

    @Override
    public List<DiemDen> findAllDiemDen() {
        return diemDenRepository.selectAllDiemDen();
    }
}
