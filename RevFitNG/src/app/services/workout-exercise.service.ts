import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { WorkoutExercise } from '../model/WorkoutExercise';

@Injectable({
  providedIn: 'root'
})
export class WorkoutExerciseService {


  constructor(private http: HttpClient) { }
  
  private headers = new HttpHeaders({
    'Content-Type': 'application/json',
    'Access-Control-Allow-Origin': 'http://localhost:4200',
    'Access-Control-Allow-Methods': 'GET, POST, OPTIONS, PUT, PATCH, DELETE',
    'Access-Control-Allow-Credentials': 'true'
  });
  
  getJoinsByWorkout(wid: number) {
    return this.http.get<WorkoutExercise[]>("http://localhost:8080/workoutExercise/"+wid, {headers: this.headers});
  }
}
