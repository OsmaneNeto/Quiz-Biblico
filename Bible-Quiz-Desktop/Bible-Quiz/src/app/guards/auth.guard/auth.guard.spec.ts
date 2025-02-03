import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AuthGuard } from './auth.guard';

describe('AuthGuard', () => {
  let component: AuthGuard;
  let fixture: ComponentFixture<AuthGuard>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AuthGuard]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AuthGuard);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
