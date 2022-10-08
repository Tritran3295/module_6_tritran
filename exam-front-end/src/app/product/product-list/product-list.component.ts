import {Component, OnInit} from '@angular/core';
import {Product} from '../../model/product';
import {ProductService} from '../../service/product.service';
import {FormControl, FormGroup} from '@angular/forms';
import {ToastrService} from 'ngx-toastr';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {
  nameModal: string;
  idModal: number;
  p = 1;
  productList: Product[];
  searchForm: FormGroup;
  delete = [];

  constructor(private productService: ProductService,
              private toast: ToastrService) {
    this.searchForm = new FormGroup({
      nameSearch: new FormControl()
    });
  }

  ngOnInit(): void {
    this.getList();
  }

  getList() {
    this.productService.getAllProduct().subscribe(data => {
      this.productList = data;
    });
  }

  resetModal() {
    this.delete = [];
  }

  deleteCustomer() {
    this.productService.deleteProduct(this.idModal).subscribe(() => {
    }, error => {
    }, () => {
      this.ngOnInit();
      this.toast.success('Delete success', 'tittle', {
        timeOut: 1500, progressBar: false
      });
    });
  }

  elementDelete(id: any, name: any) {
    this.idModal = id;
    this.nameModal = name;
  }

  nameSearch() {
    const name = this.searchForm.value.nameSearch;
    this.productService.searchByName(name).subscribe(data => {
      this.productList = data;
    });
  }
}
