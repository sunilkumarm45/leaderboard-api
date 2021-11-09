/*
package com.sinch.board.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;


@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@EnableTransactionManagement
@Transactional()
@Rollback
public class PlayerControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webContext;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webContext).build();
    }

    protected <T> T mapFromJson(String json, Class<T> clazz) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.readValue(json, clazz);
    }

    protected String mapToJson(Object obj) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(obj);
    }

    @Test
    public void getAllRecords_success() throws Exception {
        HttpHeaders headers = new HttpHeaders();

        MvcResult mvcResult
                 = mockMvc
                 .perform(
                         MockMvcRequestBuilders
                                 .get("/api/players")
                                 .headers(headers))
                 .andReturn();
         System.out.println("mvcResult get All players= " + mvcResult.getResponse().getContentAsString());
     }

    @Test
    public void getPlayerRecordByName() throws Exception {
        HttpHeaders headers = new HttpHeaders();

        MvcResult mvcResult
                = mockMvc
                .perform(
                        MockMvcRequestBuilders
                                .get("/api/player?name=lynx titan")
                                .headers(headers))
                .andReturn();
        System.out.println("mvcResult get lynx titan details = " + mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void getPlayersByCategory() throws Exception {
        HttpHeaders headers = new HttpHeaders();

        MvcResult mvcResult
                = mockMvc
                .perform(
                        MockMvcRequestBuilders
                                .get("/api/players?category=attack")
                                .headers(headers))
                .andReturn();
        System.out.println("mvcResult get attack category data = " + mvcResult.getResponse().getContentAsString());
    }
}

*/
