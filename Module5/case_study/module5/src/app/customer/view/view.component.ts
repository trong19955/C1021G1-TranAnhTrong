import { Component, OnInit } from '@angular/core';
import {IListCustomer} from "../list-customer/IListCustomer";

@Component({
  selector: 'app-view',
  templateUrl: './view.component.html',
  styleUrls: ['./view.component.css']
})
export class ViewComponent implements OnInit {
  CustomerList: IListCustomer | undefined
  constructor() { }

  ngOnInit(): void {
  }

}
