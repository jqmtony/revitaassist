package org.visico.revitaplan.revitaassist.client.gui.composite;

import com.google.gwt.i18n.client.Constants;
import com.google.gwt.user.client.ui.Button;


public interface RevitaAssistConstants extends Constants {
	  @DefaultStringValue("Email")
	  String email();

	  @DefaultStringValue("Password")
	  String pass();

	  @DefaultStringValue("Login")
	  String login();
	  
	  @DefaultStringValue("Login successful!")
	  String loginsuccess();
	  
	  @DefaultStringValue("Login fail. Please check user name and password!")
	  String loginfailure();
	  
	  @DefaultStringValue("Add Project")
	  String addProject();
	  
	  @DefaultStringValue("Delete Project")
	  String deleteProject();
	  
	  @DefaultStringValue("Change Stage")
	  String changeStage();
	  
	  @DefaultStringValue("Edit Users")
	  String editUsers();

	  @DefaultStringValue("Assess Maturity")
	  String assessMaturity();
	  
}
