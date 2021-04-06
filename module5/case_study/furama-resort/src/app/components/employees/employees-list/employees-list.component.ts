import {Component, OnInit} from '@angular/core';
import {EmployeeService} from '../../../services/employee.service';
import {faInfoCircle,faEdit, faTrashAlt} from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-employees-list',
  templateUrl: './employees-list.component.html',
  styleUrls: ['./employees-list.component.css']
})
export class EmployeesListComponent implements OnInit {
  public employees;

  faInfoCircle = faInfoCircle;
  faTrashAlt = faTrashAlt;
  faEdit = faEdit;
  term: string;
  p: number = 1;

  constructor(public employeeService: EmployeeService) {
  }

  ngOnInit(): void {
    this.employeeService.getAllEmployee().subscribe(data => {
      this.employees = data;
    });
  }

}
