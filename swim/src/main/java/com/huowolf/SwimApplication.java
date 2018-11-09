package com.huowolf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@MapperScan(basePackages = "com.huowolf.mapper")
@SpringBootApplication
public class SwimApplication {

	public static void main(String[] args) {
		SpringApplication.run(SwimApplication.class, args);
	}
}
