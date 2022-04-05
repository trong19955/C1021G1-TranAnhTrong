import { Component, OnInit } from '@angular/core';
import {IListCustomer} from "./IListCustomer";

@Component({
  selector: 'app-list-customer',
  templateUrl: './list-customer.component.html',
  styleUrls: ['./list-customer.component.css']
})
export class ListCustomerComponent implements OnInit {
ListCustomerComponent: IListCustomer[] =[{
  idCustomer: 1,
  nameCustomer:'Trần Anh Trọng',
  age:18,
  emailCustomer:'trong@gmail.com',
  phoneCustomer:'0981967705',
  gender:'NAM',
  address:'146/58 Phan Van dinh'
},
{idCustomer: 2,
  nameCustomer:'Trần Anh Trọng',
  age:18,
  emailCustomer:'trong@gmail.com',
  phoneCustomer:'0981967705',
  gender:'NAM',
  address:'146/58 Phan Van dinh'
},
  {idCustomer: 3,
    nameCustomer:'Trần Anh Trọng',
    age:18,
    emailCustomer:'trong@gmail.com',
    phoneCustomer:'0981967705',
    gender:'NAM',
    address:'146/58 Phan Van dinh'
  },
  {idCustomer: 4,
    nameCustomer:'Trần Anh Trọng',
    age:18,
    emailCustomer:'trong@gmail.com',
    phoneCustomer:'0981967705',
    gender:'NAM',
    address:'146/58 Phan Van dinh'
  }]

  constructor() { }

  ngOnInit(): void {
  }

}
