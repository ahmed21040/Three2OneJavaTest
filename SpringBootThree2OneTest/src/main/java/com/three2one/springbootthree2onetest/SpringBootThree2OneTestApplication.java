package com.three2one.springbootthree2onetest;

import java.util.Date;
import java.util.Properties;

import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

import com.three2one.springbootthree2onetest.dao.CoursesDoa;
import com.three2one.springbootthree2onetest.model.Courses;

@SpringBootApplication
@ComponentScan({ "com.three2one.springbootthree2onetest" })
public class SpringBootThree2OneTestApplication implements CommandLineRunner {

	
	@Autowired 
	private CoursesDoa coursesDoa;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootThree2OneTestApplication.class, args);
	}
	
	@Override
    public void run(String... args) {
		Courses courses =new Courses();
		courses.setCourseName("Security");
		courses.setDescription("security Course");
		courses.setInstractor("ahmed");
		courses.setLastUpdate(new Date());
		courses.setPublishDate(new Date());
		courses.setTotalHour((long) 50);
		coursesDoa.addCourse(courses);
		
		
		Courses courses2 =new Courses();
		courses2.setCourseName("IT");
		courses2.setDescription("security IT");
		courses2.setInstractor("ahmed");
		courses2.setLastUpdate(new Date());
		courses2.setPublishDate(new Date());
		courses2.setTotalHour((long) 50);
		coursesDoa.addCourse(courses2);
		
	}

	@Bean
	public CommonsRequestLoggingFilter requestLoggingFilter() {
	    CommonsRequestLoggingFilter loggingFilter = new CommonsRequestLoggingFilter();
	    loggingFilter.setIncludeClientInfo(true);
	    loggingFilter.setIncludeQueryString(true);
	    loggingFilter.setIncludePayload(true);
	    loggingFilter.setIncludeHeaders(false);
	    return loggingFilter;
	}
}
