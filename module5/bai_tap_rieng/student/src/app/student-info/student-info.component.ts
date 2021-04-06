import {Component, OnInit} from '@angular/core';
import {IStudent} from './model/IStudent';
import {ActivatedRoute} from '@angular/router';
import {StudentService} from '../student.service';

@Component({
  selector: 'app-student-info',
  templateUrl: './student-info.component.html',
  styleUrls: ['./student-info.component.css']
})
export class StudentInfoComponent implements OnInit {
  student: IStudent;
  constructor(private activatedRoute: ActivatedRoute,
              private studentService: StudentService) {
  }
  ngOnInit(): void {
    let id = this.activatedRoute.snapshot.params['id'];
    console.log(id);
    this.studentService.findStudent(id).subscribe( next =>{
      this.student = next;
      console.log(this.student);
    });
  }
}
