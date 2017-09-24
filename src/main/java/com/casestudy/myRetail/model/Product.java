package com.casestudy.myRetail.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Created by z071476 on 9/21/17.
 */
@JsonPropertyOrder({"id", "name", "price"})
public class Product {
    private long product_Id;
    private String product_name;
    private Price price;

    public Product() {
    }

    public Product(long product_Id, String product_name, Price price) {
        this.product_Id = product_Id;
        this.product_name = product_name;
        this.price = price;
    }

    public long getId() {
        return product_Id;
    }

    public void setId(long Id) {
        this.product_Id = Id;
    }

    public String getName() {
        return product_name;
    }

    public void setName(String name) {
        this.product_name = name;
    }

    @JsonProperty("current_price")
    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "product_Id=" + product_Id +
                ", product_name='" + product_name + '\'' +
                ", price=" + price +
                '}';
    }
}
