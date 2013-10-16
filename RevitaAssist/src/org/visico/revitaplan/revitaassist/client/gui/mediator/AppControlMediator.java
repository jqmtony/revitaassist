package org.visico.revitaplan.revitaassist.client.gui.mediator;

import org.visico.revitaplan.revitaassist.client.gui.composite.AddProjectWidget;
import org.visico.revitaplan.revitaassist.client.gui.composite.ChangePasswordWidget;
import org.visico.revitaplan.revitaassist.client.gui.composite.EditAccountWidget;
import org.visico.revitaplan.revitaassist.client.gui.composite.LoginWidget;
import org.visico.revitaplan.revitaassist.client.gui.composite.ProjectListWidget;
import org.visico.revitaplan.revitaassist.client.gui.composite.RevitaAssistConstants;
import org.visico.revitaplan.revitaassist.client.gui.composite.UserWidget;
import org.visico.revitaplan.revitaassist.client.gui.service.LoginService;
import org.visico.revitaplan.revitaassist.client.gui.service.LoginServiceAsync;
import org.visico.revitaplan.revitaassist.client.gui.service.ProjectListService;
import org.visico.revitaplan.revitaassist.client.gui.service.ProjectListServiceAsync;
import org.visico.revitaplan.revitaassist.shared.gui.data.LoginData;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class AppControlMediator {
	
	static private AppControlMediator instance;
	private LoginServiceAsync service = GWT.create(LoginService.class);
	RevitaAssistConstants constants = GWT.create(RevitaAssistConstants.class);
	
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
	private EditAccountWidget editAccountWidget;
	private ChangePasswordWidget changePasswordWidget;
	private UserWidget userWidget;
	
	

	public LoginData getLoginData() {
		return loginData;
	}


	public void setLoginData(LoginData loginData) {
		this.loginData = loginData;
	}

	public void drawLogin() {
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
		userWidget = new UserWidget(loginData.getName(), this);
		VerticalPanel panel = new VerticalPanel();
		panel.setStyleName("vcenterPanelRight");
		panel.add(userWidget);
		RootPanel.get("login").clear();
		RootPanel.get("login").add(panel);
	}
	
	private void removeUserWidget() {
		RootPanel.get("login").clear();
	}

	public void drawUserSettings()
	{
		PopupPanel add_dlg = new PopupPanel();
		add_dlg.setGlassEnabled(true);
		add_dlg.setStyleName("popup");
		this.editAccountWidget = new EditAccountWidget();
		editAccountWidget.setName(loginData.getName());
		editAccountWidget.setEmail(loginData.getEmail());
		editAccountWidget.setOrganization(loginData.getOrganization());
		editAccountWidget.setFunction(loginData.getFunction());
		editAccountWidget.setLanguage(loginData.getLanguage());
		add_dlg.add(editAccountWidget);
		add_dlg.center();
	}
	
	public void removeUserSettings()
	{
		PopupPanel parentPanel = (PopupPanel)editAccountWidget.getParent();
		parentPanel.hide();
		editAccountWidget = null;	
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


	public void changeUserSettings() {
		loginData.setName(editAccountWidget.getName());
		loginData.setEmail(editAccountWidget.getEmail());
		loginData.setFunction(editAccountWidget.getFunction());
		loginData.setOrganization(editAccountWidget.getOrganization());
		loginData.setLanguage(editAccountWidget.getLanguage());
		
		AsyncCallback<LoginData>callback = new AsyncCallback<LoginData>()
				{

					@Override
					public void onFailure(Throwable caught) {
						
					}

					@Override
					public void onSuccess(LoginData result) {
							Window.alert(constants.changeduser());
					}
					
				};
						
		service.changeUser(loginData, callback);
		
		removeUserWidget();
		drawUserWidget();
	}

	public void changePassword(String password)  {
		AsyncCallback<Integer>callback = new AsyncCallback<Integer>()
				{

					@Override
					public void onFailure(Throwable caught) {
						
					}

					@Override
					public void onSuccess(Integer result) {
							Window.alert(constants.changedpassword());
					}
					
				};
						
			service.changePassword(loginData.getDatabaseId(), password, callback);
	}


	public void drawChangePassword() {
		PopupPanel add_dlg = new PopupPanel();
		add_dlg.setGlassEnabled(true);
		add_dlg.setStyleName("popup");
		changePasswordWidget = new ChangePasswordWidget();
		add_dlg.add(changePasswordWidget);
		add_dlg.center();
	}
	
	public void removeChangePassword()
	{
		PopupPanel parentPanel = (PopupPanel)changePasswordWidget.getParent();
		parentPanel.hide();
		changePasswordWidget = null;	
	}
	

	
}
