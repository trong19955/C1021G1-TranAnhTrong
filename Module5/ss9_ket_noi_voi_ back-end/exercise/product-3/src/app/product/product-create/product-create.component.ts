import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {ProductService} from '../../service/product.service';
import {CategoryService} from "../../service/category.service";
import {Category} from "../../model/category";
import {Product} from "../../model/product";

@Component({
  selector: 'app-product-create',
  templateUrl: './product-create.component.html',
  styleUrls: ['./product-create.component.css']
})
export class ProductCreateComponent implements OnInit {
  productForm: FormGroup;
  categoriesList: Category[];
  newProduct: Product;

  constructor(private productService: ProductService,
              private categoryService: CategoryService) {
  }

  ngOnInit() {
    this.getAll();
    this.productForm = new FormGroup({
      id: new FormControl(''),
      name: new FormControl(''),
      price: new FormControl(''),
      category: new FormControl(''),
      description: new FormControl(''),
    });
  }


  getAll() {
    return this.categoryService.getAll().subscribe(value => {
      this.categoriesList = value;
    })
  }


  submit() {
    const product = this.productForm.value;
    this.productService.addProduct(product).subscribe(value => {
      console.log(product)
    });
    this.productForm.reset();
  }
}
