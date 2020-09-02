import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-workouttimer',
  templateUrl: './workouttimer.component.html',
  styleUrls: ['./workouttimer.component.css']
})
export class WorkouttimerComponent implements OnInit {

  constructor() { }
  interval;
  timeLeft: number = 60;

  ngOnInit(): void {
  }


  startTimer() {
    this.interval = setInterval(() => {
      if(this.timeLeft > 0) {
        this.timeLeft--;
      } else {
        this.timeLeft = 60;
      }
    },1000)
  }
  pauseTimer() {
    clearInterval(this.interval);
  }

}
