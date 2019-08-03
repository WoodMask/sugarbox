package com.sugarbox.jellyframeworktools;

import org.activiti.spring.boot.SecurityAutoConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@MapperScan("com.sugarbox.jellyframeworktools.mybatisplus.mapper")
public class JellyFrameworkToolsApplication {

	public static void main(String[] args) {
		SpringApplication.run(JellyFrameworkToolsApplication.class, args);
	}

}
