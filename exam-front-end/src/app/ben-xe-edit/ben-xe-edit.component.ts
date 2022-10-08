import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {DiemDi} from '../model/diem-di';
import {DiemDen} from '../model/diem-den';
import {BenXeService} from '../service/ben-xe.service';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {ToastrService} from 'ngx-toastr';
import {BenXe} from '../model/ben-xe';

@Component({
  selector: 'app-ben-xe-edit',
  templateUrl: './ben-xe-edit.component.html',
  styleUrls: ['./ben-xe-edit.component.css']
})
export class BenXeEditComponent implements OnInit {
  benXeForm: FormGroup ;
  diemDiList: DiemDi[] = [];
  diemDenList: DiemDen[] = [];
  id;

  constructor(private benXeService: BenXeService,
              private router: Router,
              private toast: ToastrService,
              private activatedRoute: ActivatedRoute) {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.id = +paramMap.get('id');
      this.benXeService.findById(this.id).subscribe(data => {
        this.benXeForm.patchValue(data);
        this.benXeService.getAllDiemDi().subscribe(diemDi => {
          this.diemDiList = diemDi;
          for (const item of this.diemDiList) {
            if (item.id === data.diemDi.id) {
              this.benXeForm.patchValue({diemDi: item});
            }
          }
        });
        this.benXeService.getAllDiemDen().subscribe(diemDen => {
          this.diemDenList = diemDen;
          for (const item of this.diemDenList) {
            if (item.id === data.diemDen.id) {
              this.benXeForm.patchValue({diemDen: item});
            }
          }
        });
      });
    });
  }

  ngOnInit(): void {
    this.getForm();
  }
  getForm() {
    this.benXeForm = new FormGroup({
      id: new FormControl(),
      soXe: new FormControl(),
      loaiXe: new FormControl('', [Validators.required]),
      tenNhaXe: new FormControl('', [Validators.required]),
      diemDi: new FormControl('', [Validators.required]),
      diemDen: new FormControl('', [Validators.required]),
      soDienThoai: new FormControl('', [Validators.required, Validators.pattern(/^([\+090]|[\+093]|[\+097])[0-9]{10}$/)]),
      email: new FormControl('', [Validators.required, Validators.email]),
      gioDi: new FormControl('', [Validators.required, Validators.min(5), Validators.max(11)]),
      gioDen: new FormControl('', [Validators.required, Validators.min(5), Validators.max(11)]),
    })
  }

  editBenXe() {
    const benXe = this.benXeForm.value;
    this.benXeService.editBenXe(this.id, benXe).subscribe(() => {
    }, error => {
    }, () => {
      this.router.navigateByUrl('');
      this.ngOnInit();
      this.toast.success('Edit success', 'tittle', {
        timeOut: 1500, progressBar: false
      });
    });
  }

  compareDiemDi(type1: DiemDi, type2: DiemDi): boolean {
    return type1.id === type2.id;
  }

  compareDiemDen(type1: DiemDen, type2: DiemDen): boolean {
    return type1.id === type2.id;
  }
}
