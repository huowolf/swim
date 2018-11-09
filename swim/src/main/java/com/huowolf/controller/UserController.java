package com.huowolf.controller;

import com.huowolf.dto.TableResponse;
import com.huowolf.model.User;
import com.huowolf.service.UserService;
import com.huowolf.util.Result;
import com.huowolf.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by huowolf on 2018/11/6.
 */
@RequestMapping("/user")
@Controller
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/add")
    public String add(User user){
        userService.add(user);
        return "redirect:/tologin";
    }

    @GetMapping("/list")
    public String list(){
        return "user/list";
    }

    @PostMapping("/showUserTable")
    @ResponseBody
    public TableResponse<User> showUserTable(Integer page,Integer limit){
        List<User> userList = userService.findAllUser(page, limit);

        Integer userCount = userService.countAllUser();

        TableResponse<User> tableResponse = new TableResponse<>();

        tableResponse.setCount(userCount);
        tableResponse.setData(userList);

        return tableResponse;
    }


    @PostMapping("/editUser")
    @ResponseBody
    public Result editUser(User user){

        Boolean flag = userService.editUser(user);
        if(flag){
            return ResultUtil.success();
        }else{
            return ResultUtil.error("更新失败");
        }
    }

    @PostMapping("deleteUser")
    @ResponseBody
    public Result deleteUser(Integer id){
        userService.deleteUser(id);
        return ResultUtil.success("删除成功",null);
    }

}
