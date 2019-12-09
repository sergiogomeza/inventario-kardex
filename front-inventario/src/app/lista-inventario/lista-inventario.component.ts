import { Component, OnInit } from '@angular/core';

import { ProductoGet } from '../model/producto.model';
import { RegistroMovimientos } from '../model/registro-movimientos.model';
import { ProductosService } from '../services/productos.service';
import { RegistrosService } from '../services/registros.service';
import { ComunicationService } from '../services/comunication.service';

@Component({
  selector: 'app-lista-inventario',
  templateUrl: './lista-inventario.component.html',
  styleUrls: ['./lista-inventario.component.css']
})
export class ListaInventarioComponent implements OnInit {
  productoId: number;
  productosInfo : ProductoGet[] = [];
  registrosInfo : RegistroMovimientos[] = [];

  constructor(
    private productosService : ProductosService,
    private registrosService : RegistrosService,
    private comunicationService : ComunicationService
  ) { }

  ngOnInit() {
    this.initializeData();
  }

  initializeData(){
    this.productoId = 0;
    if(this.comunicationService.subsVar==undefined){
      this.comunicationService.subsVar = this.comunicationService.invokeReload.subscribe(()=>{
        this.actualizarLista();
      });
    }
    this.productosService.getProductos()
      .subscribe((respuesta: ProductoGet[]) => {
        this.productosInfo = respuesta;
      });

  }

  onProductoTabOpen(event){
    this.productoId  = this.productosInfo[event.index].id;
    this.registrosService.getRegistros(this.productoId)
      .subscribe((registroDetail : RegistroMovimientos[]) => {
        this.registrosInfo = registroDetail;
      });
  }

  actualizarLista(){
    this.productosService.getProductos()
      .subscribe((respuesta: ProductoGet[]) => {
        this.productosInfo = respuesta;
      });
  }
}
