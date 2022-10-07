package com.exambackendnew.service.Impl;

import com.exambackendnew.model.DiemDi;
import com.exambackendnew.repository.DiemDiRepository;
import com.exambackendnew.service.IDiemDiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiemDiServiceImpl implements IDiemDiService {
    @Autowired
    private DiemDiRepository diemDiRepository;

    @Override
    public List<DiemDi> findAllDiemDi() {
        return diemDiRepository.selectAllDiemDi();
    }
}
