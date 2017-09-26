package com.casestudy.myRetail;

import com.casestudy.myRetail.Service.PriceService;
import com.casestudy.myRetail.Service.ProductService;
import com.casestudy.myRetail.Controller.ProductController;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by z071476 on 9/24/17.
 */

public class ProductControllerTest {

    private MockMvc mockMvc;

    @Mock
    private ProductService productService;
    @Mock
    private PriceService priceService;

    @InjectMocks
    private ProductController productController;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks((this));
        mockMvc = MockMvcBuilders.standaloneSetup(productController).build();

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