import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment.prod';
import { Categoria } from '../model/Categoria';

@Injectable({
  providedIn: 'root'
})
export class CategoriaService {

  constructor(
    private http: HttpClient
  ) { }

  token ={
    headers: new HttpHeaders().set('Authorization', environment.token)
 }

  getAll(): Observable<Categoria[]>{
    return this.http.get<Categoria[]>('https://ecomawe.herokuapp.com/categoria/buscartodos')
  }
  postCategoria(categoria:Categoria): Observable<Categoria>{
    return this.http.post<Categoria>('https://ecomawe.herokuapp.com/categoria/Cadastrar', categoria)
  }

  getByIdCategoria(id: number): Observable<Categoria>{
    return this.http.get<Categoria> (`https://ecomawe.herokuapp.com/categoria/buscarpeloid/${id}`)
  }
  
  putCategoria(  categoria: Categoria): Observable<Categoria>{
    return this.http.put<Categoria>('https://ecomawe.herokuapp.com/categoria/Alterar',  categoria)
  }

  deleteCategoria(id: number){
    return this.http.delete(`https://ecomawe.herokuapp.com/categoria/deletar/${id}`)
  }
}




