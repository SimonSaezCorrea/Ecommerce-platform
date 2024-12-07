package demo.multitenant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MultitenantApplication {

	public static void main(String[] args) {
		SpringApplication.run(MultitenantApplication.class, args);
	}

}
