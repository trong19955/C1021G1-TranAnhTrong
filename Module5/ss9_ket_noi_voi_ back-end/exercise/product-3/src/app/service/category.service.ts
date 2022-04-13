import {APP_ID, Injectable} from '@angular/core';
import {Category} from '../model/category';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {environment} from "../../environments/environment";

const APIURL = `${environment.apiUrl}`

@Injectable({

  providedIn: 'root'
})
export class CategoryService {


  constructor(private http: HttpClient) {
  }

  getAll(): Observable<Category[]> {
    return this.http.get<Category[]>(APIURL + '/categories');
  }

  saveCategory(category): Observable<Category> {
   return  this.http.post<Category>(APIURL+ '/categories',category)
  }

  findById(id: number):Observable<Category> {
    return this.http.get(`${APIURL}/categories/${id}`)
  }

  updateCategory(id: number, category: Category):Observable<Category> {
    return this.http.put<Category>(`${APIURL}/categories/${category.id}`,category)
  }

  deleteCategory(id: number):Observable<Category> {
    return  this.http.delete(`${APIURL}/categories/${id}`)
  }
}
