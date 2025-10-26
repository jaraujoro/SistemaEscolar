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
    const url = this.apiUrl + 'listado-sub-modulo';
    return this.httpClient.get(url, dataPost).toPromise();
  }
}
