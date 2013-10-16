package org.visico.revitaplan.revitaassist.client.gui.composite;

import org.visico.revitaplan.revitaassist.client.gui.mediator.AppControlMediator;
import org.visico.revitaplan.revitaassist.shared.gui.data.LoginData;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.MenuItem;

public class UserWidget extends DataComposite {
	RevitaAssistConstants constants = GWT.create(RevitaAssistConstants.class);
	
	AppControlMediator mediator; 
	
	HorizontalPanel mainPanel = new HorizontalPanel();
	private MenuBar userMenu;
	
	
	public UserWidget(String userName, AppControlMediator mediator)
	{
		this.mediator = mediator;
		
		mainPanel.setStyleName("UserTable");
		
		userMenu = new MenuBar();
		userMenu.setStyleName("login-MenuBar");
		MenuBar subMenu = new MenuBar(true);
		
		userMenu.addItem(userName, subMenu);
		
		MenuItem settings = new MenuItem(constants.accountSettings(), 
				new Command()
				{
					@Override
					public void execute() {
						AppControlMediator.getInstance().drawUserSettings();			
					}
					
				});
		
		MenuItem changePassword = new MenuItem(constants.changepass(), 
				new Command()
				{
					@Override
					public void execute() {
						AppControlMediator.getInstance().drawChangePassword();			
					}
					
				});
		
		MenuItem logout = new MenuItem(constants.logout(), 
				new Command()
				{
					@Override
					public void execute() {
						AppControlMediator.getInstance().endSession();	
					}
					
				});
		
		subMenu.addItem(settings);
		subMenu.addItem(changePassword);
		subMenu.addItem(logout);
		
		mainPanel.add(userMenu);
		initWidget(mainPanel);
	}
	
	
}
