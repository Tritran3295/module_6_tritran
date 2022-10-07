package com.exambackendnew.service;

import com.exambackendnew.model.BenXe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBenXeService {
    Page<BenXe> findAllBenXe(Pageable pageable, String searchName);

    

    BenXe findById(Integer id);

    void editBenXe(BenXe benXe);

    void createBenXe(BenXe benXe);


    void delete(Integer id);
}
