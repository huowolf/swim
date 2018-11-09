package com.huowolf.controller;

import com.baomidou.kaptcha.Kaptcha;
import com.huowolf.model.User;
import com.huowolf.service.UserService;
import com.huowolf.util.Result;
import com.huowolf.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created by huowolf on 2018/11/6.
 */
@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private Kaptcha kaptcha;

    @PostMapping("/login")
    @ResponseBody
    public Result login(String code,String username, String password, HttpSession httpSession){

        //default timeout 900 seconds
        kaptcha.validate(code);

        User user = userService.findUserByNameAndPassword(username, password);
        if(user==null){
            return ResultUtil.error("用户名或密码不正确");
        }else{
            httpSession.setAttribute("loginInfo",user);
            return ResultUtil.success();
        }
    }


    @GetMapping("/tologin")
    public String tologin(){
        return "login";
    }


    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("loginInfo");
        session.invalidate();
        return "redirect:/tologin";
    }
}
