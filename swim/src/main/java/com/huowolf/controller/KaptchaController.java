package com.huowolf.controller;

import com.baomidou.kaptcha.Kaptcha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by huowolf on 2018/11/6.
 */

//必须是RestController 否则报错
@RestController
public class KaptchaController {

    @Autowired
    private Kaptcha kaptcha;

    @GetMapping("/kaptcha")
    public void kaptcha(){
        kaptcha.render();
    }
}
