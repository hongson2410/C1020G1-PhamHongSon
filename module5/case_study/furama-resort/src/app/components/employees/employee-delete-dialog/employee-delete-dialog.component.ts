import {Component, Inject, OnInit} from '@angular/core';
import {MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog';
import {EmployeesListComponent} from '../employees-list/employees-list.component';
import {EmployeeService} from '../../../services/employee.service';

@Component({
  selector: 'app-employee-delete-dialog',
  templateUrl: './employee-delete-dialog.component.html',
  styleUrls: ['./employee-delete-dialog.component.css']
})
export class EmployeeDeleteDialogComponent implements OnInit {
  public employee;

  constructor(
    public dialogRef: MatDialogRef<EmployeesListComponent>,
    public employeeService: EmployeeService,
    @Inject(MAT_DIALOG_DATA) public data: any) {
  }

  onNoClick(): void {
    this.dialogRef.close();
  }

  ngOnInit(): void {
    this.employee = this.data.data1;
  }

  deleteEmployee() {
    this.employeeService.deleteEmployee(this.data.data1.id).subscribe(data => {
      this.dialogRef.close();
    });
  }
}
