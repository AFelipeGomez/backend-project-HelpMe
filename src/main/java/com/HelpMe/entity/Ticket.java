package com.HelpMe.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "ticket")
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "actual_date", nullable = false)
	private Date actualDate;

	@Column(name = "description", nullable = false, length = 500)
	private String description;

	@Column(name = "observation", nullable = false, length = 500)
	private String observation;

	@Column(name = "answer", nullable = true, length = 500)
	private String answer;

	@Column(name = "qualification", nullable = true)
	private int qualification;

	

	@ManyToOne
	@JoinColumn(name = "id_status",foreignKey = @ForeignKey(name = "FK_status"))
	private Status status;

	@ManyToOne
	@JoinColumn(name = "id_priority",foreignKey = @ForeignKey(name = "FK_priority"))
	private Priority priority;

	@ManyToOne
	@JoinColumn(name = "id_client")
	private User userClient;

	@OneToOne(mappedBy = "ticket")
	private Response response;

	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name="id_support") private User userSupport;
	 */

	@OneToMany(mappedBy = "ticket",  fetch = FetchType.LAZY)
	private List<Comment> comments;

	public Ticket(Integer id, Date actualDate, String description, String observation, String answer, int qualification,
			 Status status, Priority priority, User userClient, Response response, List<Comment> comments) {
		super();
		this.id = id;
		this.actualDate = actualDate;
		this.description = description;
		this.observation = observation;
		this.answer = answer;
		this.qualification = qualification;
		
		this.status = status;
		this.priority = priority;
		this.userClient = userClient;
		this.response = response;
		this.comments = comments;
	}

	public Ticket() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getActualDate() {
		return actualDate;
	}

	public void setActualDate(Date actualDate) {
		this.actualDate = actualDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public int getQualification() {
		return qualification;
	}

	public void setQualification(int qualification) {
		this.qualification = qualification;
	}

	

	//@JsonManagedReference(value="defaultStatus")
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	//@JsonManagedReference(value="defautPriority")
	public Priority getPriority() {
		return priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	//@JsonManagedReference(value="defaultClient")
	public User getUserClient() {
		return userClient;
	}

	public void setUserClient(User userClient) {
		this.userClient = userClient;
	}

	public Response getResponse() {
		return response;
	}

	public void setResponse(Response response) {
		this.response = response;
	}

	@JsonManagedReference(value="defautComment")
	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	
}
