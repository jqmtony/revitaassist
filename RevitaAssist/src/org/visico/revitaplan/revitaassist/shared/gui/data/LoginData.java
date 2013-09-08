package org.visico.revitaplan.revitaassist.shared.gui.data;

import java.io.Serializable;

public class LoginData implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2149545519189020474L;
	
	public String user = "Joe Doe";
	public String password = "pass";
	
	private boolean loggedin = false;
	
	

	public boolean isLoggedin() {
		return loggedin;
	}

	public void setLoggedin(boolean loggedin) {
		this.loggedin = loggedin;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
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
	
	

}
