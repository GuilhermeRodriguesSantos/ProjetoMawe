import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { environment } from 'src/environments/environment.prod';
import { Categoria } from '../model/Categoria';
import { produto } from '../model/produto';
import { Usuario } from '../model/Usuario';
import { AuthService } from '../service/auth.service';
import { CategoriaService } from '../service/categoria.service';
import { ProdutoService } from '../service/produto.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-inicio-usuario',
  templateUrl: './inicio-usuario.component.html',
  styleUrls: ['./inicio-usuario.component.css']
})
export class InicioUsuarioComponent implements OnInit {
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
    private categoriaService: CategoriaService,
    private authService: AuthService
  ) { }

  ngOnInit() {
    if(environment.token == ''){
      if(environment.token == ''){
        Swal.fire({
          icon: 'error',
          title: 'Oops...',
          text: 'Sua sessão foi encerada, Logue-se Novamente!'
        })
        this.router.navigate(['/Logar'])
      }
    }
      

    this.getAllCategoria()
    this.getAllProduto()
  }



  getAllCategoria(){
    this.listaCategoria = []

   this.categoriaService.getAll().subscribe((resp: Categoria[]) => {
     this.listaCategoria = resp
   })

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

}
