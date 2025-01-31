import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { RegisterUserComponent } from './components/register-user/register-user.component';
import { LoginComponent } from './components/login/login.component';
import { QuestionsComponent } from './components/questions/questions.component';
import { QuizComponent } from './components/quiz/quiz.component';
import { IniciarComponent } from './components/iniciar/iniciar.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, HomeComponent, RegisterUserComponent, LoginComponent, QuestionsComponent],
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'] // Corrigido aqui
})
export class AppComponent {
  title = 'Bible-Quiz';
}