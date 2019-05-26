package com.three2one.springbootthree2onetest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.three2one.springbootthree2onetest.model.Courses;
import com.three2one.springbootthree2onetest.service.CoursesService;

@RestController
@RequestMapping("courses")
public class CoursesController {
	
	@Autowired
	private CoursesService coursesService;
	
	@CrossOrigin
	@RequestMapping(value = "/getcourses", method = RequestMethod.GET)
	public List<Courses> getCorses(){
		return coursesService.allCourses();
	}
	
	@CrossOrigin
	@RequestMapping(value = "/getregisterstudentcourse", method = RequestMethod.POST)
	public List<Courses> getRegisterStudentCourse(@RequestParam(value = "email") String email){
		
		return coursesService.registerStudentCourses(email);
	}

	@CrossOrigin
	@RequestMapping(value = "/registerstudentintocourse", method = RequestMethod.POST)
	public String registerStudentIntoCourse(@RequestParam(value = "email") String email,@RequestParam(value = "courseid") Long courseid){
		return coursesService.registerStudentIntoCourse(courseid, email);	
	}
	
	@CrossOrigin
	@RequestMapping(value = "/unregisterstudentfromcourse", method = RequestMethod.POST)
	public String unregisterStudentfromCourse(@RequestParam(value = "email") String email,@RequestParam(value = "courseid") Long courseid){
		return coursesService.unregisterStudentFromCourse(courseid, email);	
	}
}
