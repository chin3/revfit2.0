import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/model/user';

@Component({
  selector: 'app-rightcard',
  templateUrl: './rightcard.component.html',
  styleUrls: ['./rightcard.component.css']
})
export class RightcardComponent implements OnInit {

  curUser : User;
  feet : number;

  constructor() { }

  ngOnInit(): void {
    this.curUser = JSON.parse(window.sessionStorage.getItem("USER"));
    this.feet = Math.floor(this.curUser.height/12);
  }

}
