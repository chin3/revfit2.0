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
    'Access-Control-Allow-Origin': 'http://revfitbucket.s3-website.us-east-2.amazonaws.com/',
    'Access-Control-Allow-Methods': 'GET, POST, OPTIONS, PUT, PATCH, DELETE',
    'Access-Control-Allow-Credentials': 'true'
  });
  
  getJoinsByWorkout(wid: number) {
    return this.http.get<WorkoutExercise[]>("http://ec2-3-12-196-129.us-east-2.compute.amazonaws.com:8081/workoutExercise/"+wid, {headers: this.headers});
  }

  addWorkoutExercises(array : WorkoutExercise[]) {
    return this.http.post<WorkoutExercise[]>("http://ec2-3-12-196-129.us-east-2.compute.amazonaws.com:8081/workoutExercise", array, {headers: this.headers});
  }

  updateWorkoutExercise(w : WorkoutExercise) {
    return this.http.put<WorkoutExercise>("http://ec2-3-12-196-129.us-east-2.compute.amazonaws.com:8081/workoutExercise/search", w, {headers: this.headers});
  }
}
