//quiz.component.ts
import { Component } from '@angular/core';

@Component({
  selector: 'app-quiz',
  templateUrl: './quiz.component.html',
  styleUrls: ['./quiz.component.css']
})
export class QuizComponent {
  pergunta: string = "Qual é a capital do Brasil?";
  respostas: string[] = ["São Paulo", "Brasília", "Rio de Janeiro", "Salvador"];
  respostaCorreta: string = "Brasília";

  verificarResposta(resposta: string) {
    if (resposta === this.respostaCorreta) {
      alert("Resposta correta!");
    } else {
      alert("Resposta incorreta. Tente novamente.");
    }
  }
}
