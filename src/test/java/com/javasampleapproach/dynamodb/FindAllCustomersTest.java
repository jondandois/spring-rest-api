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

public class FindAllCustomersTest extends SpringDataDynamoDbApplicationTests {

  @Autowired
  private WebApplicationContext webApplicationContext;

  private MockMvc mockMvc;

  @Before
  public void setup() {
    mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
  }

  @Test
  public void validate_findAllCustomers_status() throws Exception {
    mockMvc.perform(get("/customer")).andExpect(status().isOk());
    // .andExpect(jsonPath("$.name").value("John")).andExpect(jsonPath("$.location").value("US"));
  }
  @Test
  public void validate_findAllCustomers_header() throws Exception {
    mockMvc.perform(get("/customer")).andExpect(content().contentType("application/json;charset=UTF-8"));
  }
}
