package com.gustavo.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.gustavo.workshopmongo.domain.Post;
import com.gustavo.workshopmongo.domain.User;
import com.gustavo.workshopmongo.dto.AuthorDTO;
import com.gustavo.workshopmongo.repository.PostRepository;
import com.gustavo.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();

		User maria = new User(null, "Maria Peixoto", "maria@gmail.com");
		User alex = new User(null, "Alex da Silva", "alex@gmail.com");
		User diego = new User(null, "Diego Gomes", "diego@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, diego));
		
		Post post1 = new Post(null, sdf.parse("20/02/2025"), "Título do primeiro post", "Corpo do primeiro post", new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("25/02/2025"), "Título do segundo post", "Corpo do segundo post", new AuthorDTO(maria));
		Post post3 = new Post(null, sdf.parse("25/02/2025"), "Título do terceiro post", "Corpo do terceiro post", new AuthorDTO(diego));

		postRepository.saveAll(Arrays.asList(post1, post2, post3));
	}

}
