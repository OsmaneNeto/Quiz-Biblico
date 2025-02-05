import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../services/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  user = {
    name: '',
    email: '',
  };
  isLoading: boolean = true; // Estado de carregamento
  errorMessage: string = ''; // Mensagem de erro, caso ocorra

  constructor(private authService: AuthService, private router: Router) {}

  // Lógica para mudança de senha
  changePassword() {
    this.router.navigate(['/change-password']);
  }

  ngOnInit(): void {
    if (this.authService.isAuthenticated()) {
      this.authService.getUserProfile().subscribe(
        (userData) => {
          this.user = userData;
          this.isLoading = false;
        },
        (error) => {
          console.error('Erro ao buscar perfil do usuário:', error);
          this.errorMessage = 'Erro ao carregar o perfil. Por favor, tente novamente.';
          this.isLoading = false;
          this.router.navigate(['/login']);
        }
      );
    } else {
      this.router.navigate(['/login']);
    }
  }
}
