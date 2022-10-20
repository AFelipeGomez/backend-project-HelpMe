package com.HelpMe.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "responses")
public class Response {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "answer", nullable = false, length = 25)
	private String answer;

	@OneToOne
	@JoinColumn(name = "id_ticket")
	private Ticket ticket;

	@ManyToOne
	@JoinColumn(name = "id_userSuport")
	private User user;

	public Response(Integer id, String answer, Ticket ticket, User user) {
		super();
		this.id = id;
		this.answer = answer;
		this.ticket = ticket;
		this.user = user;
	}

	public Response() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
	@JsonBackReference(value="defaultTicket")
	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}
	@JsonBackReference(value="defaultUser")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	

}
