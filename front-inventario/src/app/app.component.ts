import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { ComunicationService } from './services/comunication.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'inventario';
  listaVisible : boolean = true;
  editarVisible : boolean = false;
  nuevoVisible : boolean = false;

  constructor(
      private router: Router, 
      private comunication : ComunicationService
      ) { }

  OnClickLista(){
    this.listaVisible = true;
    this.editarVisible = false;
    this.nuevoVisible = false;
    this.reloadAction();
  }

  OnclickNuevo(){
    this.listaVisible = false;
    this.editarVisible = false;
    this.nuevoVisible = true;
  }

  OnClickEditar(){
    this.listaVisible = false;
    this.editarVisible = true;
    this.nuevoVisible = false;
  }

  reloadAction(){
    this.comunication.invokeReloadButtonClick();
  }
}
