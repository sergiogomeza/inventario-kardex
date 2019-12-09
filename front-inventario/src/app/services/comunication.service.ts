import { Injectable, EventEmitter } from '@angular/core';
import { Subscription } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ComunicationService {
  invokeReload = new EventEmitter();
  subsVar: Subscription;

  constructor() { }

  invokeReloadButtonClick(){
    this.invokeReload.emit();
  }
}
