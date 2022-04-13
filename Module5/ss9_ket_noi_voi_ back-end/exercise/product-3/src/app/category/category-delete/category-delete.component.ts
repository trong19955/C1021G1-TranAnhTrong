import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {CategoryService} from '../../service/category.service';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {HttpClient} from "@angular/common/http";
import {Category} from "../../model/category";

@Component({
  selector: 'app-category-delete',
  templateUrl: './category-delete.component.html',
  styleUrls: ['./category-delete.component.css']
})
export class CategoryDeleteComponent implements OnInit {
  categoryForm: FormGroup;
  id: number;
  category: Category;

  constructor(private categoryService: CategoryService,
              private router: Router,
              private activatedRoute: ActivatedRoute,
              private http: HttpClient) {

  }

  ngOnInit() {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.id = +paramMap.get('id');

    });
    this.categoryForm = new FormGroup({
      id: new FormControl(''),
      name: new FormControl('')
    })
    this.getCategory(this.id);
  }

  getCategory(id: number) {
    return this.categoryService.findById(id).subscribe(category => {
     this.category = category;
    },error => {
      console.log(error)
    },() => {
      this.categoryForm.setValue(this.category)
    });
  }

  deleteCategory(id: number) {
    this.categoryService.deleteCategory(id).subscribe(value => {
      console.log('xóa thành công')
    });
    this.router.navigate(['/category/list']);
  }
}
