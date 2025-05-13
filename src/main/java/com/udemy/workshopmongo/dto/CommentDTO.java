package com.udemy.workshopmongo.dto;

import java.io.Serializable;
import java.util.Date;

public class CommentDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String text;
	private Date date;
	private authorDTO author;

	public CommentDTO() {
	}

	public CommentDTO(String text, Date date, authorDTO author) {
		super();
		this.text = text;
		this.date = date;
		this.author = author;
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

	public authorDTO getAuthor() {
		return author;
	}

	public void setAuthor(authorDTO author) {
		this.author = author;
	}
	
	

}
