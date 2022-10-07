package com.exambackendnew.repository;

import com.exambackendnew.model.DiemDen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DiemDenRepository extends JpaRepository<DiemDen,Integer> {
    @Query(value = "select diem_den.id,diem_den.ten_diem_den from diem_den", nativeQuery = true,
            countQuery = "select count(*) from (select diem_den.id,diem_den.ten_diem_den from diem_den), temp_table")
    List<DiemDen> selectAllDiemDen();
}
