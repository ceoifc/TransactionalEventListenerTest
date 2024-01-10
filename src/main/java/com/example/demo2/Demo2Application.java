package com.example.demo2;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class Demo2Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo2Application.class, args);
	}

	@Component
	public static class TempRunner implements ApplicationRunner {

		private final TempRepository repository;

		public TempRunner(TempRepository repository) {
			this.repository = repository;
		}

		@Override
		public void run(ApplicationArguments args) throws Exception {
			repository.save(new Temp("first"));
		}
	}
}
