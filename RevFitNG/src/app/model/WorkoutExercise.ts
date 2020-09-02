import { Workout } from "./Workout";
import { Exercise } from "./Exercise";
import { WorkoutExerciseId } from "./WorkoutExerciseId";

export class WorkoutExercise {
    id : WorkoutExerciseId;
    workout : Workout;
    exercise : Exercise;
    time : number;
    sets : number;
}