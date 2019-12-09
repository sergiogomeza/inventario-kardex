import { Injectable } from '@angular/core';
import { HttpClient,HttpParams, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { ProductoGet } from '../model/producto.model';
import { AgregarProducto } from '../model/agregar-producto.model';

@Injectable({
  providedIn: 'root'
})
export class ProductosService {
  baseUrl = 'http://localhost:8080/inventario';
  constructor(private httpClient: HttpClient) { }

  getProductos():Observable<ProductoGet[]>{
    return this.httpClient.get<ProductoGet[]>(this.baseUrl)
      .pipe(map(response =>{
        return response
      }));
  }
  actualizarProducto(idProducto:number,cantidad:string){
    return this.httpClient.put(this.baseUrl+'/actualizar/'+idProducto+'/'+cantidad,"");
  }
  agregarProducto(agregarProducto:AgregarProducto){
    const config = { headers: new HttpHeaders().set('Content-Type', 'application/json') };
    return this.httpClient.post(this.baseUrl,agregarProducto,config);
  }
}
