import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Todo} from './todo';
import {map} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class TodoService {
  URL = ' http://localhost:3000/todo';
  constructor(private http: HttpClient) { }
    getInfo(): any{
      return this.http.get(this.URL).pipe(map(res => res));
    }
    deleteCategory(id: number) {
    console.log(id);
    return this.http.delete<Todo>(this.URL + '/' + id);
    }

}
