package com.huowolf.controller;

import com.huowolf.dto.TableResponse;
import com.huowolf.model.User;
import com.huowolf.service.TrainerService;
import com.huowolf.service.UserService;
import com.huowolf.util.Result;
import com.huowolf.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/**
 * Created by huowolf on 2018/11/7.
 */
@Controller
@RequestMapping("/trainer")
public class TrainerController {


    //文件上传路径
    @Value("${spring.http.multipart.location}")
    private String upload;

    @Autowired
    private TrainerService trainerService;

    @Autowired
    private UserService userService;

    @RequestMapping("list")
    public String list(){
        return "trainer/list";
    }

    @RequestMapping("toadd")
    public String toadd(){
        return "trainer/add";
    }

    @PostMapping("/showTrainerTable")
    @ResponseBody
    public TableResponse<User> showUserTable(Integer page, Integer limit){
        List<User> userList = trainerService.findAllTrainer(page, limit);

        Integer userCount = trainerService.countAllTrainer();

        TableResponse<User> tableResponse = new TableResponse<>();

        tableResponse.setCount(userCount);
        tableResponse.setData(userList);

        return tableResponse;
    }

    @PostMapping("/upload")
    @ResponseBody
    public Result upload(MultipartFile file) {

        String originalFilename = file.getOriginalFilename();	//原始名称

        //新的图片名称
        String newFileName = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));
        File newFile = new File(upload+newFileName);

        //将内存中的数据写入磁盘
        try {
            file.transferTo(newFile);
        } catch (IOException e) {
            return ResultUtil.error("上传失败");
        }

        HashMap hashMap = new HashMap();
        hashMap.put("src",newFileName);
        return ResultUtil.success("上传成功",hashMap);
    }

    @PostMapping("add")
    public String add(User user){
        userService.add(user);
        return "redirect:/trainer/list";
    }



}
