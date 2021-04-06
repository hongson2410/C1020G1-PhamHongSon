import {Component, OnInit} from '@angular/core';
import {IStudent} from '../student-info/model/IStudent';
import {ActivatedRoute, Router} from '@angular/router';
import {StudentService} from '../student.service';
import {FormControl, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-form-edit',
  templateUrl: './form-edit.component.html',
  styleUrls: ['./form-edit.component.css']
})
export class FormEditComponent implements OnInit {
  student: IStudent;

  editForm = new FormGroup({
    id: new FormControl(''),
    name: new FormControl('', [Validators.required, Validators.pattern(/^([\p{Lu}]|([\p{Lu}][\p{Ll}]{1,8}))(\s([\p{Lu}]|[\p{Lu}][\p{Ll}]{1,10})){0,5}$/u)]),
    age: new FormControl('', [Validators.required, Validators.min(18), Validators.max(100), Validators.pattern(/^[-]?\d*$/u)]),
    mark: new FormControl('', [Validators.required, Validators.min(0), Validators.max(10), Validators.pattern(/^[-]?\d*$/u)])
  });

  constructor(private activatedRoute: ActivatedRoute,
              private studentService: StudentService,
              private routes: Router) {
  }

  ngOnInit(): void {
    let id = this.activatedRoute.snapshot.params['id'];
    console.log(id);
    this.studentService.findStudent(id).subscribe(next => {
      this.student = next;
      console.log(this.student);
      this.editForm.setValue(this.student);
    });

  }

  get id() {
    return this.editForm.get('id');
  }

  get name() {
    return this.editForm.get('name');
  }

  get age() {
    return this.editForm.get('age');
  }

  get mark() {
    return this.editForm.get('mark');
  }

  onSubmit() {
    this.studentService.updateStudent(this.editForm.value).subscribe();
    this.routes.navigateByUrl('/');
  }
}
