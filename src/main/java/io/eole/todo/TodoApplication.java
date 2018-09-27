package io.eole.todo;

import io.eole.todo.service.impl.SetupService;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.modelmapper.convention.NamingConventions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableAutoConfiguration
public class TodoApplication {


	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(TodoApplication.class, args);
		context.getBean(SetupService.class).setUp();
	}

	@Bean
	public ModelMapper modelMapper(){

		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration()
				.setFieldMatchingEnabled(true)
      .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE)
      .setSourceNamingConvention(NamingConventions.JAVABEANS_MUTATOR);

		return modelMapper;
	}
}
