import { Injectable } from '@angular/core';
import {HttpClient,HttpHeaders} from '@angular/common/http';
import{Workout} from '../model/Workout'
import { User } from '../model/User';

@Injectable({
  providedIn: 'root'
})
export class WorkoutService {
  private headers = new HttpHeaders({'Content-Type':'application/json', 
  'Access-Control-Allow-Origin': 'http://localhost:4200',
  'Access-Control-Allow-Methods': 'GET, POST, OPTIONS, PUT, PATCH, DELETE',
  'Access-Control-Allow-Credentials': 'true'});

constructor(private http: HttpClient) { }

getUserWorkouts(user:User){
  return this.http.post<Workout[]>('http://localhost:8080/workout/search', JSON.stringify(user),{headers: this.headers});
}
  addWorkout(new_workout) {
    return this.http.post<Workout>('http://localhost:8080/workout/', JSON.stringify(new_workout),{headers: this.headers});
  }

}
