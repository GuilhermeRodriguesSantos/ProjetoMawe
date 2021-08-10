import { Component, OnInit } from '@angular/core';
import { environment } from 'src/environments/environment.prod';

@Component({
  selector: 'app-saude',
  templateUrl: './saude.component.html',
  styleUrls: ['./saude.component.css']
})
export class SaudeComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
    environment.menu = true
  }

}
