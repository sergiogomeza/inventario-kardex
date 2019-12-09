import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AppComponent } from './app.component';
import { ListaInventarioComponent } from './lista-inventario/lista-inventario.component';
import { NuevoProductoComponent } from './nuevo-producto/nuevo-producto.component';
import { EditarComponent } from './editar/editar.component';


const routes: Routes = [
  { path: '', redirectTo: 'main-page', pathMatch: 'full' },
  { path: 'main-page', component: AppComponent },
  { path: 'lista-inventario', component: ListaInventarioComponent },
  { path: 'agregar-nuevo', component: NuevoProductoComponent },
  { path: 'editar', component: EditarComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
