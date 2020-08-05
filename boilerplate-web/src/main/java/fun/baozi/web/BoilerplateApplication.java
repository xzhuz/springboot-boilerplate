package fun.baozi.web;

import tk.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author baozi
 * 2020-07-02
 */
@SpringBootApplication(scanBasePackages = {"fun.baozi"})
@MapperScan(basePackages = {"fun.baozi.web.data.dao.mappers"})
public class BoilerplateApplication {

    public static void main(String[] args) {
        SpringApplication.run(BoilerplateApplication.class, args);
    }

}
