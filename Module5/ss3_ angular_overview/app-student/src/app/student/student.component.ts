import {Component, OnInit} from '@angular/core';
import {IStudent} from "./IStudent";

@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.css']
})
export class StudentComponent implements OnInit {
   student: IStudent = {
     id: 1,
     name: 'trong',
     email: 'trong@gmail.com',
     address:'phan phan dinh',
     age:'27',
     point:10
   }

  constructor() {
  }

  ngOnInit(): void {
  }
  changeColorValue(point:any){
    this.student.point =point;
  }
}
