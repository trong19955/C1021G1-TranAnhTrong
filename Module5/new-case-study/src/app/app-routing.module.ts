import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {ListCustomerComponent} from "./customer/list-customer/list-customer.component";
import {ListEmployeeComponent} from "./employee/list-employee/list-employee.component";
import {ListServiceComponent} from "./service/list-service/list-service.component";
import {ListContractComponent} from "./contract/list-contract/list-contract.component";
import {ViewComponent} from "./customer/view/view.component";

const routes: Routes = [
  {path: "customer", component: ListCustomerComponent},
  {path: "view/:id", component: ViewComponent},

  {path: "employee", component: ListEmployeeComponent},
  {path: "service", component: ListServiceComponent},
  {path: "contract", component: ListContractComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
