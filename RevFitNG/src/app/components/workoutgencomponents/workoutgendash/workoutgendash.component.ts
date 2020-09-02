import { Component, OnInit } from '@angular/core';
import { WorkoutService } from 'src/app/services/workout.service';
import { Workout } from 'src/app/model/Workout';

@Component({
  selector: 'app-workoutgendash',
  templateUrl: './workoutgendash.component.html',
  styleUrls: ['./workoutgendash.component.css']
})
export class WorkoutgendashComponent implements OnInit {

  constructor(private workoutService: WorkoutService) { }

  new_workout : Workout
  selected : string = "Beginner"

  ngOnInit(): void {
    this.new_workout = new Workout();
    this.new_workout.user = JSON.parse(window.sessionStorage.getItem("USER"));
  }

  addWorkout() {
    console.log(this.new_workout);
    this.new_workout.intensity = this.selected
    this.workoutService.addWorkout(this.new_workout).subscribe((response)=>{console.log(response)},(response)=>{console.log("failed")},()=>{ console.log("finally")} );
  }

  setEasy() {
    this.selected = "Beginner";
  }

  setMedium() {
    this.selected = "Moderate";
  }

  setHard() {
    this.selected = "Intense";
  }
}