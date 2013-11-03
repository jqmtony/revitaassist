package org.visico.revitaplan.maturitydb.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "QUESTION")
public class Question {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	int id;
	
	@Column(name="english")
	String english;
	
	@Column(name="german")
	String german;
	
	@Column(name="dutch")
	String dutch;
	
	@Column(name= "format")
	String format;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEnglish() {
		return english;
	}

	public void setEnglish(String english) {
		this.english = english;
	}

	public String getGerman() {
		return german;
	}

	public void setGerman(String german) {
		this.german = german;
	}

	public String getDutch() {
		return dutch;
	}

	public void setDutch(String dutch) {
		this.dutch = dutch;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}
	
	
}
