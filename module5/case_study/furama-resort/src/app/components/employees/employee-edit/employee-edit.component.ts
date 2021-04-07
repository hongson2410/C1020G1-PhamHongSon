import {Component, OnInit} from '@angular/core';
import {FormGroup, FormBuilder, Validators} from '@angular/forms';
import {EmployeeService} from '../../../services/employee.service';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-employee-edit',
  templateUrl: './employee-edit.component.html',
  styleUrls: ['./employee-edit.component.css']
})
export class EmployeeEditComponent implements OnInit {
  public formEditEmployee: FormGroup;
  public maxDate = new Date();
  public minDate = new Date(1900, 0, 1);

  constructor(public activatedRoute: ActivatedRoute,
              public formBuilder: FormBuilder,
              public employeeService: EmployeeService,
              public router: Router) {
  }

  ngOnInit(): void {
    this.formEditEmployee = this.formBuilder.group({
      id: [''],
      fullName: ['', [Validators.required, Validators.pattern(/^([\p{Lu}]|([\p{Lu}][\p{Ll}]{1,8}))(\s([\p{Lu}]|[\p{Lu}][\p{Ll}]{1,10})){0,5}$/u)]],
      position: ['', [Validators.required]],
      educationDegree: ['', [Validators.required]],
      division: ['', [Validators.required]],
      birthday: ['', [Validators.required]],
      idCard: ['', [Validators.required, Validators.pattern(/^[0-9]{9}$/u)]],
      salary: ['', [Validators.required, Validators.pattern(/^[0-9]*$/u)]],
      email: ['', [Validators.required, Validators.email]],
      phoneNumber: ['', [Validators.required, Validators.pattern(/^(090|091|([\(]84[\)][\+]90)|([\(]84[\)][\+]91))[0-9]{7}$/u)]],
      address: ['', [Validators.required]]
    });

    let id = this.activatedRoute.snapshot.params['id'];
    this.employeeService.getEmployeeById(id).subscribe(next => {
      this.formEditEmployee.setValue(next);
    });
  }

  get fullName(){
    return this.formEditEmployee.get('fullName');
  }

  get position(){
    return this.formEditEmployee.get('position');
  }

  get educationDegree(){
    return this.formEditEmployee.get('educationDegree');
  }

  get division(){
    return this.formEditEmployee.get('division');
  }

  get birthday(){
    return this.formEditEmployee.get('birthday');
  }

  get idCard(){
    return this.formEditEmployee.get('idCard');
  }

  get salary(){
    return this.formEditEmployee.get('salary');
  }

  get email(){
    return this.formEditEmployee.get('email');
  }

  get phoneNumber(){
    return this.formEditEmployee.get('phoneNumber');
  }

  get address(){
    return this.formEditEmployee.get('address');
  }

  editEmployee() {
    this.employeeService.updateEmployee(this.formEditEmployee.value).subscribe();
    this.router.navigateByUrl('employee-list');
  }
}
