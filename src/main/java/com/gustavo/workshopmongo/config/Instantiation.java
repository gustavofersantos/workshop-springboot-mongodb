package com.gustavo.workshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.gustavo.workshopmongo.domain.User;
import com.gustavo.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		userRepository.deleteAll();

		User maria = new User(null, "Maria Peixoto", "maria@gmail.com");
		User alex = new User(null, "Alex da Silva", "alex@gmail.com");
		User diego = new User(null, "Diego Gomes", "diego@gmail.com");

		userRepository.saveAll(Arrays.asList(maria, alex, diego));
	}

}
