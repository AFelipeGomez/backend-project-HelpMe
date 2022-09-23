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

@Entity
@Table(name="comment")

public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "description", nullable = false, length = 250)
	private String description;
	
	@Column(name="actual_date", nullable=false)
	private Date actualDate;
	
	@ManyToOne
    @JoinColumn(name = "id_ticket")
    private Ticket ticket;
	
	@ManyToOne
    @JoinColumn(name = "id_user")
    private User user;
}
