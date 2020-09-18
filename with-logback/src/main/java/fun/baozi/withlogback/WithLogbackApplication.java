package fun.baozi.withlogback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WithLogbackApplication {

    private static final Logger logger = LoggerFactory.getLogger(WithLogbackApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(WithLogbackApplication.class, args);
    }

    @Bean
    public String injectStringBean() {
        logger.info(">>>>>>>This is a info log.");
        logger.error(">>>>>>>This is a error log.");
        logger.debug(">>>>>>>This is a debug log.");
        logger.warn(">>>>>>>This is a warn log.");
        return "test";
    }



}
