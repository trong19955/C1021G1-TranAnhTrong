import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import {CustomerConfigRoutingModule} from './customer-config-routing.module';
import {EditCustomerComponent} from "../component/edit-customer/edit-customer.component";
import {ListCustomersComponent} from "../component/list-customers/list-customers.component";
import {CreateCustomerComponent} from "../component/create-customer/create-customer.component";
import {ReactiveFormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import {NgxPaginationModule} from "ngx-pagination";


@NgModule({
  declarations: [
    EditCustomerComponent,
    ListCustomersComponent,
    CreateCustomerComponent
  ],
  exports: [
    ListCustomersComponent,
    CreateCustomerComponent,
    EditCustomerComponent
  ],
  imports: [
    CommonModule,
    CustomerConfigRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
    NgxPaginationModule
  ]
})
export class CustomerConfigModule { }
