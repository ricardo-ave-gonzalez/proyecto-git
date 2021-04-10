import { Component, OnInit } from '@angular/core';
import { AuthService } from './../../Servicios/auth.service';
import { Router } from '@angular/router';
import { Usuario } from './../../interfaces/';
import { Observable } from 'rxjs';
import { UsuariosService } from './../../Servicios/usuarios.service';


@Component({
  selector: 'app-usuario',
  templateUrl: './usuario.component.html',
  styleUrls: ['./usuario.component.css']
})
export class UsuarioComponent implements OnInit {
  titulo:string = "Listado de Usuarios";
  usuarios:any;

  constructor(private svcUsuarios:UsuariosService, private router:Router) { }

  ngOnInit(): void {
    this.obtenerUsuarios();
  }

  obtenerUsuarios(){
    this.svcUsuarios.getUsuarios().subscribe(z => this.usuarios = z);
  }

}
