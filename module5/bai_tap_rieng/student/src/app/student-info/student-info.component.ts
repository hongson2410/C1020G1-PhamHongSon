import {Component, OnInit} from '@angular/core';
import {IStudent} from './model/IStudent';

@Component({
  selector: 'app-student-info',
  templateUrl: './student-info.component.html',
  styleUrls: ['./student-info.component.css']
})
export class StudentInfoComponent implements OnInit {

  student: IStudent = {
    id: 1,
    name: 'Phúc',
    age: 29,
    mark: 9,
    avatarImg: 'https://cdn.vietnambiz.vn/2020/3/23/9005608425724062764144382127330218338156544n-1584933586723443851956.jpg',
  };

  ngOnInit(): void {
    }
}
