package fun.baozi.swagger.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
/**
 * 测试Controller.
 *
 * @author meisen
 * 2020-09-18
 */
@Api(description = "测试Controller")
@RestController
@RequestMapping("/test")
public class TestController {


    @ApiOperation("获取测试数据")
    @GetMapping("/get")
    public String get(@ModelAttribute TestRq rq) {
        return "This is a test data, request id: " + rq.getId() + " name:" + rq.getName();
    }

}
