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
	
	
	

}
