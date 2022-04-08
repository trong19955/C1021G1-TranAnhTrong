import {Component, OnInit} from '@angular/core';

import {StudentDao} from "./StudentDao";
import {IStudent} from "./IStudent";
import {FormGroup, FormControl, Validators}from '@angular/forms'
@Component({
  selector: 'app-list-student',
  templateUrl: './list-student.component.html',
  styleUrls: ['./list-student.component.css']
})
export class ListStudentComponent implements OnInit {
  students: IStudent[] = StudentDao.students;
  student : IStudent | undefined;
  studentForm = new FormGroup({
    id: new FormControl(),
    name: new FormControl(),
    age: new FormControl(),
    email: new FormControl(),
    address: new FormControl(),
    mark :new FormControl()
  })
  constructor() { }

  ngOnInit(): void {
  }

  getStudent(value : IStudent){
    this.student = value;
  }
  onSubmit() {
    console.log(this.studentForm.value);
  }

  addSkills() {
    StudentDao.students.push(this.studentForm.value);
  }
}
