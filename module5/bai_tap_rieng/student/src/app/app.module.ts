import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { StudentInfoComponent } from './student-info/student-info.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { StudentListComponent } from './student-list/student-list.component';
import { FormCreateComponent } from './form-create/form-create.component';

@NgModule({
  declarations: [
    AppComponent,
    StudentInfoComponent,
    StudentListComponent,
    FormCreateComponent
  ],
    imports: [
        BrowserModule,
        FormsModule, ReactiveFormsModule
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
