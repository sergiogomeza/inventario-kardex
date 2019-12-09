import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule} from '@angular/common/http';
import { ProductosService } from "./services/productos.service";
import { RegistrosService } from './services/registros.service'
import { AccordionModule } from 'primeng/accordion';
import { TableModule } from 'primeng/table';
import { MatButtonModule, MatFormFieldModule, MatInputModule, MatRippleModule } from '@angular/material';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ListaInventarioComponent } from './lista-inventario/lista-inventario.component';
import { NuevoProductoComponent } from './nuevo-producto/nuevo-producto.component';
import { NoopAnimationsModule } from '@angular/platform-browser/animations';
import { EditarComponent } from './editar/editar.component';
import { ComunicationService } from './services/comunication.service';


@NgModule({
  declarations: [
    AppComponent,
    ListaInventarioComponent,
    NuevoProductoComponent,
    EditarComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    AccordionModule,
    HttpClientModule,
    TableModule,
    NoopAnimationsModule,
    MatButtonModule,
    MatFormFieldModule,
    MatInputModule,
    MatRippleModule,
    FormsModule
  ],
  exports: [
    MatButtonModule,
    MatFormFieldModule,
    MatInputModule,
    MatRippleModule
  ],
  providers: [
    ProductosService,
    RegistrosService,
    ComunicationService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
