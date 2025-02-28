package com.gustavo.workshopmongo.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gustavo.workshopmongo.domain.Post;
import com.gustavo.workshopmongo.repository.PostRepository;
import com.gustavo.workshopmongo.services.exceptions.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository postRepository;
	
	public Post findById(String id) {
		Optional<Post> post = postRepository.findById(id);
		return post.orElseThrow(() -> new ObjectNotFoundException("Post não encontrado"));
	}
	
	public List<Post> findByTitle(String text) {
		return postRepository.fetchTitle(text);
	}
	
	public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
		/* é necessario considerar o final do dia do maxDate, entao
		 comparaçao menor ou igual da meia noite do proximo dia
		 essa operaçao feita para transformar 24 horas em milissegundos*/
		maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
		
		return postRepository.fullSearch(text, minDate, maxDate);
	}
	
}
