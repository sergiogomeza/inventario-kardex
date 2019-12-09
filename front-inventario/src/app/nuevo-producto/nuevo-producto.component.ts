import { Component, OnInit } from '@angular/core';
import { ProductosService } from '../services/productos.service';
import { AgregarProducto } from '../model/agregar-producto.model';

@Component({
  selector: 'nuevo-producto',
  templateUrl: './nuevo-producto.component.html',
  styleUrls: ['./nuevo-producto.component.css']
})
export class NuevoProductoComponent implements OnInit {
  nombreProducto:string;
  tipoProducto:string;
  precioProducto:number;
  seleccion:string;
  cantidad:number;
  descripcion:string;
  creadoCom:boolean = true;
  agregarProductoDTO: AgregarProducto = new AgregarProducto("","",0,true,0,"");

  constructor(
    private productosService : ProductosService
    ) { }

  ngOnInit() {
  }

  cambioTipoMovimiento(event : any){
    this.seleccion = event.target.value;
    if(this.seleccion === "si"){
      this.creadoCom = true;
    }else{
      this.creadoCom = false;
    }
  }

  agregarProducto(){
    this.agregarProductoDTO.nombreProducto = this.nombreProducto;
    this.agregarProductoDTO.tipoProducto = this.tipoProducto;
    this.agregarProductoDTO.precioProducto = this.precioProducto;
    this.agregarProductoDTO.creadoComunidad = this.creadoCom;
    this.agregarProductoDTO.cantidad = this.cantidad;
    this.agregarProductoDTO.descripcion = this.descripcion;
    this.productosService.agregarProducto(this.agregarProductoDTO).subscribe();
  }

}
