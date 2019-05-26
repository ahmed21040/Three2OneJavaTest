package com.three2one.springbootthree2onetest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.three2one.springbootthree2onetest.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@CrossOrigin
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(@RequestParam(value = "studentname") String name, @RequestParam(value = "email") String email,
			@RequestParam(value = "username") String username, @RequestParam(value = "password") String password,
			@RequestParam(value = "gender") String gender) {
		return studentService.registerStudent(name, email, password, username, gender);
	}

	@CrossOrigin
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam(value = "email") String email, @RequestParam(value = "password") String password) {

		return studentService.loginStudent(email, password);
	}
}
