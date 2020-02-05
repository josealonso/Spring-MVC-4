package masterSpringMvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * This annotation combines three other ones
 * @Configuration ---> indicates that our class will handle classical aspects of a Spring configuration.
 * @ComponentScan ---> it tells Spring where to look to find our Spring components.
 * @EnableAutoConfiguration ---> specific for Spring Boot.
 */
@SpringBootApplication
public class MasterSpringMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(MasterSpringMvcApplication.class, args);
	}

}
