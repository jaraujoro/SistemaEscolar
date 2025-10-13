import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment.prod';
import { HttpClient } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class ModuloService {
  private apiUrl = environment.backendHost + '/modulo-controller';

  constructor(private httpClient : HttpClient){}

  guardarModuloService(dataPost : any){
    const url = this.apiUrl + '/guardar-modulo';
    return this.httpClient.post(dataPost, url);
  }
}
