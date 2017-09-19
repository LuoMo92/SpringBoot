package com.luomo.study.spring.boot.chapter3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by LiuMei on 2017-09-19.
 */

@Controller
public class DemoController {

    @RequestMapping("/")
    public String index(ModelMap map) {
        map.addAttribute("host", "http://www.baidu.com");
        return "index";
    }

}
