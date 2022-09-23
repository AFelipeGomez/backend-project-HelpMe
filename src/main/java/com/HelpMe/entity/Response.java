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

}
