import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  email: string = '';
  password: string = '';
  isLoading: boolean = false;
  errorMessage: string = '';

  constructor(private authService: AuthService, private router: Router) {}

  login(): void {
    this.isLoading = true;
    const credentials = { email: this.email, password: this.password };

    this.authService.login(credentials).subscribe(
      (response) => {
        if (response.token) {
          this.authService.saveToken(response.token);  // Salva o token no localStorage
          this.router.navigate(['/profile']);  // Navega para o perfil ou a página principal
        } else {
          this.errorMessage = 'Erro ao fazer login. Token não retornado.';
        }
        this.isLoading = false;
      },
      (error) => {
        console.error('Erro ao realizar login:', error);
        if (error.status === 401) {
          this.errorMessage = 'Credenciais inválidas. Tente novamente.';
        } else {
          this.errorMessage = 'Ocorreu um erro inesperado. Tente novamente.';
        }
        this.isLoading = false;
      }
    );
  }

  onSubmit(): void {
    this.login();  // Apenas chama o método `login` para evitar duplicação de código
  }
}
