package com.example;

import com.example.service.TransferService;
import org.dxc.config.DxcAutoConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
//@Import({
//        DxcAutoConfiguration.class
//})
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.example"})
@EnableAspectJAutoProxy
@EnableTransactionManagement
public class Application {
    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {


        //------------------------------------------------------
        // Init / Boot phase
        //------------------------------------------------------
        logger.info("-".repeat(100));

        ConfigurableApplicationContext applicationContext =
                SpringApplication.run(Application.class, args);

        logger.info("-".repeat(100));
        //------------------------------------------------------
        // User phase
        //------------------------------------------------------

//        String dxcIndia = applicationContext.getBean("dxcIndia", String.class);
//        System.out.println(dxcIndia);

        try {
            TransferService transferService = applicationContext.getBean("upiTransferService", TransferService.class);
            System.out.println(transferService.getClass());

            transferService.transfer(100.00, "1", "2");

        } catch (RuntimeException e) {
            logger.error(e.getMessage());
        }

        //------------------------------------------------------
        // Destroy phase
        //------------------------------------------------------
        logger.info("-".repeat(100));
        logger.info("-".repeat(100));
    }
}
