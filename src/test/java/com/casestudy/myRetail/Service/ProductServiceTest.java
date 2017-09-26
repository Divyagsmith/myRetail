package com.casestudy.myRetail.Service;

import com.casestudy.myRetail.model.Product;
import com.casestudy.myRetail.Exception.ProductNotFoundException;
import junit.framework.TestCase;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by z071476 on 9/24/17.
 */
public class ProductServiceTest extends TestCase {


    public void testGetProduct() {

    }

    @Test
    public void testParseReponse() {

        ProductService productService = new ProductService();
        String response = "{\"product\":{\"available_to_promise_network\":{\"product_id\":\"51265453\",\"id_type" +
                "\":\"TCIN\",\"available_to_promise_quantity\":0,\"street_date\":\"2016-09-15T05:00:00.000Z\"," +
                "\"availability\":\"UNAVAILABLE\",\"online_available_to_promise_quantity\":0," +
                "\"stores_available_to_promise_quantity\":0,\"availability_status\":\"DISCONTINUED\"," +
                "\"multichannel_options\":[\"HOLD\",\"SHIPSTORE\"],\"is_infinite_inventory\":false," +
                "\"loyalty_availability_status\":\"DISCONTINUED\",\"loyalty_purchase_start_date_time\":" +
                "\"1970-01-01T00:00:00.000Z\",\"is_loyalty_purchase_enabled\":false},\"item\":{\"tcin\":" +
                "\"51265453\",\"bundle_components\":{\"is_standard_item\":true},\"dpci\":\"207-33-0033\"," +
                "\"upc\":\"711719503965\",\"product_description\":" +
                "{\"title\":\"Uncharted 4 PlayStation 4 500GB Slim Bundle\"}}}}";
        try {


            Product product = productService.parseReponse(response);
            assertEquals("Uncharted 4 PlayStation 4 500GB Slim Bundle", product.getName());
            assertEquals(51265453, product.getId());

        } catch (Exception e) {

        }
    }

    @Test
    public void testParseReponseError() {

        ProductService productService = new ProductService();
        String response = "{\"product\":{\"item\":{}}}";
        try {
            productService.parseReponse(response);

        } catch (ProductNotFoundException | IOException e) {
            assertEquals(ProductNotFoundException.class, e.getClass());

        }
    }
}