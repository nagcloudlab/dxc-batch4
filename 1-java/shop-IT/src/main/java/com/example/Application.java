package com.example;

import com.example.bill.Billing;
import com.example.pm.PriceMatrix;
import com.example.pm.PriceMatrixV1;
import com.example.pm.PriceMatrixV2;

import java.util.List;

public class Application {
    public static void main(String[] args) {

        PriceMatrix priceMatrixV1 = new PriceMatrixV1();
        PriceMatrix priceMatrixV2 = new PriceMatrixV2();
        Billing billing = new Billing(priceMatrixV2);

        System.out.println();

        System.out.println();
        List<String> cart1 = List.of("1", "2", "3");
        double totalPrice1 = billing.getTotalPrice(cart1);
        System.out.println(totalPrice1);

        System.out.println();
        List<String> cart2 = List.of("1", "2");
        double totalPrice2 = billing.getTotalPrice(cart2);
        System.out.println(totalPrice2);

        System.out.println("Happy shopping");

    }

}
