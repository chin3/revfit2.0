import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Exercise } from '../model/Exercise';

@Injectable({
  providedIn: 'root'
})
export class ExerciseService {

  constructor(private http : HttpClient) { }

  private headers = new HttpHeaders({'Content-Type':'application/json', 
                                      'Access-Control-Allow-Origin': 'http://localhost:4200',
                                      'Access-Control-Allow-Methods': 'GET, POST, OPTIONS, PUT, PATCH, DELETE',
                                      'Access-Control-Allow-Credentials': 'true'});

  getAllExercises() {
    return this.http.get<Exercise[]>("http://localhost:8080/exercise", {headers: this.headers});
  }
}
