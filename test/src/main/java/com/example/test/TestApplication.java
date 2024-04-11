package com.example.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.test.database.entity.EmployeeEntity;
import com.example.test.database.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
//@EnableSwagger2
//@ComponentScan({"com.example.test", "com.example"})
//@ComponentScan({"com.example.test"})
//@EnableAutoConfiguration
//public class FileTestApplication implements CommandLineRunner {
//public class FileTestApplication implements ApplicationRunner {
public class TestApplication implements ApplicationRunner, CommandLineRunner{

	public static void main(String[] args) {
		//SpringApplication.run(TestApplication.class, args);
		System.out.println("logEntry:FileTestApplication.main method");
		//SpringApplication.run(TestApplication.class, args);
		ApplicationContext ctx = SpringApplication.run(TestApplication.class, args);

		String[] beanNames = ctx.getBeanDefinitionNames();

		Arrays.sort(beanNames);

		for (String beanName : beanNames) {
			System.out.println("sortedBeanNames="+beanName);
		}

		System.out.println("logExit:FileTestApplication.main method");
	}


	@Bean
	public RestTemplate getRestTemplate() {
		System.out.println("logentry FileTestApplication.getRestTemplate method");
		return new RestTemplate();
	}



	@Override
	public void run(ApplicationArguments arg0) throws Exception {
		System.out.println("logEntry: FileTestApplication.run method which is overridden method of ApplicationRunner");

		//List<EmployeeEntity> employeeEntityList = employeeRepository.findAll();
		//employeeEntityList.forEach(System.out :: println);
	}


	@Override
	public void run(String... args) throws Exception {
		System.out.println("logEntry: FileTestApplication.run method which is overridden method of CommandLineRunner");

	}

}
