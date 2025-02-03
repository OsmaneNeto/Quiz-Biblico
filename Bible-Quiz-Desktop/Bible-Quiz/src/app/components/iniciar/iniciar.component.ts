//iniciar.component.ts
import { Component } from '@angular/core';

@Component({
  selector: 'app-iniciar',
  templateUrl: './iniciar.component.html',
  styleUrls: ['./iniciar.component.css']
})
export class IniciarComponent {

  // Método que será chamado ao clicar no botão
  iniciarQuiz(): void {
    console.log("Quiz iniciado!");
    // Adicione aqui a lógica que você deseja ao iniciar o quiz
  }

}
