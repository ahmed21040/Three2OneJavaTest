import { Component, OnInit } from '@angular/core';
import {DatafromServerService} from "../datafrom-server.service";
import {Router} from "@angular/router";
import {isNullOrUndefined} from "util";

@Component({
  selector: 'app-register-into-course',
  templateUrl: './register-into-course.component.html',
  styleUrls: ['./register-into-course.component.css']
})
export class RegisterIntoCourseComponent implements OnInit {

  constructor(private dataFromServer: DatafromServerService,private router: Router ) { }

  allCourses=[];
  ngOnInit() {
    if(isNullOrUndefined(this.dataFromServer.studentEmail)){
      this.router.navigate(["login"])
    }else {
      this.dataFromServer.getRegisteredCourses().subscribe(result => {
        console.log(result);
        this.allCourses = result;
      })
    }
  }

  leaveCourse(id, ind) {
    this.dataFromServer.leaveCourse(id).subscribe(result=>{
      console.log(result);
      if(result=="OK"){
        this.allCourses.splice(ind,1);
        alert("leaved successfully")
      }else{
        alert(result);
      }
    })
  }
}
