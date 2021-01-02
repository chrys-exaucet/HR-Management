package org.human.resources;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages ="org.human.resources")
public class HRApplication {

	public static void main(String[] args) {
		SpringApplication.run(HRApplication.class, args);
	}

}
