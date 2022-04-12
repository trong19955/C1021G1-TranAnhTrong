import { Injectable } from '@angular/core';
import {Product} from '../model/product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor() { }
  products: Product[] = [{
    id: 1,
    name: 'IPhone 12',
    price: 2400000,
    description: 'New'
  }, {
    id: 2,
    name: 'IPhone 11',
    price: 2400000,
    description: 'Like New'
  }, {
    id: 3,
    name: 'IPhone X',
    price: 2400000,
    description: '97%'
  },{
    id: 4,
    name: 'IPhone 8',
    price: 2400000,
    description: '98%'
  },{
    id: 5,
    name: 'IPhone 11 Pro',
    price: 2400000,
    description: 'Like New'
  }];
  getALL(){
    return this.products;
  }
  saveProduct(product){
    this. products.push(product);
  }
}
