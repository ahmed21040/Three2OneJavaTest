import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { HttpModule  } from '@angular/http';
import {DatafromServerService} from "./datafrom-server.service";
import {RouterModule, Routes} from "@angular/router";
import { HomeComponent } from './home/home.component';
import { RegisterComponent } from './register/register.component';
import { RegisterIntoCourseComponent } from './register-into-course/register-into-course.component';

const appRoutes : Routes =[

  {
    path:'login',
    component:LoginComponent
  },
  {
    path:'',
    component:LoginComponent
  }
  ,
  {
    path:'home',
    component:HomeComponent
  },
  {
    path:'register',
    component:RegisterComponent
  },
  {
    path:'registeredcourse',
    component:RegisterIntoCourseComponent
  }

]
@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomeComponent,
    RegisterComponent,
    RegisterIntoCourseComponent
  ],
  imports: [
    BrowserModule,
    ReactiveFormsModule,HttpModule,
    RouterModule.forRoot(appRoutes, { useHash: true })
  ],
  providers: [DatafromServerService],
  bootstrap: [AppComponent]
})
export class AppModule { }
