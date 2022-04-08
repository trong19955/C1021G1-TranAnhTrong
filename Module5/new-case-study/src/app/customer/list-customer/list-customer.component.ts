import {Component, OnInit} from '@angular/core';
import {IListCustomer} from "./IListCustomer";
import {CustomerService} from "../customerService/customerService";

@Component({
  selector: 'app-list-customer',
  templateUrl: './list-customer.component.html',
  styleUrls: ['./list-customer.component.css']
})
export class ListCustomerComponent implements OnInit {
  customerList: IListCustomer[] = CustomerService.customerList;
  CustomerList: IListCustomer | any;
  constructor() {
  }

  ngOnInit(): void {
  }
  viewCustomer(customer : IListCustomer){
    this.CustomerList= customer;
  }
}
