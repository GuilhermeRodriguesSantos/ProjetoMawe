import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { environment } from 'src/environments/environment.prod';
import { produto } from '../model/produto';
import { ProdutoService } from '../service/produto.service';

@Component({
  selector: 'app-produto',
  templateUrl: './produto.component.html',
  styleUrls: ['./produto.component.css']
})
export class ProdutoComponent implements OnInit {

  Produto:produto = new produto()
  listaProdutos: produto[]

  constructor(
    private router: Router,
    private ProdutoService: ProdutoService

  ) { }

  ngOnInit() {
    if(environment.token == ''){
      this.router.navigate(['/Logar'])
    }
    this.findAllProdutos()
  }
    findAllProdutos(){
      this.ProdutoService.getAllProduto().subscribe((resp:produto[])=>{
        this.listaProdutos = resp
      })
    }

  
  cadastrar(){
    this.ProdutoService.postProduto(this.Produto).subscribe((resp =>{
      this.Produto = resp
      alert('Produto cadastrado com sucesso!')
      this.findAllProdutos()
      this.Produto = new produto()
    }))
  }
}
