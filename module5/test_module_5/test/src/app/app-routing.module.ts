import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {BrowserModule} from '@angular/platform-browser';
import {Ng2SearchPipeModule} from 'ng2-search-filter';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {FontAwesomeModule} from '@fortawesome/angular-fontawesome';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {NgxPaginationModule} from 'ngx-pagination';
import {MaterialModule} from './material.module';
import {MatSelectModule} from '@angular/material/select';
import {MatButtonModule} from '@angular/material/button';
import {MatIconModule} from '@angular/material/icon';
import { HomeComponent } from './components/home/home.component';
import { PageNotFoundComponent } from './components/page-not-found/page-not-found.component';
import { PackageListComponent } from './components/packages/package-list/package-list.component';
import { PackageAddComponent } from './components/packages/package-add/package-add.component';
import { PackageDeleteComponent } from './components/packages/package-delete/package-delete.component';

const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'package-list', component: PackageListComponent},
  {path: 'package-add', component: PackageAddComponent},

  {path: '**', component: PageNotFoundComponent}
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes),
    BrowserModule,
    Ng2SearchPipeModule,
    NgbModule,
    FontAwesomeModule,
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
    PackageListComponent,
    PackageAddComponent,
    PackageDeleteComponent
  ]
})
export class AppRoutingModule {
}
