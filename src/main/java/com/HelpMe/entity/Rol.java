package com.HelpMe.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name = "rol")
public class Rol {
	@Id    
    private Integer id;
    
    @Column(name = "nombre", nullable = false, length = 25)
    private String nombre;        
   
    
    @OneToMany(mappedBy = "rol", orphanRemoval = true, fetch = FetchType.LAZY)    
    private List<User> users;

	public Rol(Integer id, String nombre, List<User> users) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.users = users;
	}

	public Rol() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@JsonBackReference
	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	
    
    
}
