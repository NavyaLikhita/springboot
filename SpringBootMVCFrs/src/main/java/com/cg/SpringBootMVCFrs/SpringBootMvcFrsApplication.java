package com.cg.SpringBootMVCFrs;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class SpringBootMvcFrsApplication {
 private static final Logger logger = LoggerFactory.getLogger(SpringBootMvcFrsApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(SpringBootMvcFrsApplication.class, args);
		
		System.out.println("runnung");
		
	}

}
