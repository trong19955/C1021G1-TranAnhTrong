import {Component, OnInit} from '@angular/core';

import {StudentDao} from "./StudentDao";
import {IStudent} from "./IStudent";

@Component({
  selector: 'app-list-student',
  templateUrl: './list-student.component.html',
  styleUrls: ['./list-student.component.css']
})
export class ListStudentComponent implements OnInit {
  students: IStudent[] = StudentDao.students;
  student : IStudent | undefined;
  constructor() { }

  ngOnInit(): void {
  }

  getStudent(value : IStudent){
    this.student = value;
  }

}
