package com.example.batchprocessing.config;

import com.example.batchprocessing.model.Product;
import org.springframework.batch.item.ItemProcessor;

public class CustomItemProcessor implements ItemProcessor<Product, Product> {

    @Override
    public Product process(Product item) throws Exception {
        //we put necessary logic for transform here
        int disPer = Integer.parseInt(item.getDiscount());
        double originalPrice = Double.parseDouble(item.getPrice());
        double discount = (disPer/100)*originalPrice;
        double finalPrice = originalPrice - discount;
        item.setDiscountedPrice(String.valueOf(finalPrice));
        return item;
    }
}
