package com.gentle.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// 在templates下面的页面只能通过controller跳转
@Controller
public class IndexController {

    @RequestMapping("/test")
    public String test() {
        return "test";
    }
}
