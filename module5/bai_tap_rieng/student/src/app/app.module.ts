import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {StudentInfoComponent} from './student-info/student-info.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {StudentListComponent} from './student-list/student-list.component';
import {FormCreateComponent} from './form-create/form-create.component';
import {AppRoutingModule} from './app-routing.module';
import {NavbarComponent} from './navbar/navbar.component';
import {FooterComponent} from './footer/footer.component';
import {FontAwesomeModule} from '@fortawesome/angular-fontawesome';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {FormEditComponent} from './form-edit/form-edit.component';
import {HttpClientModule} from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    StudentInfoComponent,
    StudentListComponent,
    FormCreateComponent,
    NavbarComponent,
    FooterComponent,
    FormEditComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    AppRoutingModule,
    FontAwesomeModule,
    NgbModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
