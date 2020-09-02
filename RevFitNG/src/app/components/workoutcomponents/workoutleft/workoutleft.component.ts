import { Component, OnInit } from '@angular/core';
import { Workout } from 'src/app/model/Workout';
const STORAGE_KEY = 'USER';
const CURR_WORKOUT = 'CURR';

@Component({
  selector: 'app-workoutleft',
  templateUrl: './workoutleft.component.html',
  styleUrls: ['./workoutleft.component.css']
})
export class WorkoutleftComponent implements OnInit {

  constructor() { }

  currWorkout: Workout;

  ngOnInit(): void {
    this.currWorkout=JSON.parse(sessionStorage.getItem(CURR_WORKOUT));
  }

}
