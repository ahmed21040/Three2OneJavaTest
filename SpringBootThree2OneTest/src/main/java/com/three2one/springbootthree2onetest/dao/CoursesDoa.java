package com.three2one.springbootthree2onetest.dao;

import java.util.List;

import com.three2one.springbootthree2onetest.model.Courses;
import com.three2one.springbootthree2onetest.model.Student;

public interface CoursesDoa {

	
	public List<Courses> allCourses();
	
	public List<Courses> registerStudentCourses(Long studentId);
	
	public boolean registerStudentIntoCourse(Long courseid, Student student);
	
	public boolean unregisterStudentFromCourse(Long courseid, Student student);
	
	public void addCourse(Courses course);
}
