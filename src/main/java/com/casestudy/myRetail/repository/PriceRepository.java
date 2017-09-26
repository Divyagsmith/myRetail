package com.casestudy.myRetail.repository;

import com.casestudy.myRetail.model.Price;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class PriceRepository {
    @Autowired
    MongoTemplate mongoTemplate;

    public Price findByProductId(Long productId) {

        Price price = mongoTemplate.findOne(buildQuery(productId), Price.class);

        return price;

    }

    private Query buildQuery(Long productID) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(productID));
        return query;
    }
}