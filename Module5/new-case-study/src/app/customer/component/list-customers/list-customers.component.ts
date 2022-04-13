import { Component, OnInit } from '@angular/core';
import {Customer} from "../../model/customer";
import {CustomerService} from "../../service/customer.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-list-customers',
  templateUrl: './list-customers.component.html',
  styleUrls: ['./list-customers.component.css']
})
export class ListCustomersComponent implements OnInit {
  idCustomer : string;
  customers: Customer[];
  customer: Customer = {};
  p = 1 ;

  constructor(
    private customerService: CustomerService,
    private router: Router
  ) {
  }

  ngOnInit() {
    //async data
    this.getAllCustomers();
  }

  getAllCustomers() {
    this.customerService.getAllCustomers().subscribe(customers => {
      this.customers = customers;
      console.log('list customers success!');
    }, error => {
      console.log(error);
    })
  }

  showModal(id: string) {
    this.customerService.findCustomerById(id).subscribe(customer => {
      this.customer = customer;
      console.log('abc');
    })

  }

  // deleteCustomer(id: string) {
  //   this.customerService.deleteCustomer(id).subscribe(() => {
  //     console.log('delete customer success!');
  //
  //     //load lai trang list
  //     this.ngOnInit();
  //
  //     // this.router.navigateByUrl('/customer').then(r => console.log('back to customer list!'));
  //
  //   }, error => {
  //     console.log(error);
  //   })
  // }

  searchCustomer(customerName: string, address: string) {
    this.customerService.searchCustomer(customerName,address).subscribe(customers => {
      this.customers = customers;
      this.p = 0;
    },error => {
      console.log(error);
    })
  }

  getId(id: string) {
    this.idCustomer = id;

  }

  delete() {
    this.customerService.delete(this.idCustomer).subscribe(data => {
      this.ngOnInit();

    })
  }
}
