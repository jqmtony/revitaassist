package org.visico.revitaplan.revitaassist.client.gui.composite;

import org.visico.revitaplan.revitaassist.client.gui.mediator.AppControlMediator;
import org.visico.revitaplan.revitaassist.client.gui.mediator.ProjectListMediator;
import org.visico.revitaplan.revitaassist.shared.gui.data.LoginData;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class ChangePasswordWidget extends DataComposite implements ClickHandler {

	RevitaAssistConstants constants = GWT.create(RevitaAssistConstants.class);
	
	
	VerticalPanel mainPanel = new VerticalPanel();
	
	PasswordTextBox password_tbx = new PasswordTextBox();
	PasswordTextBox verifypassword_tbx = new PasswordTextBox();
	
	
	Button cancel_btn;
	Button changePass_btn;
	
	public ChangePasswordWidget()
	{
		Label caption = new Label(constants.editUsers());
		caption.setStyleName("centerCaption");
		mainPanel.add(caption);
		
		VerticalPanel changepassword_pnl = new VerticalPanel();
		changepassword_pnl.setStyleName("boundedVPanel");
		changepassword_pnl.add(new Label(constants.changepass()));
		
		VerticalPanel password_pnl = new VerticalPanel();
		Label password_lbl = new Label(constants.pass());
		password_pnl.add(password_lbl);
		password_pnl.add(password_tbx);
		changepassword_pnl.add(password_pnl);
		
		VerticalPanel verify_pnl = new VerticalPanel();
		Label verify_lbl = new Label(constants.verify());
		verify_pnl.add(verify_lbl);
		verify_pnl.add(verifypassword_tbx);
		changepassword_pnl.add(verify_pnl);
		
		
		mainPanel.add(changepassword_pnl);
		
		HorizontalPanel button_pnl = new HorizontalPanel();
		
		changePass_btn = new Button(constants.changepass());
		changePass_btn.addClickHandler(this);
		changePass_btn.setWidth("12em");
		cancel_btn = new Button(constants.cancel());
		cancel_btn.setWidth("12em");
		cancel_btn.addClickHandler(this);
		button_pnl.add(changePass_btn);
		button_pnl.add(cancel_btn);
		mainPanel.add(button_pnl);
		
		initWidget(mainPanel);
	}

	@Override
	public void onClick(ClickEvent event) {
		if (event.getSource() == changePass_btn)
		{
			if (password_tbx.getValue().equals(verifypassword_tbx.getValue()))
				AppControlMediator.getInstance().changePassword(password_tbx.getValue());
			else
				Window.alert(constants.differentpasswords());
			AppControlMediator.getInstance().removeChangePassword();
		}
		else if (event.getSource() == cancel_btn)
		{
			AppControlMediator.getInstance().removeChangePassword();
		}
		
	}

	
}
