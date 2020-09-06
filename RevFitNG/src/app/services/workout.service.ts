import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Workout } from '../model/Workout'
import { User } from '../model/User';

@Injectable({
  providedIn: 'root'
})
export class WorkoutService {
  private headers = new HttpHeaders({
    'Content-Type': 'application/json',
    // 'Access-Control-Allow-Origin': 'http://localhost:4200',
    'Access-Control-Allow-Origin': 'http://revfitbucket.s3-website.us-east-2.amazonaws.com/',
    'Access-Control-Allow-Methods': 'GET, POST, OPTIONS, PUT, PATCH, DELETE',
    'Access-Control-Allow-Credentials': 'true'
  });

  constructor(private http: HttpClient) { }

  url : string = "http://ec2-3-12-196-129.us-east-2.compute.amazonaws.com:8081";
  // url : string = "http://localhost:8081";
  getUserWorkouts(user: User) {
    return this.http.post<Workout[]>(this.url + '/workout/search', JSON.stringify(user), { headers: this.headers });
  }
  
  addWorkout(new_workout) {
    return this.http.post<Workout>(this.url + '/workout/', JSON.stringify(new_workout), { headers: this.headers });
  }

  getWorkoutTime(id : number) {
    return this.http.get<number>(this.url + '/workout/'+id+'/time', {headers:this.headers});
  }

  deleteWorkout(id : number) {
    return this.http.delete<Workout>(this.url + '/workout/'+id, {headers:this.headers})
  }
}
