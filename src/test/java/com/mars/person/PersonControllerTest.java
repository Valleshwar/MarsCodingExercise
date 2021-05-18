package com.mars.person;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.mars.person.controller.PersonController;
import com.mars.person.entity.Person;
import com.mars.person.service.PersonService;

@WebMvcTest(controllers = {PersonController.class})
@ImportAutoConfiguration
public class PersonControllerTest extends AbstractTest {
	
	   @Override
	   @Before
	   public void setUp() {
	      super.setUp();
	   }
		
		@MockBean
		PersonService service;
		
	   @Test
	   public void getProductsList() throws Exception {
	      String uri = "/mars/getPersons";
	      List<Person> personList = new ArrayList<Person>();
	      Person person = new Person();
	      person.setFirstName("Vallesh");
	      personList.add(person);
	      when(service.getPersons()).thenReturn(personList);
	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
	         .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
	      
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(200, status);
	      String content = mvcResult.getResponse().getContentAsString();
	      Person[] list = super.mapFromJson(content, Person[].class);
	      assertTrue(list.length > 0);
	   }
	
	

}
