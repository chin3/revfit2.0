import { Component, OnInit } from '@angular/core';
import { Workout } from 'src/app/model/Workout';
import { WorkoutExercise } from 'src/app/model/WorkoutExercise';
import { WorkoutService } from 'src/app/services/workout.service';
import { WorkoutExerciseService } from 'src/app/services/workout-exercise.service';
import { Exercise } from 'src/app/model/Exercise';

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
  initTime: number[] = new Array<number>();
  curExerciseInitTime: number;
  timeLeft: number;
  done: boolean = false;
  setsAndReps: WorkoutExercise[] = new Array<WorkoutExercise>();

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
        for (let t of this.setsAndReps) {
          this.initTime.push(t.time);
        }
      }
    );

  }

  startTimer() {
    this.curExerciseInitTime = this.setsAndReps[this.curExerciseIndex].time;
    console.log(this.curExerciseInitTime);
    this.interval = setInterval(() => {
      if (this.timeLeft > 0) {
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
    let i = 0;
    while (this.setsAndReps[this.curExerciseIndex].sets == 0) {
      if (i==this.setsAndReps.length){
        break;
      }

      if(this.curExerciseIndex == this.setsAndReps.length - 1){
        this.curExerciseIndex = 0;
      }else{
        this.curExerciseIndex++;
      }
      i++;

    }

      if (this.setsAndReps[this.curExerciseIndex].time > 1) {
        this.setsAndReps[this.curExerciseIndex].time--;
      }
      else if (this.setsAndReps[this.curExerciseIndex].sets > 0) {

        if (this.setsAndReps[this.curExerciseIndex].sets == 1) {
          this.initTime[this.curExerciseIndex] = 0;
          this.setsAndReps[this.curExerciseIndex].time = 0;
        } else {
          this.setsAndReps[this.curExerciseIndex].time = this.initTime[this.curExerciseIndex];
        }

        this.setsAndReps[this.curExerciseIndex].sets--;



        console.log("Sets and Reps Length:" + this.setsAndReps.length);
        console.log("Current Index:" + this.curExerciseIndex);

        if (this.curExerciseIndex == (this.setsAndReps.length - 1)) {
          this.curExerciseIndex = 0;
          console.log("Going back")
        } else {
          this.curExerciseIndex++;
        }

      }
    // else if (this.curExerciseIndex < this.currWorkout.exercises.length) {
    //   this.setsAndReps[this.curExerciseIndex].time--;
    //   this.setsAndReps[this.curExerciseIndex].sets--;
    //   this.curExerciseIndex++;
    //   this.curExerciseInitTime = this.setsAndReps[this.curExerciseIndex].time;
    // }

  }

}
