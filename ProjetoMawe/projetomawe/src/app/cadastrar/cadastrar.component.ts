import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { environment } from 'src/environments/environment.prod';
import { Usuario } from '../model/Usuario';
import { AuthService } from '../service/auth.service';
import Swal from 'sweetalert2';

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
    //alert('As senhas digitadas estão incorretas')
    Swal.fire({
      icon: 'warning',
      title: 'Oops...',
      text: 'Usuário ou senha estão incorretos!',
    })
    }

    
    else{
    this.auth.cadastar(this.usuario).subscribe((resp: Usuario) => {
      this.usuario = resp
      this.router.navigate(['/Logar'])
      //alert('Usuario Cadastrado com sucesso!')
      Swal.fire({
        icon: 'success',
        title: 'Boaaa...',
        text: 'Usuário Cadastrado com Sucesso!',
      })
    }
    
    , erro => {
      if(erro.status  == 404){
        //alert('Uauario já existe, por favor se cadastre com outro E-mail!')
        Swal.fire({
          icon: 'error',
          title: 'Usuário já existente',
          text: 'Tente se cadastrar com outro E-mail!',
        })
      }
      
      else if(erro.status == 400){
        //alert('Ops você esqueveu de preencher algum campo, verifique e tente novamente!')
        Swal.fire({
          icon: 'warning',
          title: 'Opss...',
          text: 'Você se esqueceu de prenncher algum campo!',
        })
      }
    })
  }
}

}
