import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { environment } from 'src/environments/environment.prod';
import { Categoria } from '../model/Categoria';
import { produto } from '../model/produto';
import { Usuario } from '../model/Usuario';
import { CategoriaService } from '../service/categoria.service';
import { ProdutoService } from '../service/produto.service';

@Component({
  selector: 'app-inicio-empresa',
  templateUrl: './inicio-empresa.component.html',
  styleUrls: ['./inicio-empresa.component.css']
})
export class InicioEmpresaComponent implements OnInit {

 
  categoria: Categoria = new Categoria()
  Produto: produto = new produto()
  listaCategoria: Categoria[]
  idCategoria: number
  listaProdutos: produto[]
  usuario: Usuario = new Usuario()
  idusuario = environment.id

  constructor(
    private router: Router,
    private produtoService: ProdutoService,
    private categoriaService: CategoriaService
  ) { }

  ngOnInit() {
    environment.menu = true
    
    if(environment.token == ''){
      this.router.navigate(['/Logar'])
    }

    this.getAllCategoria()
    this.getAllProduto()
  }

  getAllCategoria(){
    this.categoriaService.getAll().subscribe((resp: Categoria[]) => {
      this.listaCategoria = resp
    })

    }
  
getAllProduto(){
  this.produtoService.getAllProduto().subscribe((resp: produto[]) => {
      this.listaProdutos = resp

  })
}


  publicar(){
    this.categoria.id = this.idCategoria
    this.Produto.categoria = this.categoria

   this.usuario.id = environment.id
    this.Produto.empresaCriadora = this.usuario 
    console.log("Postagem "+JSON.stringify(this.Produto))
    this.produtoService.postProduto(this.Produto).subscribe((resp: produto) => {
      this.Produto = resp
      alert('Postagem realizada com sucesso!')
      this.Produto = new produto()
      this.getAllProduto()
    })
  }

  findByIdCategoria(){
    this.categoriaService.getByIdCategoria(this.idCategoria).subscribe((resp: Categoria) => {
      this.categoria = resp
    })
  }
 
}
