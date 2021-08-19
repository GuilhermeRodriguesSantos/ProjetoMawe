import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { environment } from 'src/environments/environment.prod';
import { Usuario } from '../model/Usuario';
import { AuthService } from '../service/auth.service';
import { ProdutoService } from '../service/produto.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-contato',
  templateUrl: './contato.component.html',
  styleUrls: ['./contato.component.css']
})
export class ContatoComponent implements OnInit {

  
  usuario: Usuario = new Usuario
  confirmaAssunto: string
  tipoUsu: string

  
  constructor(
    private auth:AuthService,
    private router: Router
  ) { }

  ngOnInit(){
    window.scroll(0,0)
  }

  enviar(){
    Swal.fire({
      icon: 'success',
      title: 'Sucesso...',
      text: 'Menssagem envida sucesso!',
    })
  }
}

