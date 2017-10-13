package com.luomo.study.spring.boot.chapter1.web;

import com.luomo.study.spring.boot.exception.MyException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by LiuMei on 2017-09-19.
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String index() throws Exception{
        throw new Exception("发生错误");
    }

    @RequestMapping("json")
    public String json() throws MyException{
        throw new MyException("发生error");
    }
}
