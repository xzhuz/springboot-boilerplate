package fun.baozi.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * 启动类.
 *
 * @author baozi
 * 2020-07-02
 */
@SpringBootApplication(scanBasePackages = {"fun.baozi"})
@MapperScan(basePackages = {"fun.baozi.web.data.dao.mappers"})
public class WebApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }

}
