package com.gustavo.workshopmongo.dto;

import java.io.Serializable;
import java.util.Date;

public class CommentDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String text;
	private Date date;
	private AuthorDTO authorComment;

	public CommentDTO() {
	}

	public CommentDTO(String text, Date date, AuthorDTO authorComment) {
		super();
		this.text = text;
		this.date = date;
		this.authorComment = authorComment;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public AuthorDTO getAuthorComment() {
		return authorComment;
	}

	public void setAuthorComment(AuthorDTO authorComment) {
		this.authorComment = authorComment;
	}

}
