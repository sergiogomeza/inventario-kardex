import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { RegistroMovimientos } from '../model/registro-movimientos.model';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class RegistrosService {
  baseUrl = 'http://localhost:8080/inventario';
  constructor(private httpClient: HttpClient) { }

  getRegistros(idProducto:number):Observable<RegistroMovimientos[]>{
    return this.httpClient.get<RegistroMovimientos[]>(this.baseUrl+'/'+idProducto+'/registros')
      .pipe(map(response =>{
        return response
      }));
  }
}
