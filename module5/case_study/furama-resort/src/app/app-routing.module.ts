import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {HomeComponent} from './components/home/home.component';
import {PageNotFoundComponent} from './components/page-not-found/page-not-found.component';
import {EmployeesListComponent} from './components/employees/employees-list/employees-list.component';
import {BrowserModule} from '@angular/platform-browser';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {FontAwesomeModule} from '@fortawesome/angular-fontawesome';
import {Ng2SearchPipeModule} from 'ng2-search-filter';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {NgxPaginationModule} from 'ngx-pagination';
import { EmployeeAddComponent } from './components/employees/employee-add/employee-add.component';
import {MaterialModule} from './material.module';
import { EmployeeDeleteDialogComponent } from './components/employees/employee-delete-dialog/employee-delete-dialog.component';
import { EmployeeEditComponent } from './components/employees/employee-edit/employee-edit.component';
import { CustomerListComponent } from './components/customers/customer-list/customer-list.component';
import {MatSelectModule} from '@angular/material/select';
import {MatButtonModule} from '@angular/material/button';
import {MatIconModule} from '@angular/material/icon';

const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'employee-list', component: EmployeesListComponent},
  {path: 'employee-add', component: EmployeeAddComponent},
  {path: 'employee-edit/:id', component: EmployeeEditComponent},
  {path: 'customer-list', component: CustomerListComponent},

  {path: '**', component: PageNotFoundComponent}
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes),
    BrowserModule,
    NgbModule,
    FontAwesomeModule,
    Ng2SearchPipeModule,
    FormsModule,
    NgxPaginationModule,
    ReactiveFormsModule,
    MaterialModule,
    MatSelectModule,
    MatButtonModule,
    MatIconModule
  ],
  exports: [RouterModule],
  declarations: [
    HomeComponent,
    PageNotFoundComponent,
    EmployeesListComponent,
    EmployeeAddComponent,
    EmployeeDeleteDialogComponent,
    EmployeeEditComponent,
    CustomerListComponent
  ]
})
export class AppRoutingModule {
}
