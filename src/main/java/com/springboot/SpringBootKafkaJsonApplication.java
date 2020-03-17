package com.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.springboot.model.Car;
import com.springboot.service.Sender;

@SpringBootApplication
public class SpringBootKafkaJsonApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootKafkaJsonApplication.class, args);
	}
	
	@Autowired
	private Sender sender;

	@Override
	public void run(String... args) throws Exception {
		Car car = new Car("Passat", "Volkswagen", "ABC-123");
	    sender.send(car);
		
	}

}
