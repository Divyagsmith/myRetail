package com.casestudy.myRetail.Service;

import com.casestudy.myRetail.model.Price;
import com.casestudy.myRetail.repository.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by z071476 on 9/23/17.
 */
@Service
public class PriceService {

    @Autowired
    PriceRepository priceRepo;

    public Price getPrice(Long productId) {

        return priceRepo.findByProductId(productId);

    }

}
