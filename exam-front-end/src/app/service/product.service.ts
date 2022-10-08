import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Product} from '../model/product';
import {Category} from '../model/category';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  private URL_PRODUCT = 'http://localhost:3000/product';
  private URL_CATEGORY = 'http://localhost:3000/category';
  constructor(private http: HttpClient) {
  }

  getAllProduct(): Observable<Product[]> {
    return this.http.get<Product[]>(this.URL_PRODUCT);
  }
  getAllCategory(): Observable<Category[]> {
    return this.http.get<Category[]>(this.URL_CATEGORY);
  }
  saveProduct(product: Product): Observable<Product> {
    return this.http.post<Product>(this.URL_PRODUCT, product);
  }

  findById(id: number): Observable<Product> {
    return this.http.get<Product>(this.URL_PRODUCT + '/' + id);
  }

  editProduct(id: number, product): Observable<Product> {
    return this.http.patch<Product>(this.URL_PRODUCT + '/' + id, product);
  }

  deleteProduct(id: number): Observable<Product> {
    return this.http.delete<Product>(this.URL_PRODUCT + '/' + id);
  }

  searchByName(name: string ): Observable<Product[]> {
    return this.http.get<Product[]>(this.URL_PRODUCT + '?name_like=' + name);
  }
}
