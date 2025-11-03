package com.tripleOtech.freshAndFit;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@RequiredArgsConstructor
public class FreshAndFitApplication {

	public static void main(String[] args) {
		SpringApplication.run(FreshAndFitApplication.class, args);
	}

}
