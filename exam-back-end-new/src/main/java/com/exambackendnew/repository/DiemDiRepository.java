package com.exambackendnew.repository;

import com.exambackendnew.model.DiemDi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiemDiRepository extends JpaRepository<DiemDi,Integer> {
    @Query(value = "select diem_di.id,diem_di.ten_diem_di from diem_di", nativeQuery = true,
    countQuery = "select count(*) from (select diem_di.id,diem_di.ten_diem_di from diem_di), temp_table")
    List<DiemDi> selectAllDiemDi();
}
