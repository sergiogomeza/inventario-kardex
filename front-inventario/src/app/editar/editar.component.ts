import { Component, OnInit } from '@angular/core';
import { ProductosService } from '../services/productos.service';

@Component({
  selector: 'editar',
  templateUrl: './editar.component.html',
  styleUrls: ['./editar.component.css']
})
export class EditarComponent implements OnInit {
  mostrarMensaje : boolean = false;
  mensaje : string = "";
  id : string;
  cantidad: string;
  tipoMovimiento:boolean;
  seleccion : string;
  valorEnvio : string;

  constructor(
    private productosService : ProductosService
    ) { }

  ngOnInit() {
  }

  actualizarInformacion(){
    this.mostrarMensaje = true;
    this.mensaje = "Actualizado";
    this.productosService.actualizarProducto(+this.id,this.valorEnvio).subscribe();
  }

  actualizarid(value:string){
    this.id = value;
  }

  cambioTipoMovimiento(event : any){
    this.seleccion = event.target.value;
    if(this.seleccion === "ingreso"){
      this.valorEnvio = this.cantidad;
    }else{
      this.valorEnvio = "-"+this.cantidad;
    }
  }
}
