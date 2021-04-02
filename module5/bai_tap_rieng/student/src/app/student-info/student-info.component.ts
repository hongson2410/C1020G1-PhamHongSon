import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {IStudent} from './model/IStudent';

@Component({
  selector: 'app-student-info',
  templateUrl: './student-info.component.html',
  styleUrls: ['./student-info.component.css']
})
export class StudentInfoComponent implements OnInit {
  @Input() student: IStudent;
  @Output() modifyShowDetail: EventEmitter<any> = new EventEmitter();

  ngOnInit(): void {
  }

  modify() {
    this.modifyShowDetail.emit();
  }
}
