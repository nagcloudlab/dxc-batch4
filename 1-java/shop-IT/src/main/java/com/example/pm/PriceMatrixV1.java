package com.example.pm;

import org.apache.log4j.Logger;

public class PriceMatrixV1 implements PriceMatrix{

    private final static Logger logger = Logger.getLogger(PriceMatrixV1.class);

    public PriceMatrixV1(){
        logger.info("PriceMatrixV1 created");
    }

    public double getPrice(String itemCode){
        return 100.00;
    }
}
