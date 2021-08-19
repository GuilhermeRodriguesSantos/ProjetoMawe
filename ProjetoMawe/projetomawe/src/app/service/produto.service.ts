import { HttpClient, HttpHeaders } from '@angular/common/http';
import { templateJitUrl } from '@angular/compiler';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment.prod';
import { produto } from '../model/produto';

@Injectable({
  providedIn: 'root'
})
export class ProdutoService {

  constructor(
    private http:HttpClient
  ) {}

  
    token = {
      headers: new HttpHeaders().set('Authorization', environment.token)
    }

    getByIdProduto(id: number): Observable<produto>{
      return this.http.get<produto>(`https://ecomawe.herokuapp.com/produto/buscar/${id}`)

    }

    postProduto(Produto:produto): Observable<produto>{
      return this.http.post<produto>('https://ecomawe.herokuapp.com/produto/cadastrar',Produto)
    }

    getAllProduto(): Observable<produto[]>{
      return this.http.get<produto[]>('https://ecomawe.herokuapp.com/produto/buscar')
    }

    putProduto(Produto: produto): Observable<produto>{ 
        return this.http.put<produto>('https://ecomawe.herokuapp.com/produto/alterar', Produto)
    }

    deleteProduto(id: number){
      return this.http.delete(`https://ecomawe.herokuapp.com/produto/delete/${id}`)
    }
}
    


