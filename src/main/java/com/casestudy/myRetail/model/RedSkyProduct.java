package com.casestudy.myRetail.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by z071476 on 9/25/17.
 */
public class RedSkyProduct {

    @JsonProperty("title")
    private String title;

    @JsonProperty("product_id")
    private long product_id;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(long product_id) {
        this.product_id = product_id;
    }

    @Override
    public String toString() {
        return "RedSkyProduct{" +
                "title='" + title + '\'' +
                ", product_id=" + product_id +
                '}';
    }
}
