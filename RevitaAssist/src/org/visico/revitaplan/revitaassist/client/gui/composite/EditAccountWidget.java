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

public class EditAccountWidget extends DataComposite implements ClickHandler {

	RevitaAssistConstants constants = GWT.create(RevitaAssistConstants.class);
	
	
	VerticalPanel mainPanel = new VerticalPanel();
	TextBox name_tbx = new TextBox();
	TextBox email_tbx = new TextBox();
	TextBox organization_tbx = new TextBox();
	TextBox function_tbx = new TextBox();
	
	RadioButton english_rbt;
	RadioButton dutch_rbt;
	RadioButton german_rbt;
	
	Button change_btn; 
	Button cancel_btn;
	Button changePass_btn;
	
	public EditAccountWidget()
	{
		Label caption = new Label(constants.editUsers());
		caption.setStyleName("centerCaption");
		mainPanel.add(caption);
		
		VerticalPanel general_pnl = new VerticalPanel();
		general_pnl.setStyleName("boundedVPanel");
		
		Grid general_grd = new Grid(4,2);
		
		
		general_grd.setWidget(0, 0,new Label(constants.username()));
		general_grd.setWidget(0, 1, name_tbx);
		
		general_grd.setWidget(1, 0, new Label(constants.email()));
		general_grd.setWidget(1, 1, email_tbx);
		
		general_grd.setWidget(2, 0, new Label(constants.organization()));
		general_grd.setWidget(2, 1, organization_tbx);
		
		general_grd.setWidget(3, 0, new Label(constants.function()));
		general_grd.setWidget(3, 1, function_tbx);
		
		general_pnl.add(general_grd);
		
		mainPanel.add(general_pnl);
		
		VerticalPanel language_pnl = new VerticalPanel();
		language_pnl.setStyleName("boundedVPanel");
		Label language_lbl = new Label(constants.language());
		language_lbl.setStyleName("titleLabel");
		language_pnl.add(language_lbl);
		
		english_rbt = new RadioButton("languageSelectGroup", constants.English());
		dutch_rbt = new RadioButton("languageSelectGroup", constants.Dutch());;
		german_rbt = new RadioButton("languageSelectGroup", constants.German());;
		
		language_pnl.add(english_rbt);
		language_pnl.add(dutch_rbt);
		language_pnl.add(german_rbt);
		mainPanel.add(language_pnl);
	
		
		HorizontalPanel button_pnl = new HorizontalPanel();
		change_btn = new Button(constants.changeuser());
		
		change_btn.setWidth("12em");
		change_btn.addClickHandler(this);
		cancel_btn = new Button(constants.cancel());
		cancel_btn.setWidth("12em");
		cancel_btn.addClickHandler(this);
		button_pnl.add(change_btn);
		button_pnl.add(cancel_btn);
		mainPanel.add(button_pnl);
		
		initWidget(mainPanel);
	}

	@Override
	public void onClick(ClickEvent event) {
		if (event.getSource() == change_btn)
		{
			AppControlMediator.getInstance().changeUserSettings();
			AppControlMediator.getInstance().removeUserSettings();
			
		}
		else if (event.getSource() == cancel_btn)
		{
			AppControlMediator.getInstance().removeUserSettings();
		}
		
		
	}

	public String getName()
	{
		return name_tbx.getValue();
	}
	
	public void setName(String name)
	{
		name_tbx.setValue(name);
	}
	
	public String getEmail()
	{
		return email_tbx.getValue();
	}

	public void setEmail(String email)
	{
		email_tbx.setValue(email);
	}
	
	public String getOrganization()
	{
		return organization_tbx.getValue();
	}

	public void setOrganization(String organization)
	{
		organization_tbx.setValue(organization);
	}
	
	public String getFunction()
	{
		return function_tbx.getValue();
	}

	public void setFunction(String function)
	{
		function_tbx.setValue(function);
	}
	
	public String getLanguage()
	{
		if (dutch_rbt.isEnabled())
			return "nl";
		else if (german_rbt.isEnabled())
			return "de";
		else
			return "en";
	}
	
	public void setLanguage(String language)
	{
		if (language.equals("nl"))
				dutch_rbt.setValue(true);
		else if (language.equals("de"))
				german_rbt.setValue(true);
		else
			english_rbt.setValue(true);
	}
}
