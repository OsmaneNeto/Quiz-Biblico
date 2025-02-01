//register-user.component.spec.ts
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { HttpClientModule } from '@angular/common/http'; // Importando o HttpClientModule
import { RegisterUserComponent } from './register-user.component';
import { RouterTestingModule } from '@angular/router/testing'; // Para testar navegação
import { FormsModule } from '@angular/forms'; // Para suportar formulários no teste

describe('RegisterUserComponent', () => {
  let component: RegisterUserComponent;
  let fixture: ComponentFixture<RegisterUserComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [
        RegisterUserComponent, // Componente a ser testado
        HttpClientModule, // Importando o HttpClientModule para o teste
        RouterTestingModule, // Para mockar o roteamento
        FormsModule, // Para suportar formulários
      ],
    }).compileComponents();

    fixture = TestBed.createComponent(RegisterUserComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
