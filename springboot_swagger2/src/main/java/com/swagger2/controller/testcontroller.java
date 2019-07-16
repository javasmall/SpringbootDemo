package com.swagger2.controller;


import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api("swagger2")
public class testcontroller {

    /**
     * Restful Get请求测试
     */
    @ApiOperation(value = "接口标题介绍",notes = "接口详细介绍")
    @ApiImplicitParam(name ="id",value = "学生id",paramType = "path",required = true,dataType = "String")
    @ApiImplicitParams({//测试框测试
            @ApiImplicitParam(name = "id",value = "用户id",dataType = "String",paramType = "query",example = "1112"),
            @ApiImplicitParam(name = "name",value = "姓名，介绍！",dataType = "String",paramType = "query",example = "bigsai")
    })

    @ApiResponses({
            @ApiResponse(code=400,message = "参数没有填好"),
            @ApiResponse(code=404,message="路径没有找到")
    })
    @GetMapping(value = "testRest/{id}/{name}")
    public String testGetResetful(@PathVariable String id,@PathVariable String name){

        System.out.println(id);
        return id+" "+name;
    }

    @ApiOperation(value = "接口标题介绍",notes = "接口详细介绍")//如果不声明会默认
    @GetMapping("test")
    public String test(String id)
    {
        return "test";
    }


}
