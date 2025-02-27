package com.gustavo.workshopmongo.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.gustavo.workshopmongo.dto.AuthorDTO;
import com.gustavo.workshopmongo.dto.CommentDTO;

@Document(collection = "post")
public class Post implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String postId;
	private Date date;
	private String postTitle;
	private String postBody;
	private AuthorDTO postAuthor;
	
	private List<CommentDTO> listComments = new ArrayList<>();


	public Post() {
	}

	public Post(String id, Date date, String postTitle, String postBody, AuthorDTO postAuthor) {
		super();
		this.postId = id;
		this.date = date;
		this.postTitle = postTitle;
		this.postBody = postBody;
		this.postAuthor = postAuthor;
	}

	public String getId() {
		return postId;
	}

	public void setId(String id) {
		this.postId = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getPostTitle() {
		return postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

	public String getPostBody() {
		return postBody;
	}

	public void setPostBody(String postBody) {
		this.postBody = postBody;
	}

	public AuthorDTO getPostAuthor() {
		return postAuthor;
	}

	public void setPostAuthor(AuthorDTO postAuthor) {
		this.postAuthor = postAuthor;
	}

	public List<CommentDTO> getListComments() {
		return listComments;
	}
	
	public void setListComments(List<CommentDTO> listComments) {
		this.listComments = listComments;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(postId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Post other = (Post) obj;
		return Objects.equals(postId, other.postId);
	}

}
