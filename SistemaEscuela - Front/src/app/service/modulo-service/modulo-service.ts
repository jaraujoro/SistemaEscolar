import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment.prod';
import { HttpClient } from '@angular/common/http';
@Injectable({
  providedIn: 'root',
})
export class ModuloService {
  private apiUrl = environment.backendHost + '/modulo-controller';

  constructor(private httpClient: HttpClient) {}

  guardarModuloService(dataPost: any) {
    const url = this.apiUrl + '/guardar-modulo';
    return this.httpClient.post(url, dataPost).toPromise();
  }

  editarModuloService(dataPost: any) {
    const url = this.apiUrl + '/editar-modulo';
    return this.httpClient.post(url, dataPost).toPromise();
  }

  listarModuloService(where : string) {
    const url = this.apiUrl + '/listado-modulo';
    const dataPost = {
      where: where,
    };
    console.log(dataPost);
    return this.httpClient.post(url, dataPost).toPromise();
  }

  eliminarModuloService(dataPost: any) {
    const url = this.apiUrl + '/eliminar-modulo';
    return this.httpClient.post(url, dataPost).toPromise();
  }
}
