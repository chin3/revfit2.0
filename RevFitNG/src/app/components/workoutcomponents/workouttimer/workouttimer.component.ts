import { Component, OnInit } from '@angular/core';
import { Workout } from 'src/app/model/Workout';
import { WorkoutExercise } from 'src/app/model/WorkoutExercise';
import { WorkoutService } from 'src/app/services/workout.service';
import { WorkoutExerciseService } from 'src/app/services/workout-exercise.service';

const CURR_WORKOUT = "CURR";
@Component({
  selector: 'app-workouttimer',
  templateUrl: './workouttimer.component.html',
  styleUrls: ['./workouttimer.component.css']
})
export class WorkouttimerComponent implements OnInit {

  constructor(private ws : WorkoutService, private wes : WorkoutExerciseService) { }
  currWorkout: Workout;
  interval;
  timeLeft: number = 5;
  setsAndReps : WorkoutExercise[];

  ngOnInit(): void {
    this.currWorkout= JSON.parse(sessionStorage.getItem(CURR_WORKOUT));
    console.log(this.currWorkout);
    this.ws.getWorkoutTime(this.currWorkout.id).subscribe(
      (response) => {
        this.timeLeft = response;
      }
    );
    this.wes.getJoinsByWorkout(this.currWorkout.id).subscribe(
      (response) => {
        this.setsAndReps = response;
        console.log(this.setsAndReps);
      }
    );
  }

  startTimer() {
    this.interval = setInterval(() => {
      if(this.timeLeft > 0) {
        this.timeLeft--;
      } else {
        //this.timeLeft = 60;
        clearInterval(this.interval);
      }
    },1000)
  }
  pauseTimer() {
    clearInterval(this.interval);
  }
  toHome(){
    window.location.href="/home";
  }

}
