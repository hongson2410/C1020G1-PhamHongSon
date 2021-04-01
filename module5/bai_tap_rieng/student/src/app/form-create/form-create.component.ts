import {Component, OnInit} from '@angular/core';
import {FormGroup, FormBuilder, Validators, FormControl} from '@angular/forms';
import {studentRepository} from '../student-info/model/StudentRepository';

@Component({
  selector: 'app-form-create',
  templateUrl: './form-create.component.html',
  styleUrls: ['./form-create.component.css']
})
export class FormCreateComponent implements OnInit {
  createForm = new FormGroup({
    id: new FormControl('', [Validators.required, Validators.min(0)]),
    name: new FormControl('', Validators.required),
    age: new FormControl('', [Validators.required, Validators.min(18)]),
    mark: new FormControl('', Validators.required)
  });

  constructor() {
  }

  ngOnInit(): void {
  }

  onSubmit() {
    studentRepository.push(this.createForm.value);
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
