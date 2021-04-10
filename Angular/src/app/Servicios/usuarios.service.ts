import { Injectable } from '@angular/core';
import { Observable, Observer, throwError } from 'rxjs';
import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Usuario } from './../interfaces';



const httpOptions = {
  headers: new HttpHeaders({//siempre va a pedir en el parametro un objeto
    'Content-Type': 'application/json',
    'Authorization': 'my-auth-token'
  })
}

@Injectable({
  providedIn: 'root'
})
export class UsuariosService {

  private urlUsuarios = 'http://localhost:8080/Login/api/usuarios/all';

  constructor(private http: HttpClient) { }

   getUsuarios(): Observable<Usuario[]> {
    const respuesta = this.http.get<Usuario[]>(`${this.urlUsuarios}`);
    return respuesta;
  }
}
