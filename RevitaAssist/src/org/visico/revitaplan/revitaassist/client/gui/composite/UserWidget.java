package org.visico.revitaplan.revitaassist.client.gui.composite;

import org.visico.revitaplan.revitaassist.client.gui.mediator.AppControlMediator;
import org.visico.revitaplan.revitaassist.shared.gui.data.LoginData;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.HorizontalPanel;

public class UserWidget extends DataComposite implements ClickHandler {
	AppControlMediator mediator; 
	
	HorizontalPanel mainPanel = new HorizontalPanel();
	
	Button settings_btn = new Button("Account Settings");
	Button logout_btn = new Button("Logout");
	
	
	public UserWidget(LoginData data, AppControlMediator mediator)
	{
		this.mediator = mediator;
		
		mainPanel.setStyleName("UserTable");
		
		Label user_lbl = new Label(data.getName());
		user_lbl.setStyleName("UserLabel");
		mainPanel.add(user_lbl);
		
		settings_btn.setStyleName("normalButton");
		mainPanel.add(settings_btn);
		settings_btn.addClickHandler(this);
		
		logout_btn.setStyleName("normalButton");
		mainPanel.add(logout_btn);
		logout_btn.addClickHandler(this);
		
		initWidget(mainPanel);
	}
	
	@Override
	public void onClick(ClickEvent event) {
		if (event.getSource() == settings_btn)
		{
			
		}
		else if (event.getSource() == logout_btn)
		{
			AppControlMediator.getInstance().endSession();
		}
		
	}

}
