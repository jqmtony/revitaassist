package org.visico.revitaplan.revitaassist.shared.gui.data;

import java.io.Serializable;

public class LoginData implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2149545519189020474L;
	
	private String email = "JoeDoe@doe.com";
	private String password = "pass";
	private String sessionId = null;
	private String name = "Joe";
	private String organization = "Sieman";
	private String function = "Captain";
	private String language = "en";
	private int databaseId;
	
	private boolean loggedin = false;
	
	public boolean isLoggedin() {
		return loggedin;
	}

	public void setLoggedin(boolean loggedin) {
		this.loggedin = loggedin;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String user) {
		this.email = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean loginSuccess() {
		return loggedin;
	}

	public void setSessionId(String id) {
		sessionId = id;
		
	}
	
	public String getSessionId() {
		return sessionId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
	}

	public int getDatabaseId() {
		return databaseId;
	}

	public void setDatabaseId(int databaseId) {
		this.databaseId = databaseId;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	

	

}
