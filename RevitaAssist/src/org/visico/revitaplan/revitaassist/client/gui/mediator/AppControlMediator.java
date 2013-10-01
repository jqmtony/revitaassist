package org.visico.revitaplan.revitaassist.client.gui.mediator;

import org.visico.revitaplan.revitaassist.client.gui.composite.LoginWidget;
import org.visico.revitaplan.revitaassist.client.gui.composite.ProjectListWidget;
import org.visico.revitaplan.revitaassist.client.gui.composite.UserWidget;
import org.visico.revitaplan.revitaassist.shared.gui.data.LoginData;

import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class AppControlMediator {
	
	static private AppControlMediator instance;
	
	static public AppControlMediator getInstance()
	{
		if (instance == null)
			instance = new AppControlMediator();
		return instance;
	}
	
	static public enum MODE
	{
		LOGIN,
		PROJECTLIST,
		PROJECT
	}
	
	private AppControlMediator()
	{
		
	}
	
	
	private LoginData loginData;
	
	
	

	private void drawProject() {
		// TODO Auto-generated method stub
		
	}


	private void drawLogin() {
		LoginMediator mediator = new LoginMediator();
		LoginWidget loginWidget = new LoginWidget();
		mediator.setLoginWidget(loginWidget);
		
	}
	
	public void drawProjectList()
	{
		ProjectListMediator mediator = new ProjectListMediator("Dummy");
		ProjectListWidget plw = new ProjectListWidget(mediator);
		mediator.setProjectListWidget(plw);
		
	}

	private void drawUserWidget() {
		UserWidget widget = new UserWidget(loginData, this);
		VerticalPanel panel = new VerticalPanel();
		panel.setStyleName("vcenterPanelRight");
		panel.add(widget);
		RootPanel.get("login").clear();
		RootPanel.get("login").add(panel);
	}
	
	private void removeUserWidget() {
		RootPanel.get("login").clear();
	}

	
	public void startSession(LoginData data) {
		this.loginData = data;
		drawProjectList();
		drawUserWidget();
	}

	public void endSession()  {
		this.loginData = null;
		drawLogin();
		removeUserWidget();
	}


	
}
