import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Categoria } from 'src/app/model/Categoria';
import { CategoriaService } from 'src/app/service/categoria.service';
import { environment } from 'src/environments/environment.prod';

@Component({
  selector: 'app-categoria-delete',
  templateUrl: './categoria-delete.component.html',
  styleUrls: ['./categoria-delete.component.css']
})
export class CategoriaDeleteComponent implements OnInit {

  categoria: Categoria = new Categoria()
  idCategoria: number

  constructor(
    private categoriaService: CategoriaService,
    private router: Router,
    private route: ActivatedRoute
  ) { }

  ngOnInit() {

    environment.menu = true
    
    if(environment.token == ''){
      this.router.navigate(['/Logar'])
    }
    this.idCategoria = this.route.snapshot.params['id']
    console.log("id categoria"+this.idCategoria)
    this.findByIdCategoria( this.idCategoria)
  }

  findByIdCategoria(idCategoria: number){
    this.categoriaService.getByIdCategoria(idCategoria).subscribe((resp: Categoria) => {
      this.categoria = resp
      console.log("categoria "+JSON.stringify(this.categoria))
    })
  }

  apagar(){
    this.categoriaService.deleteCategoria(this.idCategoria).subscribe(() => {
      alert('Categoria apagado com sucesso!')
      this.router.navigate(['/categoria'])
    })
  }
  
}
