import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-register-user',
  standalone: true,
  imports: [FormsModule, CommonModule, RouterModule],  // Corrigido para ter a declaração única de 'imports'
  templateUrl: './register-user.component.html',
  styleUrls: ['./register-user.component.css']
})
export class RegisterUserComponent {
  username: string = '';
  email: string = '';
  password: string = '';
  confirmPassword: string = '';

  onSubmit() {
    if (this.password !== this.confirmPassword) {
      alert('As senhas não coincidem');
      return;
    }

    console.log('Nome de usuário:', this.username);
    console.log('E-mail:', this.email);
    console.log('Senha:', this.password);
    // Aqui você pode adicionar a lógica para enviar os dados ao backend ou algo similar
  }

  navigateTo(route: string) {
    // Navegar para a rota desejada
    // Isso pode ser feito utilizando o Router do Angular
  }
}
