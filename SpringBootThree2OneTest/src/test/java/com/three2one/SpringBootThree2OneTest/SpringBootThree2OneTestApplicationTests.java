package com.three2one.SpringBootThree2OneTest;



import javax.net.ssl.SSLEngineResult.Status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.three2one.springbootthree2onetest.service.CoursesService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SpringBootThree2OneTestApplicationTests {

	@Autowired
	private CoursesService coursesService;
	@Autowired
	private MockMvc mvc;

	@Test
	public void contextLoads() throws Exception {
		
		System.err.println("hereeeeeeeee");
		mvc.perform( MockMvcRequestBuilders
			      .get("/courses/getcourses")
			      .accept(MediaType.APPLICATION_JSON))
			      .andExpect(MockMvcResultMatchers.jsonPath("$[*].courseName").isNotEmpty());
	}

}
