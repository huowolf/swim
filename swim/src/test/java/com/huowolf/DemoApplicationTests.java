package com.huowolf;

import com.huowolf.mapper.UserMapper;
import com.huowolf.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Random;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	private UserMapper userMapper;

	@Test
	public void contextLoads() {
	}


	@Test
	public void initUserData(){
		Random random = new Random();
		for (int i = 0; i < 20; i++) {
			User user = new User();

			if(random.nextInt(2)==0){
				user.setType(new Byte("0"));
			}else{
				user.setType(new Byte("1"));
			}

			if(random.nextInt(2)==0){
				user.setSex("男");
			}else{
				user.setSex("女");
			}
			user.setName("test"+i);
			user.setPassword("test"+i);

			userMapper.insert(user);
		}
	}



}
