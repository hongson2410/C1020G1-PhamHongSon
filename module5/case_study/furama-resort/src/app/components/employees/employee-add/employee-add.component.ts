import {Component, OnInit} from '@angular/core';
import {FormGroup, FormBuilder, Validators, FormGroupDirective, FormControl, NgForm} from '@angular/forms';
import {EmployeeService} from '../../../services/employee.service';
import {Router} from '@angular/router'
import {ErrorStateMatcher} from '@angular/material/core';

export class MyErrorStateMatcher implements ErrorStateMatcher {
  isErrorState(control: FormControl | null, form: FormGroupDirective | NgForm | null): boolean {
    const isSubmitted = form && form.submitted;
    return !!(control && control.invalid && (control.dirty || control.touched || isSubmitted));
  }
}

@Component({
  selector: 'app-employee-add',
  templateUrl: './employee-add.component.html',
  styleUrls: ['./employee-add.component.css']
})
export class EmployeeAddComponent implements OnInit {
  public formAddNewEmployee: FormGroup;
  public maxDate = new Date();
  public minDate = new Date(1900,0,1);
  matcher = new MyErrorStateMatcher();

  constructor(public formBuilder: FormBuilder,
              public employeeService: EmployeeService,
              public router: Router) {
  }

  ngOnInit(): void {
    this.formAddNewEmployee = this.formBuilder.group({
      fullName: ['',[Validators.required, Validators.pattern(/^([\p{Lu}]|([\p{Lu}][\p{Ll}]{1,8}))(\s([\p{Lu}]|[\p{Lu}][\p{Ll}]{1,10})){0,5}$/u)]],
      position: ['',[Validators.required]],
      educationDegree: ['',[Validators.required]],
      division: ['',[Validators.required]],
      birthday: ['',[Validators.required]],
      idCard: ['',[Validators.required, Validators.pattern(/^[0-9]{9}$/u)]],
      salary: ['',[Validators.required, Validators.pattern(/^[0-9]*$/u)]],
      email: ['',[Validators.required, Validators.email]],
      phoneNumber: ['',[Validators.required, Validators.pattern(/^(090|091|([\(]84[\)][\+]90)|([\(]84[\)][\+]91))[0-9]{7}$/u)]],
      address: ['',[Validators.required]]
    });
  }

  addNewEmployee() {
    this.employeeService.addNewEmployee(this.formAddNewEmployee.value).subscribe(data => {
      this.router.navigateByUrl('employee-list');
    });
  }

  get fullName(){
    return this.formAddNewEmployee.get('fullName');
  }

  get position(){
    return this.formAddNewEmployee.get('position');
  }

  get educationDegree(){
    return this.formAddNewEmployee.get('educationDegree');
  }

  get division(){
    return this.formAddNewEmployee.get('division');
  }

  get birthday(){
    return this.formAddNewEmployee.get('birthday');
  }

  get idCard(){
    return this.formAddNewEmployee.get('idCard');
  }

  get salary(){
    return this.formAddNewEmployee.get('salary');
  }

  get email(){
    return this.formAddNewEmployee.get('email');
  }

  get phoneNumber(){
    return this.formAddNewEmployee.get('phoneNumber');
  }

  get address(){
    return this.formAddNewEmployee.get('address');
  }
}
