import { Component, OnInit } from '@angular/core';
import {NgbModal, ModalDismissReasons} from '@ng-bootstrap/ng-bootstrap';
import {UserService} from '../../services/user.service';
import { User } from 'src/app/model/User';
import { Role } from 'src/app/model/Role';

const STORAGE_KEY = 'USER';
@Component({
  selector: 'app-loginregister',
  templateUrl: './loginregister.component.html',
  styleUrls: ['./loginregister.component.css']
})
export class LoginregisterComponent implements OnInit {
  closeResult: string;
  constructor(private modalService: NgbModal, private userService: UserService) { }
  
  username: string;
  password: string;

  new_user: User;
  default_role: Role;

  open(content) {
    this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title'}).result.then((result) => {
      this.closeResult = `Closed with: ${result}`;
    }, (reason) => {
      this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
    });
  }

  private getDismissReason(reason: any): string {
    if (reason === ModalDismissReasons.ESC) {
      return 'by pressing ESC';
    } else if (reason === ModalDismissReasons.BACKDROP_CLICK) {
      return 'by clicking on a backdrop';
    } else {
      return  `with: ${reason}`;
    }
  }

  login(){
    this.userService.loginUser(this.username,this.password).subscribe(
      (response)=>{
        var user = response;
        if(user == null) {
          alert("Invalid credentials, please try again");
          sessionStorage.clear();
          return;
        }
        sessionStorage.setItem(STORAGE_KEY,JSON.stringify(user));
        window.location.href = '/home';

      },
      (response)=>{
        console.log("failed")
      },
      ()=>{ console.log("finally")} )
  }

  register() {
    console.log(this.new_user);
    this.new_user.role = this.default_role;
    this.userService.registerUser(this.new_user).subscribe((response)=>{console.log(response)},(response)=>{console.log("failed")},()=>{ console.log("finally")} );
  }

  ngOnInit(): void {
    this.new_user = new User();
    this.default_role = new Role();
    this.default_role.id = 1;
    this.default_role.name = 'standard';
    this.default_role.description = 'Standard User';
  }

}
