package org.visico.revitaplan.revitaassist.client.gui.mediator;

import org.visico.revitaplan.revitaassist.client.gui.composite.LoginWidget;
import org.visico.revitaplan.revitaassist.client.gui.composite.ProjectListWidget;

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
	
	
	private String sessionId;
	
	
	public void setMode(MODE newMode)
	{
		if (newMode == MODE.LOGIN)
		{
			drawLogin();
		}
		else if (newMode == MODE.PROJECTLIST)
		{
			drawProjectList();
		}
		else if (newMode == MODE.PROJECT)
		{
			drawProject();
		}
	}


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





	public void startSession(String sessionId) {
		this.sessionId = sessionId;
		drawProjectList();
		
	}
}
