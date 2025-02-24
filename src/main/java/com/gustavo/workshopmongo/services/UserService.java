package com.gustavo.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gustavo.workshopmongo.domain.User;
import com.gustavo.workshopmongo.dto.UserDTO;
import com.gustavo.workshopmongo.repository.UserRepository;
import com.gustavo.workshopmongo.services.exceptions.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll() {
		return userRepository.findAll();
	}
	
	public User findById(String id) {
		Optional<User> obj = userRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Id de usuário não encontrado"));
	}
	
	public List<User> findByName(String name) {
		List<User> user = userRepository.findByName(name);
		if (user != null ) {
			return user;
		}
		throw new ObjectNotFoundException("Nome de usuário não encontrado");
	}
	
	public User insert(User obj) {
		return userRepository.insert(obj);
	}
	
	public void deleteById(String id) {
		findById(id);
		userRepository.deleteById(id);
	}
	
	public void deleteByName(String name) {
		List<User> users = userRepository.findByName(name);
		
		userRepository.deleteById(users.get(0).getId());
	}
	

	
	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}
	
}
