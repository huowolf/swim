package com.huowolf.service;

import com.github.pagehelper.PageHelper;
import com.huowolf.mapper.UserMapper;
import com.huowolf.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by huowolf on 2018/11/6.
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User findUserByNameAndPassword(String name,String password){
        User user  = new User();
        user.setName(name);
        user.setPassword(password);

        return userMapper.selectOne(user);
    }


    public Boolean add(User user){
        int result = userMapper.insertSelective(user);
        if (result != 0){
            return Boolean.TRUE;
        }else{
            return Boolean.FALSE;
        }
    }


    public List<User> findAllUser(Integer page, Integer limit){

        //启用分页
        PageHelper.startPage(page,limit);

        User user = new User();
        user.setType(new Byte("0"));
        return userMapper.select(user);
    }


    public Integer countAllUser(){
        User user = new User();
        user.setType(new Byte("0"));
        return userMapper.selectCount(user);
    }

    public Boolean editUser(User user){
        int i = userMapper.updateByPrimaryKeySelective(user);
        if (i!=0){
            return Boolean.TRUE;
        }else{
            return Boolean.FALSE;
        }
    }

    public void deleteUser(Integer id){
        userMapper.deleteByPrimaryKey(id);
    }




}
