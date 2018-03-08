package com.hebeu.ask.healthask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ImportResource;

/**
 * @Author  : chendehua
 * @Time    : 2018/03/06
 * @Desc    : springboot 启动程序
 */

@ImportResource({
		"classpath:ctx-app.xml"
})
@SpringBootApplication
@EnableAutoConfiguration(exclude = {
		DataSourceAutoConfiguration.class
})
public class HealthAskApplication {

	public static void main(String[] args) {
		SpringApplication.run(HealthAskApplication.class, args);
	}
}
