import { Component, OnInit } from '@angular/core';
import {studentRepository} from '../student-info/model/StudentRepository';

@Component({
  selector: 'app-student-list',
  templateUrl: './student-list.component.html',
  styleUrls: ['./student-list.component.css']
})
export class StudentListComponent implements OnInit {
  students = studentRepository;
  constructor() { }

  ngOnInit(): void {
  }

}
