import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Product} from '../model/Product';
import {Category} from '../model/Category';


const API_URL = "http://localhost:3000/productList";
const API_URL_CATEGORY = " http://localhost:3000/category";

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private http: HttpClient) { }

  getAll(): Observable<Product[]> {
    return this.http.get<Product[]>(API_URL);
  }

  saveProduct(product): Observable<Product> {
    return this.http.post<Product>(API_URL, product);
  }
  findById(id: number): Observable<Product> {
    return this.http.get<Product>(API_URL +"/"+id);
  }

  updateProduct(id: number, category: Product): Observable<Product> {
    return this.http.put<Product>(API_URL +"/"+id, category);
  }

  deleteProduct(id: number): Observable<Product> {
    return this.http.delete<Product>(API_URL +"/"+id);
  }


  getAllCategory(): Observable<Category[]> {
    return this.http.get<Category[]>(API_URL_CATEGORY);
  }



}
