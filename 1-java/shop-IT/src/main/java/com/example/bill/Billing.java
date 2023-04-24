package com.example.bill;

import com.example.pm.PriceMatrix;
import org.apache.log4j.Logger;

import java.util.List;

public class Billing {

    private final static Logger logger = Logger.getLogger(Billing.class);
    private final PriceMatrix priceMatrix;

    public Billing(PriceMatrix priceMatrix) {
        this.priceMatrix = priceMatrix;
        logger.info("Billing created");
    }

    public double getTotalPrice(List<String> cart) {
        //PriceMatrixV1 priceMatrix = new PriceMatrixV1();
        //PriceMatrixV2 priceMatrix = new PriceMatrixV2();
        double total = 0;
        for (String itemCode : cart) {
            double price = priceMatrix.getPrice(itemCode);
            total += price;
        }
        return total;
    }

}
