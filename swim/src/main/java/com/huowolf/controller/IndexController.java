package com.huowolf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by huowolf on 2018/11/5.
 */
@Controller
@RequestMapping("/")
public class IndexController {


    @RequestMapping("")
    public String index(){
        return "index";
    }
}
