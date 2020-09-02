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

  constructor(private ws: WorkoutService, private wes: WorkoutExerciseService) { }
  currWorkout: Workout;
  interval;
  curExerciseIndex: number = 0;
  curExerciseInitTime : number;
  timeLeft: number;
  done : boolean = false;
  setsAndReps: WorkoutExercise[];

  ngOnInit(): void {
    this.currWorkout = JSON.parse(sessionStorage.getItem(CURR_WORKOUT));
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
    this.curExerciseInitTime = this.setsAndReps[this.curExerciseIndex].time;
    console.log(this.curExerciseInitTime);
    this.interval = setInterval(() => {
      if (this.timeLeft >= 0) {
        this.exerciseTimer();
        this.timeLeft--;

      } else {
        clearInterval(this.interval);
        this.done = true;
      }
    }, 1000)
  }
  pauseTimer() {
    clearInterval(this.interval);
  }
  toHome() {
    window.location.href = "/home";
  }

  exerciseTimer() {
    if (this.setsAndReps[this.curExerciseIndex].time > 1) {
      this.setsAndReps[this.curExerciseIndex].time--;
    }
    else if (this.setsAndReps[this.curExerciseIndex].sets > 1) {
      this.setsAndReps[this.curExerciseIndex].sets--;
      this.setsAndReps[this.curExerciseIndex].time = this.curExerciseInitTime;
    }
    else if (this.curExerciseIndex < this.currWorkout.exercises.length) {
      this.setsAndReps[this.curExerciseIndex].time--;
      this.setsAndReps[this.curExerciseIndex].sets--;
      this.curExerciseIndex++;
      this.curExerciseInitTime = this.setsAndReps[this.curExerciseIndex].time;
    }

  }

}
