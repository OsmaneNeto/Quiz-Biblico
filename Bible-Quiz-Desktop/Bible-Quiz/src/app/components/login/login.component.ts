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
  errorMessage: string = '';

  constructor(private authService: AuthService, private router: Router) {}

  onSubmit() {
    const credentials = { email: this.email, password: this.password };
  
    console.log('Enviando credenciais:', credentials);
  
    this.authService.login(credentials).subscribe(
      (response) => {
        console.log('Resposta do login:', response);
        if (response && response.token) {
          this.authService.saveToken(response.token);
          this.router.navigate(['/home']);
        } else {
          this.errorMessage = 'Credenciais inválidas. Por favor, tente novamente.';
        }
      },
      (error) => {
        console.error('Erro ao fazer login', error);
        if (error.status === 401) {
          this.errorMessage = 'Credenciais inválidas. Por favor, tente novamente.';
        } else {
          this.errorMessage = 'Erro ao fazer login. Por favor, tente novamente mais tarde.';
        }
      }
    );
  }
}
