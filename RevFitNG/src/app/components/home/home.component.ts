import { Component, OnInit } from '@angular/core';

import { User } from 'src/app/model/User';
const STORAGE_KEY =  "USER";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
})
export class HomeComponent implements OnInit {
  constructor() {}

  //User
  u: User;
  ngOnInit(): void {
    let user = sessionStorage.getItem(STORAGE_KEY);
    if (user == null) {
      window.location.href = '/loginregister';
    }
  }

  //Main Dash
  ishomedash: boolean = true;
  isworkoutgendash: boolean = false;
  isworkouts: boolean = false;

  //Left Card
  islefthomedash: boolean = true;
  isleftgendash: boolean = false;
  isleftworkouts: boolean = false;

  //Right Card
  isaccountinfo: boolean = true;

  toHome() {
    this.ishomedash = true;
    this.islefthomedash = true;

    if (this.ishomedash) {
      this.isworkoutgendash = false;
      this.isleftgendash = false;
      this.isworkouts = false;
      this.isleftworkouts = false;
    }
  }

  toWorkoutGenerator() {
    this.isleftgendash = true;
    this.isworkoutgendash = true;
    if (this.isworkoutgendash) {
      this.ishomedash = false;
      this.islefthomedash = false;
      this.isworkouts = false;
      this.isleftworkouts = false;
    }
  }

  toWorkouts() {
    this.isworkouts = true;
    this.isleftworkouts = true;

    if (this.isworkouts) {
      this.ishomedash = false;
      this.islefthomedash = false;
      this.isleftgendash = false;
      this.isworkoutgendash = false;
    }
  }
}
