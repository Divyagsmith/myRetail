package com.casestudy.myRetail;

import com.casestudy.myRetail.Service.PriceService;
import com.casestudy.myRetail.Service.ProductService;
import com.casestudy.myRetail.model.Price;
import com.casestudy.myRetail.model.Product;
import com.casestudy.myRetail.util.ProductNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * Created by z071476 on 9/22/17.
 */
@RestController
public class MyRetailController {

    private static final Logger log = LoggerFactory
            .getLogger(MyRetailController.class);
    @Autowired
    ProductService productService;
    @Autowired
    PriceService priceService;

    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
    public Product product(@PathVariable Long id) throws ProductNotFoundException, IOException {

        Product product = productService.getProduct(id);
        updateProductPrice(id, product);

        return product;

    }

    /*
    Update Product with price from PriceService
     */
    public void updateProductPrice(long id, Product product) {

        try {
            Price price = priceService.getPrice(id);
            product.setPrice(price);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

}
