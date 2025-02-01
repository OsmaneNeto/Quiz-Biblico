import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { QuizComponent } from './quiz.component'; // Importe o componente QuizComponent

@NgModule({
  declarations: [QuizComponent],  // Declara o QuizComponent no módulo
  imports: [CommonModule],  // Certifique-se de incluir CommonModule para recursos básicos
  exports: [QuizComponent]  // Exporte o QuizComponent para ser usado em outros módulos
})
export class QuizModule {}
