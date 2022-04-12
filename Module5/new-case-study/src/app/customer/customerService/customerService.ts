import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CustomerService{
  private readonly API_URL = 'http://localhost:3000/customerList';
  private readonly TYPE_URL = 'http://localhost:3000/customerTypeList';
  constructor(private https: HttpClient) {
  }
  

}
