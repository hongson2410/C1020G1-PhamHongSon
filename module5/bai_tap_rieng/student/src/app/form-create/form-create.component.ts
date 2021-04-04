import {Component, OnInit} from '@angular/core';
import {FormGroup, FormBuilder, Validators, FormControl} from '@angular/forms';
import {studentRepository} from '../student-info/model/StudentRepository';
import {StudentService} from '../student.service';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-form-create',
  templateUrl: './form-create.component.html',
  styleUrls: ['./form-create.component.css']
})
export class FormCreateComponent implements OnInit {
  createForm = new FormGroup({
    id: new FormControl('', [Validators.required, Validators.min(0), Validators.pattern(/^[-]?\d*$/u)]),
    name: new FormControl('', [Validators.required, Validators.pattern(/^([\p{Lu}]|([\p{Lu}][\p{Ll}]{1,8}))(\s([\p{Lu}]|[\p{Lu}][\p{Ll}]{1,10})){0,5}$/u)]),
    age: new FormControl('', [Validators.required, Validators.min(18), Validators.max(100), Validators.pattern(/^[-]?\d*$/u)]),
    mark: new FormControl('', [Validators.required, Validators.min(0), Validators.max(10), Validators.pattern(/^[-]?\d*$/u)])
  });

  constructor(private studentService: StudentService) {
  }

  ngOnInit(): void {
  }

  onSubmit() {
    this.studentService.addStudent(this.createForm.value);
    this.createForm.reset();
  }

  get id() {
    return this.createForm.get('id');
  }

  get name() {
    return this.createForm.get('name');
  }

  get age() {
    return this.createForm.get('age');
  }

  get mark() {
    return this.createForm.get('mark');
  }
}
