import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {HomeComponent} from './components/home/home.component';
import {PageNotFoundComponent} from './components/page-not-found/page-not-found.component';
import {EmployeesListComponent} from './components/employees/employees-list/employees-list.component';
import {BrowserModule} from '@angular/platform-browser';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {FontAwesomeModule} from '@fortawesome/angular-fontawesome';
import {Ng2SearchPipeModule} from 'ng2-search-filter';
import {FormsModule} from '@angular/forms';
import {NgxPaginationModule} from 'ngx-pagination';
import { EmployeeAddComponent } from './components/employees/employee-add/employee-add.component';

const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'employee-list', component: EmployeesListComponent},
  {path: 'employee-add', component: EmployeeAddComponent},


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
    NgxPaginationModule
  ],
  exports: [RouterModule],
  declarations: [
    HomeComponent,
    PageNotFoundComponent,
    EmployeesListComponent,
    EmployeeAddComponent
  ]
})
export class AppRoutingModule {
}
