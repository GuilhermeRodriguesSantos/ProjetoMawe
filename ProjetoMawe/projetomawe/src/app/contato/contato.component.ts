import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { environment } from 'src/environments/environment.prod';
import { Usuario } from '../model/Usuario';
import { AuthService } from '../service/auth.service';
import { ProdutoService } from '../service/produto.service';

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
    environment.menu = true

    window.scroll(0,0)

  }


  enviar(){
    alert ("Mensagem enviada com sucesso!")
  }
}

