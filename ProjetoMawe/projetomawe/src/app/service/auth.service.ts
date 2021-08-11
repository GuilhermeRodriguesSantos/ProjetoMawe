import { HttpClient, HttpHeaders } from '@angular/common/http';
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
    return this.http.post<UsuarioLogin>('https://ecomawe.herokuapp.com/ProjetoMawe/Usuario/Logar', usuarioLogin)

  }
 
  cadastar(usuario: Usuario) :Observable<Usuario>{
    return this.http.post<Usuario>(' https://ecomawe.herokuapp.com/ProjetoMawe/Usuario/Cadastrar', usuario)
  }
  logado(){
    let ok: boolean = true

    if(environment.token != ''){
      ok = false
    }
    return ok
  }

  token ={
    headers: new HttpHeaders().set('Authorization', environment.token)
 }


  getByIdUsuario(id: number): Observable<Usuario>{
    return this.http.get<Usuario>(` https://ecomawe.herokuapp.com/ProjetoMawe/Usuario/Buscar/${id}`)
  }

  loginOff(){
    let ok: boolean = false
    if(environment.menu){
      ok = true
    }
    return ok
  }

}
