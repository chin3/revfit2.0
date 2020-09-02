import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { ModalModule } from 'ngx-bootstrap/modal';
import { AppRoutingModule } from './app-routing.module';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { LoginregisterComponent } from './components/loginregister/loginregister.component';
import { WorkoutsComponent } from './components/workouts/workouts.component';
import { HomeComponent } from './components/home/home.component';
import { HomedashComponent } from './components/dashboardcomponents/homedash/homedash.component';
import { LeftcardComponent } from './components/dashboardcomponents/leftcard/leftcard.component';
import { RightcardComponent } from './components/dashboardcomponents/rightcard/rightcard.component';
import { WorkoutgendashComponent } from './components/workoutgencomponents/workoutgendash/workoutgendash.component';
import { LeftgendashComponent } from './components/workoutgencomponents/leftgendash/leftgendash.component';
import { WorkoutdashComponent } from './components/workoutcomponents/workoutdash/workoutdash.component';
import { WorkoutleftComponent } from './components/workoutcomponents/workoutleft/workoutleft.component';
import {WorkouttimerComponent} from './components/workoutcomponents/workouttimer/workouttimer.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginregisterComponent,
    WorkoutsComponent,
    HomeComponent,
    HomedashComponent,
    LeftcardComponent,
    RightcardComponent,
    WorkoutgendashComponent,
    LeftgendashComponent,
    WorkoutdashComponent,
    WorkoutleftComponent,
    WorkouttimerComponent
  ],
  imports: [
    ModalModule,
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    FormsModule,
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
