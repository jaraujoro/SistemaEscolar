import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import {
  FormBuilder,
  FormGroup,
  Validators,
  ReactiveFormsModule,
} from '@angular/forms';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/service/login-service/login-service';

@Component({
  selector: 'app-login-usuario',
  standalone: true,
  imports: [CommonModule, RouterModule, ReactiveFormsModule],
  templateUrl: './login-usuario.html',
  styleUrl: './login-usuario.css',
})
export class LoginUsuario {
  mensajeError: string = '';
  formControlLogin: FormGroup;

  constructor(
    private formBuilder: FormBuilder,
    private loginService: LoginService,
    private router: Router
  ) {
    this.formControlLogin = this.formBuilder.group({
      loginUsuario: ['', Validators.required],
      passwordUsuario: ['', Validators.required],
    });
  }

  onSubmitLogin() {
    if (this.formControlLogin.invalid) {
      this.mensajeError = 'Completa todos los campos';
      return;
    }
    const { loginUsuario, passwordUsuario } = this.formControlLogin.value;
    this.loginService
      .loginUserService(loginUsuario, passwordUsuario)
      .subscribe({
        next: (response) => {
          this.router.navigate(['/EduCenter']);
        },
        error: (error) => {
          this.mensajeError = error.error || 'Error en el inicio de sesion';
        },
      });
  }
}
