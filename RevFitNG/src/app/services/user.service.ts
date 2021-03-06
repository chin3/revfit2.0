import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from '../model/User';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private headers = new HttpHeaders({
    'Content-Type': 'application/json',
    // 'Access-Control-Allow-Origin': 'http://localhost:4200/',
    'Access-Control-Allow-Origin': 'http://revfitbucket.s3-website.us-east-2.amazonaws.com/',
    'Access-Control-Allow-Methods': 'GET, POST, OPTIONS, PUT, PATCH, DELETE',
    'Access-Control-Allow-Credentials': 'true'
  });

  constructor(private http: HttpClient) { }

  url : string = "http://ec2-3-12-196-129.us-east-2.compute.amazonaws.com:8081";
  // url : string = "http://localhost:8081";

  loginUser(username, password) {
    return this.http.post<User>(this.url + '/user/login', { "username": username, "password": password }, { headers: this.headers });
  }

  registerUser(new_user) {
    return this.http.post<User>(this.url + '/user', JSON.stringify(new_user), { headers: this.headers });
  }

}
