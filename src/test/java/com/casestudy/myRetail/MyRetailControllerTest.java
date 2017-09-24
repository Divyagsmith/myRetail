package com.casestudy.myRetail;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

/**
 * Created by z071476 on 9/24/17.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(value = MyRetailController.class, secure = false)
@WebAppConfiguration
public class MyRetailControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setUp() throws Exception {
        this.mockMvc = webAppContextSetup(webApplicationContext).build();

    }

    @Test
    public void testValidProductRequest() throws Exception {
        mockMvc.perform(get("/product/16696652")).andDo(print()).andExpect(status().isOk());

    }

    @Test
    public void testErrorProductRequest() throws Exception {
        mockMvc.perform(get("/product/16696652w")).andDo(print()).andExpect(status().is(400));

    }

}