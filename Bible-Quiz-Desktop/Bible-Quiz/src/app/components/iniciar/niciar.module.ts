// iniciar.module.ts
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { IniciarComponent } from './iniciar.component';

@NgModule({
  declarations: [IniciarComponent],  // Declare o componente aqui
  imports: [CommonModule],           // Importe o módulo comum
  exports: [IniciarComponent]        // Exporte o componente, se necessário
})
export class IniciarModule {}
