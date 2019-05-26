package com.three2one.springbootthree2onetest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.three2one.springbootthree2onetest.dao.CoursesDoa;
import com.three2one.springbootthree2onetest.dao.StudentDao;
import com.three2one.springbootthree2onetest.model.Courses;
import com.three2one.springbootthree2onetest.model.Student;

@Service
public class CoursesService {

	@Autowired
	private CoursesDoa coursesDoa;

	@Autowired
	private StudentDao studentDao;
	public List<Courses> allCourses() {
		return coursesDoa.allCourses();
	}

	public List<Courses> registerStudentCourses(String email) {
		Student student=studentDao.findStudent(email);
		
		return coursesDoa.registerStudentCourses(student.getId());
	}

	public String registerStudentIntoCourse(Long courseid, String email) {
		Student student=studentDao.findStudent(email);
		boolean res = coursesDoa.registerStudentIntoCourse(courseid, student);

		if (res) {
			return "OK";
		} else {
			return "not added";
		}
	}
	
	public String unregisterStudentFromCourse(Long courseid, String email) {
		Student student=studentDao.findStudent(email);
		boolean res = coursesDoa.unregisterStudentFromCourse(courseid, student);
		
		if (res) {
			return "OK";
		} else {
			return "not removed";
		}
	}
}
