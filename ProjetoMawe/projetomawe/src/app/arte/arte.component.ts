import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { environment } from 'src/environments/environment.prod';

@Component({
  selector: 'app-arte',
  templateUrl: './arte.component.html',
  styleUrls: ['./arte.component.css']
})
export class ArteComponent implements OnInit {

  constructor(
    private router: Router
  ) { }

  ngOnInit(){
  }

}
