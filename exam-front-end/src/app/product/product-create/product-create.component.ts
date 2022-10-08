import {Component, OnInit} from '@angular/core';
import {Category} from '../../model/category';
import {FormControl, FormGroup} from '@angular/forms';
import {ProductService} from '../../service/product.service';
import {Router} from '@angular/router';
import {ToastrService} from 'ngx-toastr';

@Component({
  selector: 'app-product-create',
  templateUrl: './product-create.component.html',
  styleUrls: ['./product-create.component.css']
})
export class ProductCreateComponent implements OnInit {
  categoryList: Category[] = [];
  productForm: FormGroup;

  constructor(private productService: ProductService,
              private router: Router,
              private toast: ToastrService) {
    this.productService.getAllCategory().subscribe(data => {
      this.categoryList = data;
    });
  }

  ngOnInit(): void {
    this.getCreateForm();
  }
  getCreateForm() {
    this.productForm = new FormGroup({
      id: new FormControl(),
      name: new FormControl(),
      price: new FormControl(),
      category: new FormControl()
    });
  }

  createProduct() {
    const product = this.productForm.value;
    this.productService.saveProduct(product).subscribe(() => {
      this.router.navigateByUrl('');
      this.toast.success('Create success', 'tittle', {
        timeOut: 1500, progressBar: false
      });
    });
  }
}
