package com.HelpMe.entity;

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
@Table(name="key_words")
public class KeyWords {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; 
	
	@Column(name="word",nullable = false, length = 50)
	private String word;
	
	@ManyToOne
    @JoinColumn(name = "id_frecuent_incidence")
	private FrecuentIncidence frecuentIncidence;
	
	

	public KeyWords() {
		super();
	}

	public KeyWords(Integer id, String word, FrecuentIncidence frecuentIncidence) {
		super();
		this.id = id;
		this.word = word;
		this.frecuentIncidence = frecuentIncidence;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	@JsonBackReference(value = "defaultReference")
	public FrecuentIncidence getFrecuentIncidence() {
		return frecuentIncidence;
	}

	public void setFrecuentIncidence(FrecuentIncidence frecuentIncidence) {
		this.frecuentIncidence = frecuentIncidence;
	}
	
	
}
