import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreatePostComponent } from './post/create-post/create-post.component';
import { EditPostComponent } from './post/edit-post/edit-post.component';

const routes: Routes = [];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule, CreatePostComponent],
  declarations: [
    CreatePostComponent,
    EditPostComponent
  ]
})
export class AppRoutingModule { }
