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
		Optional<User> user = userRepository.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException("Id de usuário não encontrado"));
	}
	
	public List<User> findByName(String name) {
		List<User> listUsers = userRepository.findByName(name);
		if (listUsers != null ) {
			return listUsers;
		}
		throw new ObjectNotFoundException("Nome de usuário não encontrado");
	}
	
	public User insert(User user) {
		return userRepository.insert(user);
	}
	
	public void deleteById(String id) {
		findById(id);
		userRepository.deleteById(id);
	}
	
	public void deleteByName(String name) {
		List<User> users = userRepository.findByName(name);
		
		userRepository.deleteById(users.get(0).getId());
	}
	
	public User update(User user) {
		User updatedUser = userRepository.findById(user.getId()).get();
		updateData(updatedUser, user);
		return userRepository.save(updatedUser);
	}

	
	private void updateData(User updatedUser, User user) {
		updatedUser.setName(user.getName());
		updatedUser.setEmail(user.getEmail());
		
	}

	public User fromDTO(UserDTO userDto) {
		return new User(userDto.getId(), userDto.getName(), userDto.getEmail());
	}
	
}
