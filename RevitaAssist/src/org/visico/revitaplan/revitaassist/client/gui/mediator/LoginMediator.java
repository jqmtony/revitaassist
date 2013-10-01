package org.visico.revitaplan.revitaassist.client.gui.mediator;

import org.visico.revitaplan.revitaassist.client.gui.composite.LoginWidget;
import org.visico.revitaplan.revitaassist.client.gui.service.ProjectListService;
import org.visico.revitaplan.revitaassist.client.gui.service.ProjectListServiceAsync;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class LoginMediator {
	
	private LoginWidget loginWidget;
	
	public LoginMediator()
	{
		
	}

	public LoginWidget getLoginWidget() {
		return loginWidget;
	}

	public void setLoginWidget(LoginWidget loginWidget) {
		this.loginWidget = loginWidget;
		drawWidgets();
	}

	private void drawWidgets() {
		VerticalPanel panel = new VerticalPanel();
		panel.setStyleName("loginPanel");
		panel.add(loginWidget);
		RootPanel.get("content").clear();
		RootPanel.get("content").add(panel);	
	}
	
	

}
