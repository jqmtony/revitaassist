package org.visico.revitaplan.revitaassist.client.gui.composite;

import com.google.gwt.i18n.client.Constants;


public interface RevitaAssistConstants extends Constants {
	  @DefaultStringValue("Name")
	  String name();

	  @DefaultStringValue("Password")
	  String pass();

	  @DefaultStringValue("Login")
	  String login();
	  
	  @DefaultStringValue("Login successful!")
	  String loginsuccess();
	  
	  @DefaultStringValue("Login fail. Please check user name and password!")
	  String loginfailure();

}
