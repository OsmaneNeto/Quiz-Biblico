import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-iniciar',
  templateUrl: './iniciar.component.html',
  styleUrls: ['./iniciar.component.css']
})
export class IniciarComponent {

  constructor(private router: Router) {}

  iniciarQuiz() {
    // Navega para o componente de quiz
    this.router.navigate(['/quiz']);
  }
}

