package io.eole.todo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableAutoConfiguration
public class TodoApplication {

	@RequestMapping("/")
	String home(){
		return "HEllo WOrld";
	}

	public static void main(String[] args) {
		SpringApplication.run(TodoApplication.class, args);
	}
}
