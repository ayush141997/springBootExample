package com.springboot.hellospring;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DemoApplication.class)
@WebAppConfiguration
public abstract class AbstractTest{
    protected MockMvc mvc;
    @Autowired
    WebApplicationContext webAppContext;

    protected void setUp() {
        mvc = MockMvcBuilders.webAppContextSetup(webAppContext).build();
    }

    protected String mapToJson(Object obj) throws JsonProcessingException{
        ObjectMapper objMapper = new ObjectMapper();
        return objMapper.writeValueAsString(obj);
    }

    protected <T> T mapFromJson(String json,Class<T> clazz) throws Exception {
        ObjectMapper objMapper = new ObjectMapper();
        return objMapper.readValue(json, clazz);
    }
}