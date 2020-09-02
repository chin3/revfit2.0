import { Component, OnInit } from '@angular/core';
import { Workout } from 'src/app/model/Workout';
const CURR_WORKOUT = "CURR";
@Component({
  selector: 'app-workouttimer',
  templateUrl: './workouttimer.component.html',
  styleUrls: ['./workouttimer.component.css']
})
export class WorkouttimerComponent implements OnInit {

  constructor() { }
  currWorkout: Workout;
  interval;
  timeLeft: number = 5;

  ngOnInit(): void {
    this.currWorkout= JSON.parse(sessionStorage.getItem(CURR_WORKOUT));
    console.log(this.currWorkout);
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
