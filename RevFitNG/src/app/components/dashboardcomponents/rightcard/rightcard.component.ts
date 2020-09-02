import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/model/User';
import {NgbModal, ModalDismissReasons} from '@ng-bootstrap/ng-bootstrap';


@Component({
  selector: 'app-rightcard',
  templateUrl: './rightcard.component.html',
  styleUrls: ['./rightcard.component.css']
})

export class RightcardComponent implements OnInit {
  closeResult: string;
  curUser : User;
  feet : number;

  constructor() { }


  private getDismissReason(reason: any): string {
    if (reason === ModalDismissReasons.ESC) {
      return 'by pressing ESC';
    } else if (reason === ModalDismissReasons.BACKDROP_CLICK) {
      return 'by clicking on a backdrop';
    } else {
      return  `with: ${reason}`;
    }
  }

  ngOnInit(): void {
    this.curUser = JSON.parse(window.sessionStorage.getItem("USER"));
    this.feet = Math.floor(this.curUser.height/12);
  }

  logout(){
      alert("You are now logged out. Close this window to redirect to the login page.")
      setInterval(window.location.href="/loginregister");
      sessionStorage.clear();
  }
}


