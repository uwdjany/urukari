package com.bavps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.bavps", "btr.framework"})
public class bavpsBackend {

	public static void main(String[] args) {
		SpringApplication.run(bavpsBackend.class, args);
	}

}
