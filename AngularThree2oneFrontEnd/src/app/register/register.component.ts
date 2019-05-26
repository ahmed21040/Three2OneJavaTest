import { Component, OnInit } from '@angular/core';
import {FormBuilder, Validators} from "@angular/forms";
import {DatafromServerService} from "../datafrom-server.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  userForm = this.formBuilder.group({
    'password': ['', Validators.required],
    'email': ['', [Validators.email]],
    'name': ['', Validators.required],
    'username': ['', Validators.required],
    'gender': ['male', Validators.required],

  });
  constructor(private formBuilder: FormBuilder, private dataFromServer: DatafromServerService,private  router:Router) { }

  ngOnInit() {
  }

  register() {
    if (this.userForm.dirty && this.userForm.valid) {
      console.log("gender >> ",this.userForm.value.gender)
      this.dataFromServer.register(this.userForm.value.name,this.userForm.value.email, this.userForm.value.password ,this.userForm.value.username,this.userForm.value.gender).subscribe(result =>{

        if(result=="OK"){
          this.dataFromServer.studentEmail=this.userForm.value.email;
          this.router.navigate(["home"])
        }else{
          alert(result)
        }
      })
    }
  }

}
