import { Injectable } from '@angular/core'; 
import { HttpClient } from '@angular/common/http';
import { map, Observable } from 'rxjs';
import { JwtHelperService } from '@auth0/angular-jwt';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private apiUrl = 'http://localhost:8081/auth'; // URL do backend
  private jwtHelper = new JwtHelperService();  // Instanciando o decodificador de JWT

  constructor(private http: HttpClient) {}

  // Método para registrar um usuário
  register(userData: any): Observable<any> {
    return this.http.post(`${this.apiUrl}/register`, userData);
  }

  // Método para fazer login e obter um token
  login(credentials: any): Observable<any> {
    return this.http.post(`${this.apiUrl}/login`, credentials).pipe(
      map((response: any) => {
        if (response && response.token) {
          this.saveToken(response.token);  // Salva o token após o login
          return response;
        } else {
          throw new Error('Token inválido');
        }
      })
    );
  }

  // Método para salvar o token no localStorage
  saveToken(token: string): void {
    localStorage.setItem('authToken', token);
  }

  // Método para recuperar o token salvo
  getToken(): string | null {
    return localStorage.getItem('authToken');
  }

  // Método para verificar se o usuário está autenticado
  isAuthenticated(): boolean {
    const token = this.getToken();
    return token != null && !this.isTokenExpired(token); // Verifica se o token não expirou
  }

  // Método para verificar se o token está expirado
  private isTokenExpired(token: string): boolean {
    try {
      const decoded: any = this.decodeToken(token);
      return decoded.exp < Date.now() / 1000; // Verifica a data de expiração
    } catch (error) {
      return true;  // Se não conseguir decodificar, o token é considerado inválido
    }
  }

  // Método para decodificar o token JWT
  private decodeToken(token: string): any {
    const parts = token.split('.');
    if (parts.length !== 3) {
      throw new Error('Token inválido');
    }
    const payload = parts[1];
    const decoded = atob(payload); // Decodifica o payload
    return JSON.parse(decoded);
  }

  // Método para logout
  logout(): void {
    localStorage.removeItem('authToken');
  }

  // Método para obter o perfil do usuário
  getUserProfile(): Observable<any> {
    return this.http.get(`${this.apiUrl}/profile`, {
      headers: { Authorization: `Bearer ${this.getToken()}` }
    });
  }
}
