package com.greatlearning.ticket.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "ticket_details")
public class Ticket {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "title" , nullable = false)
	private String title;

	@Column(name = "short_description")
	private String description;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public LocalDate createdOn;

	@Column(name = "content")
	private String content;

	public Ticket() {

	}

	public Ticket(Long id,String title, String description, LocalDate createdOn, String content) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.createdOn = createdOn;
		this.content = content;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getDateCreated() {
		return createdOn;
	}

	public void setDateCreated(LocalDate createdOn) {
		this.createdOn = createdOn;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
