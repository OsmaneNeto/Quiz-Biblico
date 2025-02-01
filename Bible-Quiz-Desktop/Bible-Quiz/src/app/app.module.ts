import { Component } from '@angular/core';
import { HttpClientModule } from '@angular/common/http'; // Importa o HttpClientModule
import { RouterOutlet } from '@angular/router';
import { RouterModule } from '@angular/router';
import { IniciarComponent } from './components/iniciar/iniciar.component';
import { QuizComponent } from './components/quiz/quiz.component';
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
    // IniciarComponent,
    // QuizComponent,
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
