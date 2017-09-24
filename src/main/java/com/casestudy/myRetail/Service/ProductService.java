package com.casestudy.myRetail.Service;

import com.casestudy.myRetail.model.Product;
import com.casestudy.myRetail.util.ProductNotFoundException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

/**
 * Created by z071476 on 9/23/17.
 * ProductService rest service to perform a get by ProductID and returns price and description if available.
 */
@Service
public class ProductService {

    public Product getProduct(Long productId) throws ProductNotFoundException, IOException {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(
                "http://redsky.target.com/v2/pdp/tcin/" + productId + "?excludes=taxonomy,price,promotion,bulk_ship,rating_and_review_reviews,rating_and_review_statistics,question_answer_statistics",
                String.class);

        return parseReponse(response.getBody());
    }

    Product parseReponse(String responseBody) throws IOException,
            ProductNotFoundException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(responseBody);
        JsonNode name = root.path("product");
        JsonNode productID = name.path("available_to_promise_network");
        JsonNode desc = name.path("item");

        if (productID.path("errors") != null && productID.path("errors").size() >= 1) {

            throw new ProductNotFoundException(
                    "Product not Found. Please check the Product ID on Target.com!");
        }

        Product product = new Product();
        product.setId(productID.path("product_id").asLong());
        product.setName(desc.path("product_description").path("title").asText());
        return product;
    }

}
