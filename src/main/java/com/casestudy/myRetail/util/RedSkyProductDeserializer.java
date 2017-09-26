package com.casestudy.myRetail.util;

import com.casestudy.myRetail.model.RedSkyProduct;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * Created by z071476 on 9/26/17.
 */
public class RedSkyProductDeserializer extends JsonDeserializer<RedSkyProduct> {


    @Override
    public RedSkyProduct deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        RedSkyProduct redSkyProduct = new RedSkyProduct();
        JsonNode root = mapper.readTree(jp);

        JsonNode name = root.path("product");
        JsonNode productID = name.path("available_to_promise_network");
        JsonNode desc = name.path("item");


        redSkyProduct.setProduct_id(productID.path("product_id").asLong());
        redSkyProduct.setTitle(desc.path("product_description").path("title").asText());
        return redSkyProduct;
    }
}
