package com.viajaplus.ViajaPlus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ViajaPlusApplication {
	public static void main(String[] args) {
		SpringApplication.run(ViajaPlusApplication.class, args);
	}

}
