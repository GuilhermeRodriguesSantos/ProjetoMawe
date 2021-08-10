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
      return this.http.get<produto>(`http://localhost:8080/produto/buscar/${id}`, this.token)

    }

    postProduto(Produto:produto): Observable<produto>{
      return this.http.post<produto>('http://localhost:8080/produto/cadastrar',Produto, this.token)
    }

    getAllProduto(): Observable<produto[]>{
      return this.http.get<produto[]>('http://localhost:8080/produto/buscar', this.token)
    }

    putProduto(Produto: produto): Observable<produto>{ 
        return this.http.put<produto>('http://localhost:8080/produto/alterar', Produto, this.token)
    }

    deleteProduto(id: number){
      return this.http.delete(`http://localhost:8080/produto/delete/${id}`, this.token)
    }
}
    


