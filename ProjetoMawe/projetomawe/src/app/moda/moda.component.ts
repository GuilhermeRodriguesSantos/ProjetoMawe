import { Component, OnInit } from '@angular/core';
import { environment } from 'src/environments/environment.prod';

@Component({
  selector: 'app-moda',
  templateUrl: './moda.component.html',
  styleUrls: ['./moda.component.css']
})
export class ModaComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
    environment.menu = true
  }

}
