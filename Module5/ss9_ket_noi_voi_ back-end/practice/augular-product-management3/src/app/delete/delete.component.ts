import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import {ProductService} from '../service/product.service';

@Component({
  selector: 'app-delete',
  templateUrl: './delete.component.html',
  styleUrls: ['./delete.component.css']
})
export class DeleteComponent implements OnInit {
  deleteForm: FormGroup;
  id: number;
  constructor( private router: Router,
               private activatedRoute: ActivatedRoute,
               private productService : ProductService) { }

  ngOnInit(): void {
    this.id = this.activatedRoute.snapshot.params.id;
    this.productService.findById(this.id ).subscribe(product=>{
      this.deleteForm =  new FormGroup({
        id: new FormControl(product.id),
        name: new FormControl(product.name),
        price: new FormControl(product.price),
        category: new FormControl(product.category)
      })
    })

  }


  delete(id: number) {
    this.productService.deleteProduct(id).subscribe(() => {
      this.router.navigate(['']);
    }, e => {
      console.log(e);
    });

  }
}
