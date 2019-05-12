package com.wissensalt.test.sar;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wissensalt.test.sar.dto.RequestRegistrationDTO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class SpringAngularRegistrationApplicationTests {

	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;

	private ObjectMapper mapper = new ObjectMapper();

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	@Rollback(true)
	public void testRegisterUser() throws Exception {
		RequestRegistrationDTO requestRegistrationDTO = new RequestRegistrationDTO();
		requestRegistrationDTO.setMobileNumber("081294533212");
		requestRegistrationDTO.setFirstName("David");
		requestRegistrationDTO.setLastName("Guetta");
		requestRegistrationDTO.setGender(1);
		requestRegistrationDTO.setDob("12-12-1990");
		requestRegistrationDTO.setEmail("guetta@gmail.com");

		String inputJson = mapper.writeValueAsString(requestRegistrationDTO);
		mockMvc.perform(
				MockMvcRequestBuilders
						.post("/registration/register")
						.contentType(MediaType.APPLICATION_JSON)
						.accept(MediaType.APPLICATION_JSON)
						.content(inputJson))
				.andExpect(status().isOk());
	}

}
