import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment.prod';
import { Usuario } from '../model/Usuario';
import { UsuarioLogin } from '../model/UsuarioLogin';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(
    private http: HttpClient
  ) { }


  logar(usuarioLogin: UsuarioLogin): Observable<UsuarioLogin>{
    return this.http.post<UsuarioLogin>('http://localhost:8080/ProjetoMawe/Usuario/Logar', usuarioLogin)

  }

  cadastar(usuario: Usuario) :Observable<Usuario>{
    return this.http.post<Usuario>('http://localhost:8080/ProjetoMawe/Usuario/Cadastrar', usuario)
  }
  logado(){
    let ok: boolean = true

    if(environment.token != ''){
      ok = false
    }
    return ok
  }

  loginOff(){
    let ok: boolean = false
    if(environment.menu){
      ok = true
    }
    return ok
  }

}
