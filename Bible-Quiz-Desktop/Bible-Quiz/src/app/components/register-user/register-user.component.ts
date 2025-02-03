import { Component } from '@angular/core';
import { AuthService } from '../../services/auth.service'; // Certifique-se de importar o AuthService
import { Router } from '@angular/router'; // Para redirecionar após o cadastro

@Component({
  selector: 'app-register-user',
  templateUrl: 'register-user.component.html',
  styleUrls: ['./register-user.component.css']
  
})
export class RegisterUserComponent {
  username: string = '';
  email: string = '';
  password: string = '';
  confirmPassword: string = '';

  constructor(private authService: AuthService, private router: Router) {}

  onSubmit() {
    if (this.password !== this.confirmPassword) {
      alert('As senhas não coincidem.');
      return;
    }

    // Cria o objeto com os dados do usuário
    const userData = {
      username: this.username,
      email: this.email,
      password: this.password
    };

    // Envia os dados para o serviço de autenticação
    this.authService.register(userData).subscribe(
      (response) => {
        console.log('Usuário registrado com sucesso', response);
        this.router.navigate(['/login']);  // Redireciona para a página de login após o cadastro
      },
      (error) => {
        console.error('Erro ao registrar usuário', error);
        alert('Erro ao cadastrar o usuário. Tente novamente.');
      }
    );
  }
}
