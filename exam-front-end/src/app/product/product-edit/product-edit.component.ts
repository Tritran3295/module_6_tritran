import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {Category} from '../../model/category';
import {ProductService} from '../../service/product.service';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {ToastrService} from 'ngx-toastr';
import {Product} from '../../model/product';

@Component({
  selector: 'app-product-edit',
  templateUrl: './product-edit.component.html',
  styleUrls: ['./product-edit.component.css']
})
export class ProductEditComponent implements OnInit {
  productForm: FormGroup;
  categoryList: Category[] = [];
  id;
  product: Product;

  constructor(private productService: ProductService,
              private router: Router,
              private activatedRoute: ActivatedRoute,
              private toast: ToastrService) {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.id = +paramMap.get('id');
      this.productService.findById(this.id).subscribe(data => {
        this.product = data;
        this.productService.getAllCategory().subscribe(category => {
          this.categoryList = category;
          this.productForm.patchValue({category: this.product.category.id});
          this.productForm.patchValue(this.product);
        });
      });
    });
  }

  ngOnInit(): void {
    this.getEditForm();
  }

  getEditForm() {
    this.productForm = new FormGroup({
      id: new FormControl(),
      name: new FormControl(),
      price: new FormControl(),
      category: new FormControl()
    });
  }

  editProduct() {
    const product = this.productForm.value;
    this.productService.editProduct(this.id, product).subscribe(() => {
      this.router.navigateByUrl('');
      this.toast.success('Edit success', 'tittle', {
        timeOut: 1500, progressBar: false
      });
    });
  }

  compareCategory(type1: Category, type2: Category): boolean {
    return type1.id === type2.id;
  }
}
