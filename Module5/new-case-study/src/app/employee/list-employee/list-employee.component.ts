import { Component, OnInit } from '@angular/core';
import {IEmployee} from "./IEmployee";

@Component({
  selector: 'app-list-employee',
  templateUrl: './list-employee.component.html',
  styleUrls: ['./list-employee.component.css']
})
export class ListEmployeeComponent implements OnInit {
ListEmployeeComponent : IEmployee[]=[{
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
    address:'146/58 Phan Van dinh'},
  {idCustomer: 3,
    nameCustomer:'Trần Anh Trọng',
    age:18,
    emailCustomer:'trong@gmail.com',
    phoneCustomer:'0981967705',
    gender:'NAM',
    address:'146/58 Phan Van dinh'},
  {
    idCustomer: 4,
    nameCustomer:'Trần Anh Trọng',
    age:18,
    emailCustomer:'trong@gmail.com',
    phoneCustomer:'0981967705',
    gender:'NAM',
    address:'146/58 Phan Van dinh'
  }
]
  constructor() { }

  ngOnInit(): void {
  }


}
