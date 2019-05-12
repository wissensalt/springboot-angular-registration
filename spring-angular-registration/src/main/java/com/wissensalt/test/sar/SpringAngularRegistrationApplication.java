package com.wissensalt.test.sar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*@ComponentScan(basePackages = {
        "com.wissensalt.test.sar.dao",
        "com.wissensalt.test.sar.endpoint",
        "com.wissensalt.test.sar.service",
        "com.wissensalt.test.sar.mapper",
        "com.wissensalt.test.sar.validation",
}, lazyInit = true)
@EntityScan(basePackages = {"com.wissensalt.test.sar.model"})
@EnableJpaRepositories(basePackages = {"com.wissensalt.test.sar.dao"})*/
@SpringBootApplication
public class SpringAngularRegistrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAngularRegistrationApplication.class, args);
	}

}
