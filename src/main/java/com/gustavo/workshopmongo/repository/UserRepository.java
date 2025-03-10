package com.gustavo.workshopmongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.gustavo.workshopmongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

	@Query("{ 'name': { $regex: ?0, $options: 'i' } }")
	List<User> findByName(String name);

}
