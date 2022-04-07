import {Component, Input, OnInit} from '@angular/core';
import {IStudent} from "../list-student/IStudent";
import {StudentDao} from "../list-student/StudentDao";

@Component({
  selector: 'app-view-student',
  templateUrl: './view-student.component.html',
  styleUrls: ['./view-student.component.css']
})
export class ViewStudentComponent implements OnInit {
  @Input()
  students: IStudent |any

  constructor() {
  }

  ngOnInit(): void {
  }

  addPoint(){
    this.students.mark++;
  }
  reductionPoint(){
    this.students.mark--;
  }
}
