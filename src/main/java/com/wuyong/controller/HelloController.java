package com.wuyong.controller;

import com.wuyong.pojo.GirlProp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 坚果
 * on 2017/6/24
 */
//@ResponseBody+@Controller    controller配合模板使用
@RestController
public class HelloController {

    @Autowired
    private GirlProp girlProp;

    @RequestMapping(value = {"hello/{id}","hi/{id}"})
    public String sayHello(@PathVariable(value = "id") Integer ids) {
        return ids+"";
    }
}
