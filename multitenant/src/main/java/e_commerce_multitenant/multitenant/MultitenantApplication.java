package e_commerce_multitenant.multitenant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("demo.multitenant.*")
public class MultitenantApplication {

	public static void main(String[] args) {
		SpringApplication.run(MultitenantApplication.class, args);
	}

}
