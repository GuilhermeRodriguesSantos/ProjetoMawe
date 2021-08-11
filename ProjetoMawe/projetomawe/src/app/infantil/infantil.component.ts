import { Component, OnInit } from '@angular/core';
import { environment } from 'src/environments/environment.prod';

@Component({
  selector: 'app-infantil',
  templateUrl: './infantil.component.html',
  styleUrls: ['./infantil.component.css']
})
export class InfantilComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
    environment.menu = true
  }

}
