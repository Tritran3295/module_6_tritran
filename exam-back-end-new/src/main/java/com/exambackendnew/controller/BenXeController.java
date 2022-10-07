package com.exambackendnew.controller;

import com.exambackendnew.DTO.BenXeDTO;
import com.exambackendnew.model.BenXe;
import com.exambackendnew.model.DiemDen;
import com.exambackendnew.model.DiemDi;
import com.exambackendnew.service.IBenXeService;
import com.exambackendnew.service.IDiemDenService;
import com.exambackendnew.service.IDiemDiService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(value = "http://localhost:4200")
@RequestMapping("/")
public class BenXeController {
    @Autowired
    private IBenXeService benXeService;

    @Autowired
    private IDiemDiService diemDiService;

    @Autowired
    private IDiemDenService diemDenService;

    @GetMapping("/diem-den")
    public ResponseEntity<List<DiemDen>> getAllDiemDen() {
        List<DiemDen> diemDenList = this.diemDenService.findAllDiemDen();
        return new ResponseEntity<>(diemDenList, HttpStatus.OK);
    }

    @GetMapping("/diem-di")
    public ResponseEntity<List<DiemDi>> getAllDiemDi() {
        List<DiemDi> diemDiList = this.diemDiService.findAllDiemDi();
        return new ResponseEntity<>(diemDiList, HttpStatus.OK);
    }

    @GetMapping("/ben-xe")
    public ResponseEntity<Page<BenXe>> getAllBenXe(@PageableDefault(3) Pageable pageable,
                                                   Optional<String> nameSearch) {
        String searchName = nameSearch.orElse("");
        Page<BenXe> benXePage = benXeService.findAllBenXe(pageable, searchName);
        if (benXePage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(benXePage, HttpStatus.OK);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<Void> createBenXe( @RequestBody BenXe benXe) {
        benXeService.createBenXe(benXe);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/findId/{id}")
    public ResponseEntity<BenXe> findById(@PathVariable int id) {
       BenXe benXe = benXeService.findById(id);
       return new ResponseEntity<>(benXe,HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateMedicalRecord( @RequestBody BenXe benXe, @PathVariable("id") int id) {
        benXeService.editBenXe(benXe);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    private ResponseEntity<Void> deleteBenXe(@PathVariable Integer id) {
        benXeService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
