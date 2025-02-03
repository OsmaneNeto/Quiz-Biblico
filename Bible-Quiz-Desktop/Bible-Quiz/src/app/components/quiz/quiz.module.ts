// quiz.module.ts
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { QuizComponent } from './quiz.component';

@NgModule({
  declarations: [QuizComponent],   // Declare o componente aqui
  imports: [CommonModule],         // Importe o módulo comum
  exports: [QuizComponent]         // Exporte o componente, se necessário
})
export class QuizModule {}
