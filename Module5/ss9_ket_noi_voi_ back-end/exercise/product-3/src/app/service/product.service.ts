import {Injectable} from '@angular/core';
import {Product} from '../model/product';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
const API = 'http://localhost:3000/products';
@Injectable({
  providedIn: 'root'
})
export class ProductService {



  constructor(private http: HttpClient) {
  }

  getAll():Observable<Product[]> {
    return this.http.get<Product[]>(API)
  }

  addProduct(product):Observable<Product> {
    return this.http.post<Product>(API,product)
  }

  findById(id: number):Observable<Product> {
    return this.http.get<Product>(`${API}/${id}`)
  }

  updateProduct(id: number, product: Product):Observable<Product> {
    return this.http.put<Product>(`${API}/${id}`,product)
  }

  deleteProduct(id: number) {
    return this.http.delete(`${API}/${id}`)
  }
}
