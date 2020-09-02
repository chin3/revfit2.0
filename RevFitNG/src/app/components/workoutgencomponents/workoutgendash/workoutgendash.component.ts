import { Component, OnInit } from '@angular/core';
import { WorkoutService } from 'src/app/services/workout.service';
import { Workout } from 'src/app/model/Workout';
import {NgbModal, ModalDismissReasons} from '@ng-bootstrap/ng-bootstrap';
import { Exercise } from 'src/app/model/Exercise';
import { WorkoutExercise } from 'src/app/model/WorkoutExercise';

@Component({
  selector: 'app-workoutgendash',
  templateUrl: './workoutgendash.component.html',
  styleUrls: ['./workoutgendash.component.css']
})
export class WorkoutgendashComponent implements OnInit {

  closeResult: string;
  constructor(private modalService: NgbModal, private workoutService: WorkoutService) { }

  exercises : Exercise[]
  reps : WorkoutExercise[]
  times : WorkoutExercise
  new_workout : Workout
  new_exercise : Exercise
  selected : string = "Beginner"
  amountOfCards : number = 1
  
  counter(i: number) {
    return new Array(i);
  }

  addCard() {
    this.exercises.push(this.new_exercise);
    console.log(this.exercises);
    console.log()
    this.new_exercise = new Exercise();
    console.log(this.exercises.length);
    this.amountOfCards += 1;
    console.log(this.amountOfCards);
  }

  ngOnInit(): void {
    this.new_workout = new Workout();
    this.new_exercise = new Exercise();
    this.exercises = new Array<Exercise>();
    this.exercises.push(this.new_exercise);
    this.new_exercise = new Exercise();
    console.log(this.amountOfCards);
    this.reps = new Array<WorkoutExercise>();
    this.new_workout.user = JSON.parse(window.sessionStorage.getItem("USER"));
  }

  open(content) {
    this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title'}).result.then((result) => {
      this.closeResult = `Closed with: ${result}`;
    }, (reason) => {
      this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
    });
  }

  private getDismissReason(reason: any): string {
    if (reason === ModalDismissReasons.ESC) {
      return 'by pressing ESC';
    } else if (reason === ModalDismissReasons.BACKDROP_CLICK) {
      return 'by clicking on a backdrop';
    } else {
      return  `with: ${reason}`;
    }
  }

  newExercise() {
    this.exercises.push(this.new_exercise);
    
    this.new_exercise = new Exercise();
  }

  addWorkout() {
    console.log(this.new_workout);
    this.new_workout.intensity = this.selected
    this.new_workout.exercises = this.exercises
    console.log(this.exercises);
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