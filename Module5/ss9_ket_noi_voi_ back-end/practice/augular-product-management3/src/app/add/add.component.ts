import { Component, OnInit } from '@angular/core';
import {ProductService} from '../service/product.service';
import {FormControl, FormGroup} from '@angular/forms';
import {Router} from '@angular/router';
import {Category} from '../model/Category';

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css']
})
export class AddComponent implements OnInit {
  addForm : FormGroup = new FormGroup({
    id: new FormControl(''),
    name: new FormControl(''),
    price: new FormControl(''),
    category: new FormControl(''),
  })

  categoryList: Category[] = [];
  constructor(private productService : ProductService,
              private router : Router) { }

  ngOnInit(): void {
    this.productService.getAllCategory().subscribe(value => {
      this.categoryList = value;
    })

  }

  addNew() {
    const product = this.addForm.value;
    this.productService.saveProduct(product).subscribe(()=>{
      this.router.navigateByUrl("")
    });
  }
}
