import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { environment } from 'src/environments/environment.prod';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-menu3',
  templateUrl: './menu3.component.html',
  styleUrls: ['./menu3.component.css']
})
export class Menu3Component implements OnInit {

  constructor(
    private router: Router
  ) { }

  ngOnInit(){
  }

  sair(){
    Swal.fire({
      icon: 'warning',
      title: 'Opa você Saiu...',
      text: 'Logue-se Novamente!'
    })
      this.router.navigate(['/home'])
      environment.nome = ''
      environment.nome = ''
      environment.token = ''
      environment.id = 0
      environment.tipoUsuario= ''
  }
}
