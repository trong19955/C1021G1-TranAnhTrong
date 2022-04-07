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


  // constructor(private customerService: CustomerService) {
  //   this.customerList = this.customerService.customerList;
  // }
  constructor() {
  }

  ngOnInit(): void {
  }

}
