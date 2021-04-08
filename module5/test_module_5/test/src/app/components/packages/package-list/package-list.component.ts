import { Component, OnInit } from '@angular/core';
import {faInfoCircle, faEdit, faTrashAlt, faSearch} from '@fortawesome/free-solid-svg-icons';
import {MatDialog} from '@angular/material/dialog';
import {PackageServiceService} from '../../../services/package-service.service';
import {PackageDeleteComponent} from '../package-delete/package-delete.component';

@Component({
  selector: 'app-package-list',
  templateUrl: './package-list.component.html',
  styleUrls: ['./package-list.component.css']
})
export class PackageListComponent implements OnInit {
  public packages;

  faSearch = faSearch;
  faInfoCircle = faInfoCircle;
  faTrashAlt = faTrashAlt;
  faEdit = faEdit;
  term: string;
  p: number = 1;
  constructor(public packageService: PackageServiceService,
              public dialog: MatDialog) { }

  ngOnInit(): void {
    this.packageService.getAllPackage().subscribe(data => {
      this.packages = data;
    });
  }

  openDialog(id: number): void {
    this.packageService.getPackageByID(id).subscribe(data => {
      const dialogRef = this.dialog.open(PackageDeleteComponent, {
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
