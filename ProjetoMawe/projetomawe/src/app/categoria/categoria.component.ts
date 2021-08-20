import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { environment } from 'src/environments/environment.prod';
import { Categoria } from '../model/Categoria';
import { Usuario } from '../model/Usuario';
import { AuthService } from '../service/auth.service';
import { CategoriaService } from '../service/categoria.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-categoria',
  templateUrl: './categoria.component.html',
  styleUrls: ['./categoria.component.css']
})
export class CategoriaComponent implements OnInit {
  Segmento: string
  categoria: Categoria = new Categoria()
  listaCategorias: Categoria[]
  idUsuario = environment.id
  usuario: Usuario

  constructor(
    private router: Router,
    private categoriaService: CategoriaService,
    private authService: AuthService
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

    findByIdUsuario(){
      this.authService.getByIdUsuario(this.idUsuario).subscribe((resp: Usuario) => {
        this.usuario = resp
        console.log(this.usuario)
      })
    
    }


  cadastrar(){
    this.categoria.segmentoEmpresa = this.Segmento
    this.categoriaService.postCategoria(this.categoria).subscribe((resp: Categoria)=>{
      this.categoria=resp
      Swal.fire({
        icon: 'success',
        title: 'Sucesso...',
        text: 'Segmetno cadastrado com sucesso!',
      })
    
      this.findAllCategorias()
      this.categoria= new Categoria()
      
    }, erro => {
      if(erro.status == 400 || erro.status == 500){
          Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: 'Escreva os campos corretamente e, tente novamente!'
          })
      }
    })
  }

  seguimento(event: any){
    this.Segmento = event.target.value
  }
  
// < Componente cadastrar 
}
