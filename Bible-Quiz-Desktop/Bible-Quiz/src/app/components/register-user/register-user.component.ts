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
  email: string = '';
  password: string = '';

  onSubmit() {
    console.log('Email:', this.email);
    console.log('Senha:', this.password);
    // Aqui você pode adicionar lógica para autenticar o usuário
  }

  // Método de navegação, mas não implementado
  navigateTo(arg0: string) {
    throw new Error('Method not implemented.');
  }
}
