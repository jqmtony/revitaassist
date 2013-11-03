package org.visico.revitaplan.maturitydb.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "GROUPINGS")
public class Groupings {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	int id;
	
	@Column(name="firstquestion")
	int firstquestion;
	
	@Column(name="lastquestion")
	int lastquestion;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFirstquestion() {
		return firstquestion;
	}

	public void setFirstquestion(int firstquestion) {
		this.firstquestion = firstquestion;
	}

	public int getLastquestion() {
		return lastquestion;
	}

	public void setLastquestion(int lastquestion) {
		this.lastquestion = lastquestion;
	}
	
		
}
