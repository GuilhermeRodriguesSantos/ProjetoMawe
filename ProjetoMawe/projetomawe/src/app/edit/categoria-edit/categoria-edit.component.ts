import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Categoria } from 'src/app/model/Categoria';
import { CategoriaService } from 'src/app/service/categoria.service';
import { environment } from 'src/environments/environment.prod';

@Component({
  selector: 'app-categoria-edit',
  templateUrl: './categoria-edit.component.html',
  styleUrls: ['./categoria-edit.component.css']
})
export class CategoriaEditComponent implements OnInit {

  idCategoria: number
  Segmento: string
  categoria: Categoria = new Categoria()
  constructor(
    private categoriaService: CategoriaService,
    private router: Router,
    private route: ActivatedRoute
  ) { }

  ngOnInit(){

    environment.menu = true

    if(environment.token == ''){
      this.router.navigate(['/Logar'])
  }
  let id = this.route.snapshot.params['id']
  // alert("id "+id)
  this.findByIdCategoria(id)
}

findByIdCategoria(id: number){
  this.categoriaService.getByIdCategoria(id).subscribe((resp: Categoria) => {
    this.categoria = resp
    //alert("categoria id"+this.categoria.id)
  })

}

seguimento(event: any){
  this.Segmento = event.target.value
}

atualizar(){
  this.categoria.segmentoEmpresa = this.Segmento
 
  this.categoriaService.putCategoria(this.categoria).subscribe((resp: Categoria) => {
     this.categoria = resp
    
     alert('Categoria alterado com sucesso!')
     this.router.navigate(['/categoria'])
   })
}
}
