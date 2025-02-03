//app.routes.ts
import { Routes } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { QuestionsComponent } from './components/questions/questions.component';
import { QuizComponent } from './components/quiz/quiz.component';
import { RegisterUserComponent } from './components/register-user/register-user.component';
import { HomeComponent } from './components/home/home.component';
import { IniciarComponent } from './components/iniciar/iniciar.component';
import { AuthGuard } from './guards/auth.guard/auth.guard';

export const routes: Routes = [
  
  { path: '', component: HomeComponent },
  { path: 'home', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  { path: 'questions', component: QuestionsComponent, canActivate:[AuthGuard] },
  { path: 'quiz', component: QuizComponent, canActivate:[AuthGuard] },
  { path: 'iniciar', component: IniciarComponent, canActivate:[AuthGuard]},
  { path: 'registeruser', component: RegisterUserComponent },
  { path: 'register', component: RegisterUserComponent },
];

