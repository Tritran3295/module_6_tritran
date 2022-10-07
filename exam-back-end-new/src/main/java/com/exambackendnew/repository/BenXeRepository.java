package com.exambackendnew.repository;

import com.exambackendnew.model.BenXe;
import com.exambackendnew.model.DiemDen;
import com.exambackendnew.model.DiemDi;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface BenXeRepository extends JpaRepository<BenXe, Integer> {
    @Query(value = "select ben_xe.id,ben_xe.so_xe,ben_xe.loai_xe,ben_xe.ten_nha_xe,ben_xe.diem_di_id,ben_xe.diem_den_id,\n" +
            "ben_xe.so_dien_thoai,ben_xe.email,ben_xe.gio_di,ben_xe.gio_den from ben_xe where ben_xe.ten_nha_xe " +
            "like ?1", nativeQuery = true,
            countQuery = "select count(*) from(select ben_xe.id,ben_xe.so_xe,ben_xe.loai_xe,ben_xe.ten_nha_xe,ben_xe.diem_di_id,ben_xe.diem_den_id,\n" +
                    "ben_xe.so_dien_thoai,ben_xe.email,ben_xe.gio_di,ben_xe.gio_den from ben_xe where ben_xe.ten_nha_xe like ?1) temp_table")
    Page<BenXe> findAllBenXe(Pageable pageable, String nameSearch);

    //    @Modifying
//    @Transactional
//    @Query(value = "INSERT INTO ben_xe_management.ben_xe(`email`,`gio_den`,`gio_di`,`loai_xe`,`so_dien_thoai`,`so_xe`,`ten_nha_xe`,`diem_den_id`,`diem_di_id`)" +
//            "VALUES :#{#benXe.email} , :#{#benXe.gioDen} , :#{#benXe.gioDi}, " +
//            ":#{#benXe.loaiXe} , :#{#benXe.soDienThoai} , :#{#benXe.soXe} , :#{#benXe.tenNhaXe} , :#{#benXe.diemDen.id} , :#{#benXe.diemDi.id}",nativeQuery = true)
//    void createBenXe(BenXe benXe);
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO ben_xe(so_xe,loai_xe,ten_nha_xe,so_dien_thoai,email,gio_di,gio_den,diem_den_id,diem_di_id)" +
            "values (:soXe,:loaiXe,:tenNhaXe,:soDienThoai,:email,:gioDi,:gioDen,:diemDen,:diemDi)", nativeQuery = true)
    void createBenXe(@Param("soXe") Integer soXe, @Param("loaiXe") String loaiXe, @Param("tenNhaXe") String tenNhaXe
            , @Param("soDienThoai") String soDienThoai, @Param("email") String email, @Param("gioDi") String gioDi
            , @Param("gioDen") String gioDen, @Param("diemDen") int diemDen, @Param("diemDi") int diemDi);

    @Transactional
    @Query(value = "select ben_xe.id,ben_xe.so_xe,ben_xe.loai_xe,ben_xe.ten_nha_xe,ben_xe.diem_di_id,ben_xe.diem_den_id," +
            "ben_xe.so_dien_thoai,ben_xe.email,ben_xe.gio_di,ben_xe.gio_den from ben_xe where ben_xe.id = :id", nativeQuery = true)
    BenXe findBenXeById(@Param("id") Integer id);


    //    @Transactional
//    @Query(value = "update ben_xe set so_xe = :#{#ben_xe.so_xe},loai_xe = :#{#ben_xe.loai_xe},ten_nha_xe = :#{#ben_xe.ten_nha_xe}," +
//            "diem_di_id = :#{#benXe.diemDi.id},diem_den_id = :#{#benXe.diemDen.id},so_dien_thoai = :#{#benXe.soDienThoai}," +
//            "email = :#{#benXe.email},gio_di = :#{#benXe.gioDi},gio_den = :#{#benXe.gioDen} where id = :#{#benXe.id}", nativeQuery = true)
//    void editBenXe(BenXe benXe);
    @Modifying
    @Transactional
    @Query(value = "update ben_xe set so_xe = :soXe,loai_xe = :loaiXe,ten_nha_xe = :tenNhaXe,so_dien_thoai = :soDienThoai, " +
            "email = :email,gio_di = :gioDi,gio_den = :gioDen,diem_den_id = :diemDen,diem_di_id = :diemDi where id = :id",nativeQuery = true)
    void editBenXe(@Param("soXe") Integer soXe, @Param("loaiXe") String loaiXe, @Param("tenNhaXe") String tenNhaXe
            , @Param("soDienThoai") String soDienThoai, @Param("email") String email, @Param("gioDi") String gioDi
            , @Param("gioDen") String gioDen, @Param("diemDen") int diemDen, @Param("diemDi") int diemDi, @Param("id") int id);


    @Transactional
    @Query(value = "delete from ben_xe where id =:id", nativeQuery = true)
    void deleteBenXe(@Param("id") Integer id);


//    @Modifying
//    @Transactional
//    @Query(value = "insert into ben_xe(ben_xe.so_xe,ben_xe.email,ben_xe.gio_den,ben_xe.gio_di,ben_xe.loai_xe,ben_xe.so_dien_thoai,ben_xe.ten_nha_xe,ben_xe.diem_den_id,ben_xe.diem_di_id)" +
//            "values (?1,?2,?3,?4,?5,?6,?7,?8,?9)", nativeQuery = true)
//    void createBenXe(Integer soXe,String email,String gioDen,String gioDi
//            ,String loaiXe,String soDienThoai,String tenNhaXe,int diemDen,int diemDi);
}
