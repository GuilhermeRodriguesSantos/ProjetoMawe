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


    postProduto(Produto:produto): Observable<produto>{
      return this.http.post<produto>('http://localhost:8080/produto/cadastrar',Produto, this.token)
    }

    getAllProduto(): Observable<produto[]>{
      return this.http.get<produto[]>('http://localhost:8080/produto/buscar', this.token)
    }
}
    


