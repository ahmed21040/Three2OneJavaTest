import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import {DatafromServerService} from "../datafrom-server.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  userForm = this.formBuilder.group({
    'password': ['', Validators.required],
    'email': ['', [Validators.email]],

  });
  constructor(private formBuilder: FormBuilder, private dataFromServer: DatafromServerService,private  router:Router) { }



  ngOnInit() {
  }

  login() {
    if (this.userForm.dirty && this.userForm.valid) {
      this.dataFromServer.login(this.userForm.value.email, this.userForm.value.password ).subscribe(result =>{

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
