package com.frosters.controller;

import ch.qos.logback.core.net.server.Client;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.frosters.model.Customer;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.net.URLEncoder;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;




//TODO: Understand the integration of jacaco in Maven IntelliJ works good 
@SpringBootTest

@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CustomerControllerTest {


    private MockMvc mockMvc;


    @Autowired

    WebApplicationContext context;

    @Autowired

    private TestRestTemplate restTemplate;

    @Before

    public void setup() {

        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();

    }


    @Test
    public void testAretrievetest_okA() throws Exception {

        mockMvc.perform(get("/customer/")).andDo(print())

                .andExpect(status().isOk());



    }

    @Test
    public void testBgetAllCustomersServiceB() throws Exception {

        mockMvc.perform(get("/customer/")).andDo(print())

                .andExpect(status().isOk());


    }

    @Test
    public void testCgetSpecificCustomerServiceC() throws Exception {
        mockMvc.perform(get("/customer/1")).andDo(print())

                .andExpect(status().isOk());

    }

    @Test
    public void testDaddCustomerServiceD() throws  Exception{


            Customer c =
                    new Customer(10042,
                            "Sam",
                            704978031,
                            "Ohio",
                            "M");

        byte[] hospJson = toJson(c);

        mockMvc.perform(post("/customer/" )//.andDo(print())
                .content(hospJson)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());

    }



    @Test
    public void testEupdateExistingCustomerServiceE() throws  Exception{

        Customer c=new Customer();
        c.setCustomerId(1);
        c.setCustomerName("Peter");

        byte[] hospJson1 = toJson(c);
        mockMvc.perform(put("/customer/1" )//.andDo(print())
                .content(hospJson1)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        mockMvc.perform(get("/customer/1" )).andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.customerName").value("Peter"));

    }

    @Test
    public void testFdeleteSpecificCustomerF() throws Exception {


        mockMvc.perform(delete("/customer/1" ))
                .andExpect(status().isOk());

    }

    @Test
    public void testGdeleteAllCustomersService() throws  Exception {
        mockMvc.perform(delete("/customer/" ))
                .andExpect(status().isOk());


    }

    private byte[] toJson(Object r) throws Exception {
        ObjectMapper map = new ObjectMapper();
        return map.writeValueAsString(r).getBytes();
    }
}