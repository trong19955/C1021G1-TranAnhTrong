import { Component, OnInit } from '@angular/core';
import {Todo} from '../todo';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {TodoService} from '../todo.service';
// tslint:disable-next-line:variable-name
let _id = 1;
@Component({
  selector: 'app-todo',
  templateUrl: './todo.component.html',
  styleUrls: ['./todo.component.css']
})
export class TodoComponent implements OnInit {
  todos: Todo[] = [];
  constructor(private service: TodoService) { }
  content = new FormGroup({
    action: new FormControl('', [Validators.email, Validators.required])
  });
  ngOnInit(): void {
    this.service.getInfo().subscribe((obj) => {
      {
       this.todos = obj;
      }
    });
  }
  toggleTodo(i: number) {
    this.todos[i].complete = !this.todos[i].complete;
  }

  change() {
    const value = this.content.get('action').value;
    if (value) {
      const todo: Todo = {
        id: _id++,
        content: value,
        complete: false
      };
      this.todos.push(todo);
      this.content.reset();
    }
  }

  delete(id: number) {
    this.service.deleteCategory(id).subscribe(
      () => {
        console.log(`Ok`);
        this.service.getInfo().subscribe((obj) => {
          {
            this.todos = obj;
          }
        });
      },
      (err) => console.log(err)
    );
  }
}
