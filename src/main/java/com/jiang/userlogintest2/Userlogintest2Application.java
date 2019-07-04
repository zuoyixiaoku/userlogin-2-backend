package com.jiang.userlogintest2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(value= {"com.jiang.userlogintest2.mapper"})
@SpringBootApplication
public class Userlogintest2Application {

	public static void main(String[] args) {
		SpringApplication.run(Userlogintest2Application.class, args);
	}

}
