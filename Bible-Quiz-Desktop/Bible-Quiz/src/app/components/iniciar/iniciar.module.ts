import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { IniciarComponent } from './iniciar.component'; // O componente 'IniciarComponent' deve ser importado aqui

@NgModule({
  declarations: [IniciarComponent],
  imports: [CommonModule], // Outros módulos necessários podem ser importados aqui
  exports: [IniciarComponent] // Exporte o componente para uso em outros módulos
})
export class IniciarModule {}
