import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ListComponent} from './list/list.component';
import {AddComponent} from './add/add.component';
import {EditComponent} from './edit/edit.component';
import {DeleteComponent} from './delete/delete.component';


const routes: Routes = [
  {path: '', component :ListComponent},
  {path:'add', component: AddComponent},
  {path:'update/:id', component: EditComponent},
  {path:'delete/:id', component: DeleteComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
