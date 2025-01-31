import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';
import { AppComponent } from './app.component';
import { routes } from './app.routes'; // Importando as rotas

@NgModule({
  declarations: [
    // Declare outros componentes que não são standalone, se houver
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(routes) // Configurando as rotas
  ],
  providers: []
})
export class AppModule { }