import { Injectable } from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http'
import 'rxjs/add/operator/map'
import 'rxjs/add/operator/catch';
import {environment} from "../environments/environment";

@Injectable()
export class DatafromServerService {

  studentEmail;
  url = environment.url;
  constructor(private http: Http) {

  }

  login(email , password ){
    let formData=new FormData();
    formData.append("email",email)
    formData.append("password",password)

    return this.http.post(this.url+'/student/login', formData)
      .map((res:Response) => res.text());
  }

  register(name, email, password, username, gender) {

    let formData=new FormData();
    formData.append("email",email)
    formData.append("password",password)
    formData.append("studentname",name)
    formData.append("username",username)
    formData.append("gender",gender)

    return this.http.post(this.url+'/student/register', formData)
      .map((res:Response) => res.text());
  }

  getCourses(){

    return this.http.get(this.url+'/courses/getcourses')
      .map((res:Response) => res.json());
  }

  registerStudentIntoCourse( id ){
    let formData=new FormData();
    formData.append("email",this.studentEmail)
    formData.append("courseid",id)

    return this.http.post(this.url+'/courses/registerstudentintocourse', formData)
      .map((res:Response) => res.text());
  }

  getRegisteredCourses() {
    let formData=new FormData();
    formData.append("email",this.studentEmail)

    return this.http.post(this.url+'/courses/getregisterstudentcourse', formData)
      .map((res:Response) => res.json());
  }

  leaveCourse( id ){
    let formData=new FormData();
    formData.append("email",this.studentEmail)
    formData.append("courseid",id)

    return this.http.post(this.url+'/courses/unregisterstudentfromcourse', formData)
      .map((res:Response) => res.text());
  }
}
