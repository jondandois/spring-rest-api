package com.javasampleapproach.dynamodb;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

public class FindCustomersByFirstNameTest extends SpringDataDynamoDbApplicationTests {

  @Autowired
  private WebApplicationContext webApplicationContext;

  private MockMvc mockMvc;

  @Before
  public void setup() {
    mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
  }

  @Test
  public void validate_findCustomersByFirstName_status() throws Exception {
    mockMvc.perform(get("/findbyfirstname?firstname=Jack"))
      .andExpect(status().isOk());
  }
  @Test
  public void validate_findCustomersByFirstName_header() throws Exception {
    mockMvc.perform(get("/findbyfirstname?firstname=Jack"))
      .andExpect(content().contentType("application/json;charset=UTF-8"));
  }
  @Test
  public void validate_findCustomersByFirstName_content() throws Exception {
    mockMvc.perform(get("/findbyfirstname?firstname=Jack"))
      .andExpect(jsonPath("$[0].firstName").value("Jack"));
  }
}
