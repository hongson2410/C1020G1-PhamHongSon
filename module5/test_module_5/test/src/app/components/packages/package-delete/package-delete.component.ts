import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material/dialog';
import {PackageListComponent} from '../package-list/package-list.component';
import {PackageServiceService} from '../../../services/package-service.service';

@Component({
  selector: 'app-package-delete',
  templateUrl: './package-delete.component.html',
  styleUrls: ['./package-delete.component.css']
})
export class PackageDeleteComponent implements OnInit {
  public package;

  constructor(
    public dialogRef: MatDialogRef<PackageListComponent>,
    public employeeService: PackageServiceService,
    @Inject(MAT_DIALOG_DATA) public data: any) {
  }

  onNoClick(): void {
    this.dialogRef.close();
  }

  ngOnInit(): void {
    this.package = this.data.data1;
  }

  deleteEmployee() {
    this.employeeService.deletePackage(this.data.data1.id).subscribe(data => {
      this.dialogRef.close();
    });
  }
}
