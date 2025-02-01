//auth.service.ts
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private apiUrl = 'http://localhost:8081/auth'; // URL do seu backend

  constructor(private http: HttpClient) {}
  

  // Método para registrar um usuário
  register(userData: any): Observable<any> {
    return this.http.post(`${this.apiUrl}/register`, userData);
  }
  

  // Método para fazer login e obter um token
  login(credentials: any): Observable<any> {
    return this.http.post(`${this.apiUrl}/login`, credentials);
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
    return !!this.getToken();
  }

  // Método para logout
  logout(): void {
    localStorage.removeItem('authToken');
  }
}
