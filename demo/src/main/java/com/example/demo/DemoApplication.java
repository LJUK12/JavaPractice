package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.dao.IPostDAO;

@SpringBootApplication

// 찾지 못하는 bean이 존재하는 mapper를 scan한다.
// 사용이유 = mybatis를 사용하면서 mapper 를 사용하기 위한 DAO위치를 지정해줘야 하기 때문에.

public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		
	}

}
