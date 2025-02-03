// app.module.ts
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';

import { IniciarModule } from './components/iniciar/niciar.module';
import { QuizModule } from './components/quiz/quiz.module';

import { RegisterUserComponent } from './components/register-user/register-user.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { QuestionsComponent } from './components/questions/questions.component';
import {  RouterOutlet } from '@angular/router';

import { routes } from '../app/app.routes';
import { AppRoutingModule } from './app-routing.module';


@NgModule({
  declarations: [
    RegisterUserComponent,
    AppComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    HomeComponent,
    LoginComponent,
    QuestionsComponent,
    AppRoutingModule,
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
