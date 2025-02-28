package com.gustavo.workshopmongo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.gustavo.workshopmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

	@Query("{ 'postTitle': { $regex: ?0, $options: 'i' } }")
	List<Post> fetchTitle(String text);
	
	List<Post> findByPostTitleContainingIgnoreCase(String postTitle);
	
	@Query("{ $and: [ { 'date': { $gte: ?1 } }, { 'date': { $lte: ?2 } }, { $or: [ { 'postTitle': { $regex: ?0, $options: 'i' } }, { 'postBody': { $regex: ?0, $options: 'i' } }, { 'comments.text': { $regex: ?0, $options: 'i' } } ] } ] }")
	List<Post> fullSearch(String text, Date minDate, Date maxDate);
}
