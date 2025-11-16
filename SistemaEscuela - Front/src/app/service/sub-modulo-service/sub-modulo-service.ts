import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment.prod';
@Injectable({
  providedIn: 'root',
})
export class SubModuloService {
  private apiUrl = environment.backendHost + '/sub-modulo-controller';
  constructor(private httpClient: HttpClient) {}

  listSubModuloService(dataPost : any){
    const url = this.apiUrl + '/listado-sub-modulo';
    return this.httpClient.post(url, dataPost).toPromise();
  }

  eliminarSubModuloService(dataPost : any){
    const url = this.apiUrl + '/eliminar-sub-modulo';
    return this.httpClient.post(url, dataPost).toPromise();
  }

  listarModuloCboService(){
    const url = this.apiUrl + '/listado-modulo-cbo'
    return this.httpClient.get(url).toPromise();
  }

}
