import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {StudentListComponent} from './student-list/student-list.component';
import {FormCreateComponent} from './form-create/form-create.component';
import {StudentInfoComponent} from './student-info/student-info.component';
import {FormEditComponent} from './form-edit/form-edit.component';

const routes: Routes = [
  {path: '', component: StudentListComponent},
  {path: 'create', component: FormCreateComponent},
  {path: 'detail/:id', component: StudentInfoComponent},
  {path: 'edit/:id', component: FormEditComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
