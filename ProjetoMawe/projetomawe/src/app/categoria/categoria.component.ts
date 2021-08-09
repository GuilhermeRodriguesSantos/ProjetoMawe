import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { environment } from 'src/environments/environment.prod';
import { Categoria } from '../model/Categoria';
import { CategoriaService } from '../service/categoria.service';

@Component({
  selector: 'app-categoria',
  templateUrl: './categoria.component.html',
  styleUrls: ['./categoria.component.css']
})
export class CategoriaComponent implements OnInit {
  Segmento: string
  categoria: Categoria = new Categoria()
  listaCategorias: Categoria[]

  constructor(
    private router: Router,
    private categoriaService: CategoriaService
  ) { }



  // > Componente cadastrar 
  ngOnInit() {

    if(environment.token == ''){
      //alert ('Sessão expirada, faça o login novamente')
      this.router.navigate(['/entrar'])
    }
    this.findAllCategorias()
  }
    
    findAllCategorias(){
      
      this.categoriaService.getAll().subscribe((resp: Categoria [])=>{
        this.listaCategorias = resp
        })
      
    }

  cadastrar(){
    this.categoria.segmentoEmpresa = this.Segmento
    this.categoriaService.postCategoria(this.categoria).subscribe((resp: Categoria)=>{
      this.categoria=resp
      alert('Categoria cadastrada com sucesso!')
      this.findAllCategorias()
      this.categoria= new Categoria()
      
    })
  }

  seguimento(event: any){
    this.Segmento = event.target.value
  }
  
// < Componente cadastrar 
}
