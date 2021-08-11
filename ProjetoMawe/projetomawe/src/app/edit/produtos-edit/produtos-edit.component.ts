import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Categoria } from 'src/app/model/Categoria';
import { produto } from 'src/app/model/produto';
import { CategoriaService } from 'src/app/service/categoria.service';
import { ProdutoService } from 'src/app/service/produto.service';
import { environment } from 'src/environments/environment.prod';

@Component({
  selector: 'app-produtos-edit',
  templateUrl: './produtos-edit.component.html',
  styleUrls: ['./produtos-edit.component.css']
})
export class ProdutosEditComponent implements OnInit {

  Produto: produto = new produto()
  categoria: Categoria = new Categoria()
  listaCategoria: Categoria[]
  idCategoria: number
  Segmento: string
  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private produtoService: ProdutoService,
    private categoriaService: CategoriaService
  ) { }


  ngOnInit() {

    window.scroll(0,0)


    if(environment.token == ''){
      this.router.navigate(['/Logar'])

  }
    let id = this.route.snapshot.params['id']
    this.findByIdProduto(id)
    this.findAllCategoria()
  }


  findByIdProduto(id: number){
    this.produtoService.getByIdProduto(id).subscribe((resp: produto) => {
      this.Produto = resp
    })
  }

  findByIdCategoria(){
    this.categoriaService.getByIdCategoria(this.idCategoria).subscribe((resp: Categoria) => {
      this.categoria = resp
    })
  }

  findAllCategoria(){
    this.categoriaService.getAll().subscribe((resp: Categoria[]) => {
      this.listaCategoria = resp
    })
  }

  seguimento(event: any){
    this.Segmento = event.target.value
  }

  atualizar(){
    this.categoria = new Categoria
    this.categoria.id = this.idCategoria
    
    this.Produto.categoria = this.categoria

    console.log(JSON.stringify(this.Produto))
    this.produtoService.putProduto(this.Produto).subscribe((resp: produto) =>{
      this.Produto = resp


      alert('Produto Atualizado com Sucessoo!')
      this.router.navigate(['/Inicio-empresa'])

    })

  }

}
