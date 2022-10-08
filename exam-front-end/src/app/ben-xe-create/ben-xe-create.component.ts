import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {BenXeService} from '../service/ben-xe.service';
import {Router} from '@angular/router';
import {DiemDi} from '../model/diem-di';
import {DiemDen} from '../model/diem-den';

@Component({
  selector: 'app-ben-xe-create',
  templateUrl: './ben-xe-create.component.html',
  styleUrls: ['./ben-xe-create.component.css']
})
export class BenXeCreateComponent implements OnInit {
  benXeForm: FormGroup;
  diemDiList: DiemDi[] = [];
  diemDenList: DiemDen[] = [];

  constructor(private benXeService: BenXeService,
              private router: Router) {
    this.benXeService.getAllDiemDi().subscribe(diemDi => {
      this.diemDiList = diemDi;
      this.benXeService.getAllDiemDen().subscribe(diemDen => {
        this.diemDenList = diemDen;
      });
    });
  }

  ngOnInit(): void {
    this.getBenXeForm();
  }
  getBenXeForm() {
    this.benXeForm = new FormGroup({
      id: new FormControl(),
      soXe: new FormControl(),
      loaiXe: new FormControl('', [Validators.required]),
      tenNhaXe: new FormControl('', [Validators.required]),
      diemDi: new FormControl('', [Validators.required]),
      diemDen: new FormControl('', [Validators.required]),
      soDienThoai: new FormControl('', [Validators.required, Validators.pattern(/^([\+090]|[\+093]|[\+097])[0-9]{10}$/)]),
      email: new FormControl('', [Validators.required, Validators.email]),
      gioDi: new FormControl('', [Validators.required]),
      gioDen: new FormControl('', [Validators.required]),
    });
  }

  createBenXe() {
    const benXe = this.benXeForm.value;
    this.benXeService.save(benXe).subscribe(() => {
    }, error => {
    }, () => {
      this.router.navigateByUrl('');
    });
  }
}
