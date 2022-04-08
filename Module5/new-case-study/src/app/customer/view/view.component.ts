import { Component, OnInit } from '@angular/core';
import {IListCustomer} from "../list-customer/IListCustomer";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-view',
  templateUrl: './view.component.html',
  styleUrls: ['./view.component.css']
})
export class ViewComponent implements OnInit {
  id: number | undefined;
CustomerList: IListCustomer | any;

  constructor(private route:ActivatedRoute) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params.id;
  }

}
