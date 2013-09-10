package org.visico.revitaplan.revitaassist.client.gui.composite;

import org.visico.revitaplan.revitaassist.client.gui.service.LoginService;
import org.visico.revitaplan.revitaassist.client.gui.service.LoginServiceAsync;
import org.visico.revitaplan.revitaassist.shared.gui.data.LoginData;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class LoginWidget extends DataComposite implements ClickHandler{
	LoginData data;
	private LoginServiceAsync service = GWT.create(LoginService.class);
	
	RevitaAssistConstants constants;
	VerticalPanel mainPanel = new VerticalPanel();
	
	TextBox name_tb = new TextBox();
	PasswordTextBox pass_tb = new PasswordTextBox();
	Button login_btn = new Button();
	
	public LoginWidget()
	{
		data = new LoginData();
		constants = GWT.create(RevitaAssistConstants.class);
		
		mainPanel.setSize("20em", "5em");
		mainPanel.setStyleName("boundedVPanel");
		
		Grid login_grd = new Grid(2,2);
		login_grd.setText(0, 0, constants.email());
		login_grd.setWidget(0, 1, name_tb);
		
		login_grd.setText(1, 0, constants.pass());
		login_grd.setWidget(1, 1, pass_tb);
		mainPanel.add(login_grd);
		
		login_btn.setText(constants.login());
		login_btn.setSize("19em", "2em");
		login_btn.addClickHandler(this);
		mainPanel.add(login_btn);
		
		initWidget(mainPanel);
	}

	@Override
	public void onClick(ClickEvent event) {
		data.setPassword(pass_tb.getValue());
		data.setEmail(name_tb.getValue());
		
		AsyncCallback<LoginData> callback = new AsyncCallback<LoginData>()
		{

			@Override
			public void onFailure(Throwable caught) {
				
			}

			@Override
			public void onSuccess(LoginData result) {
				data = result;
				if (data.loginSuccess())
				{
					Window.alert(constants.loginsuccess());
				}
				else
				{
					Window.alert(constants.loginfailure());
				}
			}
			
		};
		
		service.verifyUser(data, callback);
	}
}
