import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {IStudent} from './model/IStudent';
import {ActivatedRoute} from '@angular/router';
import {StudentService} from '../student.service';

@Component({
  selector: 'app-student-info',
  templateUrl: './student-info.component.html',
  styleUrls: ['./student-info.component.css']
})
export class StudentInfoComponent implements OnInit {
  // @Input() student: IStudent;
  student: IStudent;
  @Output() modifyShowDetail: EventEmitter<any> = new EventEmitter();
  constructor(private activatedRoute: ActivatedRoute,
              private studentService: StudentService) {
  }
  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe((param) =>
    this.student = this.studentService.findStudent(parseInt(param.get('id'))));
    console.log(this.student)
  }

  modify() {
    this.modifyShowDetail.emit();
  }
}
