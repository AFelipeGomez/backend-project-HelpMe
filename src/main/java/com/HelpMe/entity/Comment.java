package com.HelpMe.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "comment")

public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "description", nullable = false, length = 250)
	private String description;

	@Column(name = "actual_date", nullable = false)
	private Date actualDate;

	@ManyToOne
	@JoinColumn(name = "id_ticket")
	private Ticket ticket;

	@ManyToOne
	@JoinColumn(name = "id_user")
	private User user;

	public Comment(Integer id, String description, Date actualDate, Ticket ticket, User user) {
		super();
		this.id = id;
		this.description = description;
		this.actualDate = actualDate;
		this.ticket = ticket;
		this.user = user;
	}

	public Comment() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getActualDate() {
		return actualDate;
	}

	public void setActualDate(Date actualDate) {
		this.actualDate = actualDate;
	}

	@JsonBackReference(value = "defautComment")
	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	@JsonBackReference(value = "CommentUser")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
