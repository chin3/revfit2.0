import { User } from "./User";
import { Exercise } from "./Exercise";

export class Workout {
    id : number;
    user : User;
    exercises : Array<Exercise>;
    intensity : string;
    type : string;
    name : string;
}