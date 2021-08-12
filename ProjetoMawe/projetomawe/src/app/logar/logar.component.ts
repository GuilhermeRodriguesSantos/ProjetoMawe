import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { environment } from 'src/environments/environment.prod';
import { UsuarioLogin } from '../model/UsuarioLogin';
import { AuthService } from '../service/auth.service';

@Component({
  selector: 'app-logar',
  templateUrl: './logar.component.html',
  styleUrls: ['./logar.component.css']
})
export class LogarComponent implements OnInit {

  usuarioLogin: UsuarioLogin = new UsuarioLogin
  
  constructor(
    private auth:AuthService,
    private router: Router
  ) { }

  ngOnInit(){
    window.scroll(0,0)
  }


  logar(){
    this.auth.logar(this.usuarioLogin).subscribe((resp: UsuarioLogin) => {
      this.usuarioLogin = resp

      environment.id = this.usuarioLogin.id
      environment.nome = this.usuarioLogin.nome
      environment.token = this.usuarioLogin.token
      environment.endereco

      console.log(environment.id)
      console.log(environment.nome)
      console.log(environment.token)
      console.log(environment.endereco)
      

      this.router.navigate(['/Inicio-empresa'])

      
    }, erro => {
      if(erro.status == 500  || erro.status == 400){
        alert('Usuario ou senha incoretos, tente novamente!')
      }
    })
  }

}
