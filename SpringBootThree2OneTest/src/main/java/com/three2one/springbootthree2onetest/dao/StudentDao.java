package com.three2one.springbootthree2onetest.dao;

import com.three2one.springbootthree2onetest.model.Student;

public interface StudentDao {
	
	public boolean addStudent(Student student);
	public boolean checkStudent(String email ,String password);
	public Student findStudent(String email);

}
