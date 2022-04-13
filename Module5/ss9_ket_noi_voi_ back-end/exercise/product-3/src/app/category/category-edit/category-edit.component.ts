import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {CategoryService} from '../../service/category.service';
import {Category} from "../../model/category";

@Component({
  selector: 'app-category-edit',
  templateUrl: './category-edit.component.html',
  styleUrls: ['./category-edit.component.css']
})
export class CategoryEditComponent implements OnInit {
  categoryForm: FormGroup;
  id: number;
  category: Category;

  constructor(private categoryService: CategoryService,
              private activatedRoute: ActivatedRoute,
              private router: Router) {

  }

  ngOnInit() {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.id = +paramMap.get('id');
      console.log(this.id)

    });
    this.getCategory(this.id);
    this.categoryForm =new FormGroup({
      id: new FormControl(''),
      name: new FormControl('')
    })

  }

  getCategory(id: number) {
    return this.categoryService.findById(id).subscribe(category => {
      this.category = category;
      console.log(this.category)
    }, error => {},
      () => this.categoryForm.setValue(this.category));
  }

  updateCategory(id: number) {
    const category = this.categoryForm.value;
    this.categoryService.updateCategory(id, category).subscribe(() => {
      console.log("updated!");
      console.log()
    }, error => {
      console.log(error)
    },() => {
      this.router.navigate(['/category/list']);
    });
  }
}
