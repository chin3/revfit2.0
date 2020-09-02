import { Component, OnInit } from '@angular/core';
import {Workout} from 'src/app/model/Workout';
import { User } from 'src/app/model/User';
import {WorkoutService} from 'src/app/services/workout.service';
import { setClassMetadata } from '@angular/core/src/r3_symbols';

const STORAGE_KEY = 'USER';
const CURR_WORKOUT = 'CURR';
@Component({
  selector: 'app-workoutdash',
  templateUrl: './workoutdash.component.html',
  styleUrls: ['./workoutdash.component.css']
})
export class WorkoutdashComponent implements OnInit {
  ngOnInit(): void {
    this.user= JSON.parse(sessionStorage.getItem(STORAGE_KEY));
    console.log(this.user);
    this.getUserWorkouts(this.user);
    
  }

  constructor(private workoutService: WorkoutService){

  }
  userWorkouts: Workout[];
  user : User;
  selected : string = "Not Selected";
  currWorkout: Workout;

  selectWorkout(workout){
    console.log(workout);
    this.selected = workout.name;
    this.currWorkout=workout;
    // this.updateCurrStorage(workout);
    //
    // let check = JSON.parse(sessionStorage.getItem(CURR_WORKOUT));
    // console.log("Current WORKOUT IS" + check.name);
    
    

  }

  startWorkout(){
    if(this.currWorkout){
      this.updateCurrStorage(this.currWorkout);
      console.log("Adding currentWorkout to session Storage");
      console.log(sessionStorage.getItem(CURR_WORKOUT));
      window.location.href="/timer";
    }else{
      alert("Workout not selected, please select a workout");
    }
    
  }

  updateCurrStorage(workout){
    sessionStorage.setItem(CURR_WORKOUT,JSON.stringify(workout));
  }

  getUserWorkouts(u:User){
    this.workoutService.getUserWorkouts(u).subscribe(
      (response)=>{ 
        this.userWorkouts = response;
        console.log(this.userWorkouts);
      },
      (response)=>{console.log('failed');},
      ()=>{
        console.log('Woop');
      }
    
      );
    
  }





}
