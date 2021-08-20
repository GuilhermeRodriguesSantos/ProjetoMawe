import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { produto } from 'src/app/model/produto';
import { CategoriaService } from 'src/app/service/categoria.service';
import { ProdutoService } from 'src/app/service/produto.service';
import { environment } from 'src/environments/environment.prod';
import { Usuario } from 'src/app/model/Usuario';
import { AuthService } from 'src/app/service/auth.service';

@Component({
  selector: 'app-produtos-apagar',
  templateUrl: './produtos-apagar.component.html',
  styleUrls: ['./produtos-apagar.component.css']
})
export class ProdutosApagarComponent implements OnInit {

  Produto: produto = new produto()
  idProduto:number
  listaProdutos: produto[]
  usuario: Usuario = new Usuario()
  usuarioo: Usuario[]
  idusuario = environment.id

  constructor(
    private categoriaService: CategoriaService,
    private router: Router,
    private route: ActivatedRoute,
    private produtoService: ProdutoService,
    private authService: AuthService
  ) { }

  ngOnInit(){
    if(environment.token == ''){
      this.router.navigate(['/Logar'])
    }
    this.idProduto = this.route.snapshot.params['id']
    this.findByIdCategoria(this.idProduto)
    this.getAllProduto()
    
  }
  getAllProduto(){
    this.produtoService.getAllProduto().subscribe((resp: produto[]) => {
        this.listaProdutos = resp
  
    })
  }
  findByIdUsuario(){
    this.authService.getByIdUsuario(this.idusuario).subscribe((resp: Usuario) => {
      this.usuario = resp
      console.log(this.usuario)
  
    })
  
  }



  findByIdCategoria(id: number){
    this.produtoService.getByIdProduto(id).subscribe((resp: produto) => {
      this.Produto = resp
     })
  }

  apagar(){
    this.produtoService.deleteProduto(this.idProduto).subscribe(() => {
      alert('Produto Apagado com Sucesso')
      this.router.navigate(['/Inicio-empresa'])
    })
  }
  
}
