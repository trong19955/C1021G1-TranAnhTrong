import { Component, OnInit } from '@angular/core';
import {ProductService} from '../service/product.service';
import {Product} from '../model/Product';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {
  productList: Product[] = []

  constructor(private productService : ProductService ) { }

  ngOnInit(): void {
    this.productService.getAll().subscribe(value => {
      this.productList = value;
    })

  }

}
