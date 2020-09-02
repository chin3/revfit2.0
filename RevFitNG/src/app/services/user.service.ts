import { Injectable } from '@angular/core';
import {HttpClient,HttpHeaders} from '@angular/common/http';
import {User} from '../model/User';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private headers = new HttpHeaders({'Content-Type':'application/json', 
                                      'Access-Control-Allow-Origin': 'http://localhost:4200',
                                      'Access-Control-Allow-Methods': 'GET, POST, OPTIONS, PUT, PATCH, DELETE',
                                      'Access-Control-Allow-Credentials': 'true'});

  constructor(private http: HttpClient) { }

  loginUser(username, password){
    return this.http.post<User>('http://localhost:8080/user/login',{"username": username , "password":password},{headers: this.headers});
  }

  registerUser(new_user) {
    return this.http.post<User>('http://localhost:8080/user', JSON.stringify(new_user), {headers: this.headers});
  }
}
