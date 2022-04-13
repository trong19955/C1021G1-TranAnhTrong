import { Injectable } from '@angular/core';
import {environment} from "../../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Customer} from "../model/customer";

const JSON_URL = `${environment.jsonUrl}`;


@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  constructor(private http: HttpClient) { }

  getAllCustomers(): Observable<Customer[]> {
    return this.http.get<Customer[]>(JSON_URL + '/customers');
  }

  saveCustomer(customer): Observable<Customer> {
    return this.http.post<Customer>(JSON_URL + '/customers', customer);
  }

  findCustomerById(id: string): Observable<Customer> {
    return this.http.get<Customer>(JSON_URL + '/customers/' + id);
  }

  updateCustomer( customer: Customer): Observable<Customer> {
    console.log(customer);
    return this.http.put<Customer>(JSON_URL + '/customers/' + customer.id, customer);
  }

  delete(id: string): Observable<Customer> {
    return this.http.delete<Customer>(JSON_URL + '/customers/' + id);
  }

  searchCustomer(customerName: string,address: string): Observable<Customer[]> {
    return this.http.get<Customer[]>(JSON_URL + '/customers?customerName_like=' + customerName + '&address_like=' + address);
  }

  // delete(idCustomer: string) {
  //   return this.http.delete<Customer>(JSON_URL + '/customers/' + idCustomer)
  //
  // }
}
