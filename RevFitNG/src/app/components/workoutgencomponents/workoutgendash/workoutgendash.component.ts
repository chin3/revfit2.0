import { Component, OnInit } from '@angular/core';
import { WorkoutService } from 'src/app/services/workout.service';
import { Workout } from 'src/app/model/Workout';
import {NgbModal, ModalDismissReasons} from '@ng-bootstrap/ng-bootstrap';
import { Exercise } from 'src/app/model/Exercise';
import { WorkoutExercise } from 'src/app/model/WorkoutExercise';
import { WorkoutExerciseService } from 'src/app/services/workout-exercise.service';
import { ExerciseService } from 'src/app/services/exercise.service';

//NOTE: gotta make sure the exercise fields aren't empty before adding another card
@Component({
  selector: 'app-workoutgendash',
  templateUrl: './workoutgendash.component.html',
  styleUrls: ['./workoutgendash.component.css']
})
export class WorkoutgendashComponent implements OnInit {

  closeResult: string;
  constructor(private modalService: NgbModal, private workoutService: WorkoutService, private wes : WorkoutExerciseService, private es : ExerciseService) { }

  dropdown : Exercise[];
  exercises : Exercise[];
  repsAndTimes : WorkoutExercise[];
  new_workout : Workout;
  selected : string = "Beginner";
  amountOfCards : number = 1;

  ngOnInit(): void {

    this.es.getAllExercises().subscribe(
      (response) => {
        this.dropdown = response;
        console.log(this.dropdown);
      }
    );
    this.new_workout = new Workout();
    this.exercises = new Array<Exercise>();
    this.exercises.push(new Exercise());
    this.repsAndTimes = new Array<WorkoutExercise>();
    this.repsAndTimes.push(new WorkoutExercise());
    this.new_workout.user = JSON.parse(window.sessionStorage.getItem("USER"));
  }

  counter(i: number) {
    return new Array(i);
  }

  addCard() {
    if(this.exercises[this.amountOfCards-1].name == undefined || this.exercises[this.amountOfCards-1].muscleGroup == undefined || this.repsAndTimes[this.amountOfCards-1].sets == undefined || this.repsAndTimes[this.amountOfCards-1].time == undefined) {
      alert("Please fill in the current exercise's information before adding more");
      return;
    }
    this.exercises.push(new Exercise());  
    this.repsAndTimes.push(new WorkoutExercise);
    console.log(this.exercises)
    this.repsAndTimes[this.amountOfCards-1].workout = this.new_workout;
    this.repsAndTimes[this.amountOfCards-1].exercise = this.exercises[this.amountOfCards-1];
    this.amountOfCards += 1;
    console.log(this.repsAndTimes);
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

  addWorkout() {
    if(this.exercises[this.amountOfCards-1].name == undefined || this.exercises[this.amountOfCards-1].muscleGroup == undefined || this.repsAndTimes[this.amountOfCards-1].sets == undefined || this.repsAndTimes[this.amountOfCards-1].time == undefined) {
      alert("Please fill in the current exercise's information before submitting");
      return;
    }
    this.new_workout.intensity = this.selected
    this.new_workout.exercises = this.exercises

    console.log(JSON.stringify(this.new_workout));
    this.workoutService.addWorkout(this.new_workout).subscribe(
      (response) => {

        this.wes.getJoinsByWorkout(response.id).subscribe(
          (response) => {
            for(let i=0; i<response.length; i++) {
              response[i].sets = this.repsAndTimes[i].sets;
              response[i].time = this.repsAndTimes[i].time;
              
              this.wes.updateWorkoutExercise(response[i]).subscribe(
                (response) => {
                  console.log(response);
                },
                (response) => {
                  console.log("Can you not?");
                }
              );
            }
          }
        );
        console.log(response)

      },
      (response)=>{
        console.log("failed")
      },
      ()=>{ 
        console.log("finally")
      } );
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