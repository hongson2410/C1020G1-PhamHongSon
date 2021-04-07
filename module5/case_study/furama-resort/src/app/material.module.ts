import {NgModule} from '@angular/core';
import {MatDatepickerModule} from '@angular/material/datepicker';
import {MatNativeDateModule} from '@angular/material/core';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import {MatDialogModule} from '@angular/material/dialog';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {EmployeeDeleteDialogComponent} from './components/employees/employee-delete-dialog/employee-delete-dialog.component';

@NgModule({
  imports: [
    MatDatepickerModule,
    MatFormFieldModule,
    MatNativeDateModule,
    MatInputModule,
    BrowserAnimationsModule,
    MatDialogModule
  ],
  exports: [
    MatDatepickerModule,
    MatFormFieldModule,
    MatNativeDateModule,
    MatInputModule,
    MatDialogModule,
    BrowserAnimationsModule
  ],
  providers: [MatDatepickerModule],
  entryComponents: [EmployeeDeleteDialogComponent]
})

export class MaterialModule {
}
