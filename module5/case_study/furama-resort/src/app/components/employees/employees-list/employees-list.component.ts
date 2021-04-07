import {Component, OnInit} from '@angular/core';
import {EmployeeService} from '../../../services/employee.service';
import {faInfoCircle, faEdit, faTrashAlt, faSearch} from '@fortawesome/free-solid-svg-icons';
import {MatDialog} from '@angular/material/dialog';
import {EmployeeDeleteDialogComponent} from '../employee-delete-dialog/employee-delete-dialog.component';

@Component({
  selector: 'app-employees-list',
  templateUrl: './employees-list.component.html',
  styleUrls: ['./employees-list.component.css']
})
export class EmployeesListComponent implements OnInit {
  public employees;

  faSearch = faSearch;
  faInfoCircle = faInfoCircle;
  faTrashAlt = faTrashAlt;
  faEdit = faEdit;
  term: string;
  p: number = 1;

  constructor(public employeeService: EmployeeService,
              public dialog: MatDialog) {
  }

  ngOnInit(): void {
    this.employeeService.getAllEmployee().subscribe(data => {
      this.employees = data;
    });
  }

  openDialog(id: number): void {
    this.employeeService.getEmployeeById(id).subscribe(data => {
      const dialogRef = this.dialog.open(EmployeeDeleteDialogComponent, {
        width: '600px',
        data: {data1: data},
        disableClose: true,
        panelClass: "foo"
      });

      dialogRef.afterClosed().subscribe(result => {
        console.log('The dialog was closed');
        this.ngOnInit();
      });
    });
  }


}
