package com.huowolf.service;

import com.github.pagehelper.PageHelper;
import com.huowolf.mapper.UserMapper;
import com.huowolf.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by huowolf on 2018/11/7.
 */
@Service
public class TrainerService {

    @Autowired
    private UserMapper userMapper;

    public List<User> findAllTrainer(Integer page, Integer limit){

        //启用分页
        PageHelper.startPage(page,limit);

        User user = new User();
        user.setType(new Byte("1"));
        return userMapper.select(user);
    }


    public Integer countAllTrainer(){
        User user = new User();
        user.setType(new Byte("1"));
        return userMapper.selectCount(user);
    }
}
