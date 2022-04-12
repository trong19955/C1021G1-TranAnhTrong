import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import {HeaderComponent} from './home/header/header.component';
import {HomeComponent} from './home/home.component';
import {BodyComponent} from './home/body/body.component';
import {FooterComponent} from './home/footer/footer.component';
import {ListServiceComponent} from './service/list-service/list-service.component';
import {ListEmployeeComponent} from './employee/list-employee/list-employee.component';

import {ListContractComponent} from './contract/list-contract/list-contract.component';
import {AppRoutingModule} from './app-routing.module';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    HomeComponent,
    BodyComponent,
    FooterComponent,
    ListEmployeeComponent,
    ListServiceComponent,
    ListContractComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
