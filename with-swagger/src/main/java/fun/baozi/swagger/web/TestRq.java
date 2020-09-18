package fun.baozi.swagger.web;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 测试入参
 * @author meisen
 * 2020-09-18
 */
@ApiModel
public class TestRq {

    @ApiModelProperty("id")
    private String id;

    @ApiModelProperty("名字")
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
