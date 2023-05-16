package com.example;

import com.example.config.DataSourceConfiguration;
import com.example.config.JpaConfiguration;
import com.example.service.TransferService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@Import({
        DataSourceConfiguration.class,
        JpaConfiguration.class
})
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
                new AnnotationConfigApplicationContext(Application.class);

        logger.info("-".repeat(100));
        //------------------------------------------------------
        // User phase
        //------------------------------------------------------

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
