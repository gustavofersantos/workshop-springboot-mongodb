package com.gustavo.workshopmongo.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gustavo.workshopmongo.domain.Post;
import com.gustavo.workshopmongo.domain.User;
import com.gustavo.workshopmongo.dto.UserDTO;
import com.gustavo.workshopmongo.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	private UserService userService;

	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll() {
		List<User> listUsers = userService.findAll();
		List<UserDTO> listDto = listUsers.stream().map(UserDTO::new).collect(Collectors.toList());

		return ResponseEntity.ok().body(listDto);
	}

	@GetMapping(value = "/id:{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable String id) {
		User user = userService.findById(id);

		return ResponseEntity.ok().body(new UserDTO(user));
	}

	@GetMapping(value = "/name:{name}")
	public ResponseEntity<List<UserDTO>> findByName(@PathVariable String name) {
		List<User> listUsers = userService.findByName(name);
		List<UserDTO> listDto = listUsers.stream().map(UserDTO::new).collect(Collectors.toList());

		return ResponseEntity.ok().body(listDto);
	}

	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody UserDTO userDto) {
		User user = userService.fromDTO(userDto);
		user = userService.insert(user);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();

		return ResponseEntity.created(uri).build();
	}

	@DeleteMapping(value = "/id:{id}")
	public ResponseEntity<Void> deleteById(@PathVariable String id) {
		userService.deleteById(id);

		return ResponseEntity.noContent().build();
	}

	@DeleteMapping(value = "/name:{name}")
	public ResponseEntity<Void> deleteByName(@PathVariable String name) {
		userService.deleteByName(name);

		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/id:{id}")
	public ResponseEntity<Void> update(@RequestBody UserDTO userDto, @PathVariable String id) {
		User user = userService.fromDTO(userDto);
		user.setId(id);
		user = userService.update(user);
		return ResponseEntity.noContent().build();
	}

	@GetMapping(value = "/id:{id}/posts")
	public ResponseEntity<List<Post>> findPosts(@PathVariable String id) {
		User user = userService.findById(id);

		return ResponseEntity.ok().body(user.getListPosts());
	}

}
