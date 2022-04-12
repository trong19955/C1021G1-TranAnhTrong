import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import {SharedRoutingModule} from './shared-routing.module';



@NgModule({
  declarations: [NavBarComponent],
  exports: [
    NavBarComponent
  ],
  imports: [
    CommonModule,
    SharedRoutingModule
  ]
})
export class SharedModule { }
