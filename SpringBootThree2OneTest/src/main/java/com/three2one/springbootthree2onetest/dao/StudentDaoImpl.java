package com.three2one.springbootthree2onetest.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import com.three2one.springbootthree2onetest.model.Student;

@Repository
@Transactional
public class StudentDaoImpl implements StudentDao{

	
	@PersistenceContext
	private EntityManager em;

	@Override
	public boolean addStudent(Student student) {
		Student curStudent= em.merge(student);
		
		if(curStudent!=null){
			return true;
		}else{
			return false;
		}
		
	}

	@Override
	public boolean checkStudent(String email, String password) {
		
		String hql="from Student where email=:email and password=:password";
		List<Student> students=em.createQuery(hql, Student.class).setParameter("email", email).setParameter("password", password).getResultList();
		
		if(!students.isEmpty()){
			return true;
		}else{
			return false;
		}
		
	}

	@Override
	public Student findStudent(String email) {
		String hql="from Student where email=:email ";
		List<Student> students=em.createQuery(hql, Student.class).setParameter("email", email).getResultList();
		
		if(!students.isEmpty()){
			return students.get(0);
		}else{
			return null;
		}
		
	}

}
