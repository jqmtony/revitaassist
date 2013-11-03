package org.visico.revitaplan.revitaassist.client.gui.composite;

import com.google.gwt.i18n.client.Constants;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.user.client.ui.Button;


public interface RevitaAssistConstants extends Constants {
	  @DefaultStringValue("Email")
	  String email();

	  @DefaultStringValue("Password")
	  String pass();

	  @DefaultStringValue("Change Password")
	  String changepass();
	  
	  @DefaultStringValue("Login")
	  String login();
	  
	  @DefaultStringValue("Logout")
	  String logout();
	  
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
	  
	  @DefaultStringValue("Project Name")
	  String projectName();
	  
	  @DefaultStringValue("Set Stage Project is in:")
	  String setStage();
	  
	  @DefaultStringValue("Initiation Stage	")
	  String initiationStage();
	  
	  @DefaultStringValue("Conception Stage	")
	  String conceptionStage();
	  
	  @DefaultStringValue("Specification Stage	")
	  String specificationStage();
	  
	  @DefaultStringValue("Project Management Stage	")
	  String projectmgtStage();
	  
	  @DefaultStringValue("Project Description	")
	  String projectDescription();
	  
	  @DefaultStringValue("Cancel")
	  String cancel();
	  
	  @DefaultStringValue("Select Project")
	  String selectProject();
	  
	  @DefaultStringValue("Account Settings")
	  String accountSettings();
	  
	  @DefaultStringValue("Organization")
	  String organization();

	  @DefaultStringValue("Function")
	  String function();

	  @DefaultStringValue("Language")
	  String language();

	  @DefaultStringValue("English")
	  String English();

	  @DefaultStringValue("Dutch")
	  String Dutch();

	  @DefaultStringValue("German")
	  String German();

	  @DefaultStringValue("Verify Password")
	  String verify();
	  
	  @DefaultStringValue("Change User Settings")
	  String changeuser();

	  @DefaultStringValue("User Name")
	  String username();

	  @DefaultStringValue("Changed User Settings")
	  String changeduser();

	  @DefaultStringValue("Changed Password")
	  String changedpassword();

	  @DefaultStringValue("Passwords are different")
	  String differentpasswords();

	  @DefaultStringValue("Archive")
	  String archiveProject();

	  @DefaultStringValue("Are you sure you want to archive the selected project? " +
	  		"After archiving it can only be restored by the website manager!")
	  String reallyArchive();

	  @DefaultStringValue("Back to Project List")
	  String back();

	  @DefaultStringValue("Assess Maturity")
	  String maturity();

	  @DefaultStringValue("Stakeholder Analysis")
	  String stakeholder();
	  
	  @DefaultStringValue("Formalize Process")
	  String process();
	  
	  @DefaultStringValue("Sketch Planning")
	  String sketch();
}
