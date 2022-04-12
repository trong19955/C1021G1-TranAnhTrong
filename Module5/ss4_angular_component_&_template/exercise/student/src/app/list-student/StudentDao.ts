import {IStudent} from "./IStudent";
import {Injectable} from "@angular/core";

@Injectable({
  providedIn: 'root'
})
export class StudentDao {
  public static students: IStudent[] = [{
    id: 1,
    name: 'Trần Anh Trong',
    age: 12,
    email: 'trong@gmail.com',
    address: '146/58 Phan Văn Định',
    mark: 9
  },
    {
      id: 2,
      name: 'Lê Thành Long ',
      age: 12,
      email: 'Long@gmail.com',
      address: 'DN',
      mark: 5
    },
    {
      id: 3,
      name: 'Nguyễn Hùng Sơn',
      age: 12,
      email: 'Sơn@gmail.com',
      address: 'Quảng trị',
      mark: 4
    },
    {
      id: 4,
      name: 'Đào Bùi Xuân Thắng',
      age: 12,
      email: 'Thắng@gmail.com',
      address: 'Quảng trị',
      mark: 1
    },
  ]


  addStudent(student: IStudent) {
    StudentDao.students.push(student)
  }
}

