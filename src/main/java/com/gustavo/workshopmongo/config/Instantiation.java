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
import com.gustavo.workshopmongo.dto.CommentDTO;
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
		
		CommentDTO comment1 = new CommentDTO("comentario 1 do primeiro post", sdf.parse("20/02/2025"), new AuthorDTO(alex));
		CommentDTO comment2 = new CommentDTO("comentario 2 do primeiro post", sdf.parse("25/02/2025"), new AuthorDTO(diego));
		CommentDTO comment3 = new CommentDTO("comentario 1 do segundo post", sdf.parse("25/02/2025"), new AuthorDTO(alex));
		CommentDTO comment4 = new CommentDTO("comentario 1 do terceiro post", sdf.parse("25/02/2025"), new AuthorDTO(maria));

		post1.getListComments().addAll(Arrays.asList(comment1, comment2));
		post2.getListComments().addAll(Arrays.asList(comment3));
		post3.getListComments().addAll(Arrays.asList(comment4));
		
		postRepository.saveAll(Arrays.asList(post1, post2, post3));
		
		maria.getListPosts().addAll(Arrays.asList(post1, post2));
		diego.getListPosts().addAll(Arrays.asList(post3));
		
		userRepository.saveAll(Arrays.asList(maria, diego));
		
		
	}

}
