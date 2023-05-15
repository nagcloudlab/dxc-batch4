package com.example;

import com.example.aspects.ExceptionMetricAspect;
import com.example.aspects.MethodInvokeMetricAspect;
import com.example.config.MoneyTransferServiceConfiguration;
import com.example.repository.AccountRepository;
import com.example.repository.JdbcAccountRepository;
import com.example.service.TransferService;
import com.example.service.UPITransferService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {


        //------------------------------------------------------
        // Init / Boot phase
        //------------------------------------------------------
        logger.info("-".repeat(100));

        ConfigurableApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(MoneyTransferServiceConfiguration.class);

        logger.info("-".repeat(100));
        //------------------------------------------------------
        // User phase
        //------------------------------------------------------

        try {
            TransferService transferService = applicationContext.getBean("upiTransferService", TransferService.class);
            System.out.println(transferService.getClass());

            transferService.transfer(100.00, "1", "2");
            transferService.transfer(10000.00, "1", "2");

        } catch (RuntimeException e) {
            logger.error(e.getMessage());
        }


        logger.info("-".repeat(100));
        logger.info(
                applicationContext.getBean(MethodInvokeMetricAspect.class).getMetrics().toString()
        );
        logger.info(
                applicationContext.getBean(ExceptionMetricAspect.class).getMetrics().toString()
        );
        logger.info("-".repeat(100));

        //------------------------------------------------------
        // Destroy phase
        //------------------------------------------------------
        logger.info("-".repeat(100));
        logger.info("-".repeat(100));
    }
}
