import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import {FormsModule} from '@angular/forms';
import { LikesComponent } from './likes/likes.component';
import { NavbarComponent } from './navbar/navbar.component';
import { FooterComponent } from './footer/footer.component';
import { ArticleComponent } from './article/article.component';
import { FormCreateComponent } from './form-create/form-create.component';

@NgModule({
  declarations: [
    AppComponent,
    LikesComponent,
    NavbarComponent,
    FooterComponent,
    ArticleComponent,
    FormCreateComponent
  ],
    imports: [
        BrowserModule,
        FormsModule
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
