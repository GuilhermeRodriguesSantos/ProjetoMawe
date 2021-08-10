import { Component, OnInit } from '@angular/core';
import { environment } from 'src/environments/environment.prod';

@Component({
  selector: 'app-cosmeticos',
  templateUrl: './cosmeticos.component.html',
  styleUrls: ['./cosmeticos.component.css']
})
export class CosmeticosComponent implements OnInit {

  constructor() { }

  ngOnInit(){
    environment.menu = true
  }

}
