package com.HelpMe.entity;

import java.util.List;

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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name = "users")
public class User {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; 

    @Column(name = "name", nullable = false, length = 25)
    private String name;

    @Column(name = "document", nullable = false, length = 25)
    private String document;

 
    @Column(name = "email", nullable = false, length = 60)
    private String email;

    @Column(name = "phone", nullable = false, length = 60)
    private String phone;

    @Column(name = "username", nullable = false, length = 60)
    private String username;

    @Column(name = "clave", nullable = false, length = 60)
    private String clave;

    @ManyToOne
    @JoinColumn(name = "id_rol" , foreignKey = @ForeignKey(name = "FK_rol"))
    private Rol rol;
    
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)    
    private List<FrecuentIncidence> frecuenceincidents;
    
    @OneToMany(mappedBy = "userClient", fetch = FetchType.LAZY)    
    private List<Ticket> ticketsClient;
    
    @OneToMany(mappedBy = "user",  fetch = FetchType.LAZY)    
    private List<Comment> comments;
    
    @OneToMany(mappedBy = "user",  fetch = FetchType.LAZY)    
    private List<Response> responses;

	
	public User() {
		
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	//@JsonManagedReference(value="DefaultUser")
	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}
	@JsonBackReference(value = "defaultUser")
	public List<FrecuentIncidence> getFrecuenceincidents() {
		return frecuenceincidents;
	}

	public void setFrecuenceincidents(List<FrecuentIncidence> frecuenceincidents) {
		this.frecuenceincidents = frecuenceincidents;
	}

	@JsonBackReference(value="defailtClient")
	public List<Ticket> getTicketsClient() {
		return ticketsClient;
	}

	public void setTicketsClient(List<Ticket> ticketsClient) {
		this.ticketsClient = ticketsClient;
	}
	@JsonIgnore
	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public List<Response> getResponses() {
		return responses;
	}

	public void setResponses(List<Response> responses) {
		this.responses = responses;
	}
    
    
}