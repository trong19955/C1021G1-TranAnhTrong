import { Component, OnInit } from '@angular/core';
import {IListCustomer} from "../../customer/list-customer/IListCustomer";
import {IContract} from "./IContract";

@Component({
  selector: 'app-list-contract',
  templateUrl: './list-contract.component.html',
  styleUrls: ['./list-contract.component.css']
})
export class ListContractComponent implements OnInit {
  ListContractComponent: IContract[] =[{
    idContract: 1,
    nameContract:'Trần Anh Trọng',
    age:18,
    emailContract:'trong@gmail.com',
    phoneContract:'0981967705',
    gender:'NAM',
    address:'146/58 Phan Van dinh'
  },
    {idContract: 2,
      nameContract:'Trần Anh Trọng',
      age:18,
      emailContract:'trong@gmail.com',
      phoneContract:'0981967705',
      gender:'NAM',
      address:'146/58 Phan Van dinh'
    },
    {idContract: 3,
      nameContract:'Trần Anh Trọng',
      age:18,
      emailContract:'trong@gmail.com',
      phoneContract:'0981967705',
      gender:'NAM',
      address:'146/58 Phan Van dinh'
    },
    {idContract: 4,
      nameContract:'Trần Anh Trọng',
      age:18,
      emailContract:'trong@gmail.com',
      phoneContract:'0981967705',
      gender:'NAM',
      address:'146/58 Phan Van dinh'
    }]
  constructor() { }

  ngOnInit(): void {
  }

}
