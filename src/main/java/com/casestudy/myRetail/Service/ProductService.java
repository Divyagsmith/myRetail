package com.casestudy.myRetail.Service;

import com.casestudy.myRetail.Exception.ProductNotFoundException;
import com.casestudy.myRetail.model.Product;
import com.casestudy.myRetail.model.RedSkyProduct;
import com.casestudy.myRetail.util.RedSkyProductDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

/**
 * Created by z071476 on 9/23/17.
 * ProductService rest service to perform a get by ProductID and returns price and description if available.
 */
@Service
@ConfigurationProperties(prefix = "externalProductService")
public class ProductService {

    private String url;
    private RestTemplate restTemplate;

    public ProductService() {
    }

    @Autowired
    public ProductService(RestTemplateBuilder restTemplateBuilder, @Value("${externalProductService.url}") String url) {
        this.url = url;
        this.restTemplate = restTemplateBuilder.build();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Product getProduct(Long productId) throws ProductNotFoundException, IOException {

        try {

            ResponseEntity<String> response = restTemplate.getForEntity(url.concat(productId.toString()), String.class);
            return parseReponse(response.getBody());
        } catch (Exception e) {
            throw new ProductNotFoundException("Product not found. Please check the Product ID on Target.com!", e);
        }
    }

    /*
    *parseResponse, uses custom serializer to store applicable values within RedSkyProduct call response
     */
    Product parseReponse(String responseBody) throws IOException,
            ProductNotFoundException {
        ObjectMapper mapper = new ObjectMapper();
        Product product = new Product();

        SimpleModule module = new SimpleModule();
        module.addDeserializer(RedSkyProduct.class, new RedSkyProductDeserializer());
        mapper.registerModule(module);

        RedSkyProduct redSkyProduct = mapper.readValue(responseBody, RedSkyProduct.class);
        product.setName(redSkyProduct.getTitle());
        product.setId(redSkyProduct.getProduct_id());

        return product;
    }


}
