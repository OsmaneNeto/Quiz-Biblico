import { Component } from '@angular/core';
import { HttpClientModule } from '@angular/common/http'; // Importa o HttpClientModule
import { RouterOutlet } from '@angular/router';
import { RouterModule } from '@angular/router';
import { IniciarModule } from './components/iniciar/iniciar.module'; // Importe o módulo IniciarModule
import { QuizModule } from './components/quiz/quiz.module'; // Importe o módulo QuizModule
import { HomeComponent } from './components/home/home.component';
import { RegisterUserComponent } from './components/register-user/register-user.component';
import { LoginComponent } from './components/login/login.component';
import { QuestionsComponent } from './components/questions/questions.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    RouterOutlet,
    HttpClientModule,
    RouterModule,
    IniciarModule, // Agora importa o módulo IniciarModule
    QuizModule, // Agora importa o módulo QuizModule
    HomeComponent,
    RegisterUserComponent,
    LoginComponent,
    QuestionsComponent,
  ],
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Bible-Quiz';
}
