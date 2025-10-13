import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root',
})
export class LoginService {
  private apiUrl = environment.backendHost + '/login-controller';

  constructor(private HttpClient: HttpClient) {}

  loginUserService(loginUsuario: string, passwordUsuario: string) {
    let url = this.apiUrl + '/login-validate';
    let dataPost = {
      loginUsuario: loginUsuario,
      passwordUsuario: passwordUsuario,
    };
    return this.HttpClient.post(url, dataPost);
  }
}
