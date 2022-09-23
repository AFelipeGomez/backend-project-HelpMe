package com.HelpMe.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "frecuent_incidence")
public class FrecuentIncidence {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="dateActual", nullable=false)
	private Date dateActual;	

	@Column(name = "title", nullable = false, length = 250)
	private String title;

	@Column(name = "description", nullable = false, length = 250)
	private String description;

	@Column(name = "answer", nullable = false, length = 500)
	private String answer;
	
	@Column(name = "file", nullable = false, length = 250)
	private String file;
	
	@ManyToOne
    @JoinColumn(name = "id_users")
    private User user;
	
	@OneToMany(mappedBy = "frecuentIncidence", orphanRemoval = true, cascade = CascadeType.ALL)    
    private List<KeyWords> keyWords;
	

	
	//@JsonManagedReference(value = "defaultUser")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@JsonManagedReference(value = "defaultReference")
	public List<KeyWords> getKeyWords() {
		return keyWords;
	}

	public void setKeyWords(List<KeyWords> keyWords) {
		this.keyWords = keyWords;
	}

	public FrecuentIncidence(Integer id, Date dateActual, String title, String description, String answer, String file,
			User user, List<KeyWords> keyWords) {
		super();
		this.id = id;
		this.dateActual = dateActual;
		this.title = title;
		this.description = description;
		this.answer = answer;
		this.file = file;
		this.user = user;
		this.keyWords = keyWords;
	}

	public FrecuentIncidence() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDateActual() {
		return dateActual;
	}

	public void setDateActual(Date dateActual) {
		this.dateActual = dateActual;
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

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	

	
	 
	
}
