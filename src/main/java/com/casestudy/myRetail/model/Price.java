package com.casestudy.myRetail.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Created by z071476 on 9/21/17.
 */
@JsonPropertyOrder({"value", "currency_code"})
public class Price {
    private double current_price;
    private String currency_code;
    private long id;

    public Price() {
    }

    public Price(double current_price, String currency_code) {
        this.current_price = current_price;
        this.currency_code = currency_code;
    }

    @JsonProperty("value")
    public double getCurrent_price() {
        return current_price;
    }

    public void setCurrent_price(double current_price) {
        this.current_price = current_price;
    }

    public String getCurrency_code() {
        return currency_code;
    }

    public void setCurrency_code(String currency_code) {
        this.currency_code = currency_code;
    }

    @JsonIgnore
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Price{" +
                "current_price=" + current_price +
                ", currency_code='" + currency_code + '\'' +
                '}';
    }
}
