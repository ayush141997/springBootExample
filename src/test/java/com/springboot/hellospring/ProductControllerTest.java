package com.springboot.hellospring;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.springboot.hellospring.dao.product;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

public class ProductControllerTest extends AbstractTest{
    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

    @Test
   public void getProductsList() throws Exception {
      String uri = "/product";
      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
         .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
      
      int status = mvcResult.getResponse().getStatus();
      assertEquals(status, 200);
      String content = mvcResult.getResponse().getContentAsString();
      product[] productlist = super.mapFromJson(content, product[].class);
      assertTrue(productlist.length > 0);
   }
   @Test
   public void createProduct() throws Exception {
      String uri = "/product";
      product product = new product("ProdX","TypeX");
      String inputJson = super.mapToJson(product);
      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
         .contentType(MediaType.APPLICATION_JSON_VALUE)
         .content(inputJson)).andReturn();
      
      int status = mvcResult.getResponse().getStatus();
      assertEquals(status, 200);
      String content = mvcResult.getResponse().getContentAsString();
      assertEquals(content, "Created");
   }
   @Test
   public void checkInputNullForProductCreation() throws Exception {
      String uri = "/product";
      product product = new product(null,"typex");
      String inputJson = super.mapToJson(product);
      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
         .contentType(MediaType.APPLICATION_JSON_VALUE)
         .content(inputJson)).andReturn();
      
      int status = mvcResult.getResponse().getStatus();
      assertEquals(status, 406);
      String content = mvcResult.getResponse().getContentAsString();
      assertEquals(content, "Either of the inputs are null");
   }
   @Test
   public void checkInputConstraintForProductCreation() throws Exception {
      String uri = "/product";
      product product = new product("ProdX","TypeX");
      String inputJson = super.mapToJson(product);
      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
         .contentType(MediaType.APPLICATION_JSON_VALUE)
         .content(inputJson)).andReturn();
      
      int status = mvcResult.getResponse().getStatus();
      assertEquals(status, 409);
      String content = mvcResult.getResponse().getContentAsString();
      assertEquals(content, "Constraint Violation");
   }
}