import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {ProductService} from '../../service/product.service';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {Product} from "../../model/product";
import {Category} from "../../model/category";
import {CategoryService} from "../../service/category.service";

@Component({
  selector: 'app-product-delete',
  templateUrl: './product-delete.component.html',
  styleUrls: ['./product-delete.component.css']
})
export class ProductDeleteComponent implements OnInit {

  productForm: FormGroup;
  id: number;
  product: Product;
  category: Category;

  constructor(private productService: ProductService,
              private activatedRoute: ActivatedRoute,
              private categoryService: CategoryService,
              private router: Router) {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.id = +paramMap.get('id');

    });
  }

  ngOnInit() {

    const product = this.getProduct(this.id);
    this.productForm = new FormGroup({
      id: new FormControl(''),
      name: new FormControl(''),
      price: new FormControl(''),
      category: new FormControl(''),
      description: new FormControl(''),
    });

  }

  getProduct(id: number) {
    return this.productService.findById(id).subscribe(value => {
      this.product = value;
    }, error => {
      console.log(error)
    }, () => {
      this.productForm.setValue(this.product);
      this.category = this.productForm.get('category').value;
    });
  }



  deleteProduct(id: number) {
    this.productService.deleteProduct(id).subscribe(value => {
      console.log('delete thanh cong')
    }, error => {
      console.log(error)
    }, () => {
    });
    this.router.navigate(['/product/list']);
  }
}
