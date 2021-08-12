import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { environment } from 'src/environments/environment.prod';
import { Usuario } from '../model/Usuario';
import { AuthService } from '../service/auth.service';

@Component({
  selector: 'app-cadastrar',
  templateUrl: './cadastrar.component.html',
  styleUrls: ['./cadastrar.component.css']
})
export class CadastrarComponent implements OnInit {

  usuario: Usuario = new Usuario
  confirmaSenha: string
  tipoUsu: string

  constructor(
    private auth:AuthService,
    private router: Router
  ) { }

  ngOnInit(){
    window.scroll(0,0)


  }

  confirmSenha (event: any){
    this.confirmaSenha = event.target.value
  }

  tipoUsuario(event: any){
    this.tipoUsu = event.target.value
  }

  cadastrar(){
    this.usuario.tipoUsuario = this.tipoUsu

    if(this.usuario.senha != this.confirmaSenha){
    alert('As senhas estão incoretas')
    }else{
    this.auth.cadastar(this.usuario).subscribe((resp: Usuario) => {
      this.usuario = resp
      this.router.navigate(['/Logar'])
      alert('Usuario Cadastrado com sucesso!')
    })
  }
}

}
