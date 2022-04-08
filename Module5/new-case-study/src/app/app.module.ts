import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import {HeaderComponent} from './home/header/header.component';
import {HomeComponent} from './home/home.component';
import {BodyComponent} from './home/body/body.component';
import {FooterComponent} from './home/footer/footer.component';
import {ListCustomerComponent} from './customer/list-customer/list-customer.component';
import {ListServiceComponent} from './service/list-service/list-service.component';
import {ListEmployeeComponent} from './employee/list-employee/list-employee.component';
import {ViewComponent} from './customer/view/view.component';
import {ListContractComponent} from './contract/list-contract/list-contract.component';
import {AppRoutingModule} from './app-routing.module';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    HomeComponent,
    BodyComponent,
    FooterComponent,
    ListCustomerComponent,
    ListEmployeeComponent,
    ListServiceComponent,
    ViewComponent,
    ListContractComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }