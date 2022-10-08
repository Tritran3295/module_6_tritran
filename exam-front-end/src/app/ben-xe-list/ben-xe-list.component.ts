import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {BenXe} from '../model/ben-xe';
import {BenXeService} from '../service/ben-xe.service';
import {ToastrService} from 'ngx-toastr';

@Component({
  selector: 'app-ben-xe-list',
  templateUrl: './ben-xe-list.component.html',
  styleUrls: ['./ben-xe-list.component.css']
})
export class BenXeListComponent implements OnInit {
  benXeList: BenXe[];
  p = 1;
  idModal: number;
  nameModal: number;
  delete = [];
  searchForm: FormGroup;
  pageTotal: number;
  pageCurren: number = 0;

  constructor(private benXeService: BenXeService,
              private toast: ToastrService) {
    this.searchForm = new FormGroup({
      nameSearch: new FormControl()
    });
  }

  ngOnInit(): void {
    this.getBenXeList();

  }

  getBenXeList() {
    this.benXeService.getAllBenXe().subscribe(data => {
      // @ts-ignore
      this.benXeList = data.content;
      // @ts-ignore
      this.pageTotal = data.totalPages;
    });
  }

  elementDelete(id: number, soXe: number) {
    this.idModal = id;
    this.nameModal = soXe;
  }

  deleSoXe() {
    this.benXeService.deleteBenXe(this.idModal).subscribe(() => {
    }, error => {
    }, () => {
      this.ngOnInit();
      this.toast.success('Delete success', 'tittle', {
        timeOut: 1500, progressBar: false
      });
    });
  }

  resetModal() {
    this.delete = [];
  }

  nameSearch() {
    const name = this.searchForm.value.nameSearch;
    console.log('here');
    this.benXeService.searchByName(name, this.pageCurren).subscribe(data => {
      console.log(data);
      // @ts-ignore
      this.benXeList = data.content;
      // @ts-ignore
      this.pageTotal = data.totalPages;

    });
  }

  nextPage() {
    if (this.pageCurren < this.pageTotal -1) {
      this.pageCurren = this.pageCurren + 1;
    }
    this.nameSearch();
  }

  previousPage() {
    if(this.pageCurren >0) {
      this.pageCurren = this.pageCurren -1;
    }
    this.nameSearch();
  }
}
