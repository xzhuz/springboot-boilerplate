package fun.baozi.web;

import tk.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author baozi
 * 2020-07-02
 */
@SpringBootApplication
@MapperScan(basePackages = "fun.baozi.web.dao.mappers")
public class BoilerplateWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(BoilerplateWebApplication.class, args);
    }

}
