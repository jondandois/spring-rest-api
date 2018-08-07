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

public class FindCustomerByIdTest extends SpringDataDynamoDbApplicationTests {

  @Autowired
  private WebApplicationContext webApplicationContext;

  private MockMvc mockMvc;

  @Before
  public void setup() {
    mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
  }

  @Test
  public void validate_findCustomerById_status() throws Exception {
    mockMvc.perform(get("/findbyid?id=1"))
      .andExpect(status().isOk());
  }
  @Test
  public void validate_findCustomerById_header() throws Exception {
    mockMvc.perform(get("/findbyid?id=1"))
      .andExpect(content().contentType("application/json;charset=UTF-8"));
  }
  @Test
  public void validate_findCustomerById_content() throws Exception {
    mockMvc.perform(get("/findbyid?id=1"))
      .andExpect(jsonPath("$.firstName").value("Jack"));
  }
}
