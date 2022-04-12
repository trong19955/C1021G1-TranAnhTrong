import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {Product} from '../model/Product';
import {ProductService} from '../service/product.service';
import {ActivatedRoute, Router} from '@angular/router';
import {Category} from '../model/Category';

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})
export class EditComponent implements OnInit {
  id: number;

  updateForm:FormGroup
  constructor(private productService : ProductService,
              private activatedRoute: ActivatedRoute,
              private router : Router) { }
  categoryList: Category[] = [];
  ngOnInit(): void {
    this.productService.getAllCategory().subscribe(value => {
      this.categoryList = value;
      this.id = this.activatedRoute.snapshot.params.id;
      this.productService.findById(this.id ).subscribe(product=>{
        this.updateForm =  new FormGroup({
          id: new FormControl(product.id),
          name: new FormControl(product.name),
          price: new FormControl(product.price),
          category: new FormControl(product.category)
        })
      })
    })



  }

  update(id : number) {
    const product = this.updateForm.value;
    this.productService.updateProduct(id, product).subscribe(() => {
      alert('Cập nhật thành công');
      this.router.navigateByUrl("/")
    }, e => {
      console.log(e);
    });
  }
}
