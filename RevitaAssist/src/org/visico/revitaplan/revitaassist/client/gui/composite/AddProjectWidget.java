package org.visico.revitaplan.revitaassist.client.gui.composite;

import org.visico.revitaplan.revitaassist.client.gui.mediator.ProjectListMediator;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class AddProjectWidget extends DataComposite implements ClickHandler {

	RevitaAssistConstants constants = GWT.create(RevitaAssistConstants.class);
	
	ProjectListMediator mediator;
	
	VerticalPanel mainPanel = new VerticalPanel();
	TextBox name_tbx = new TextBox();
	TextArea description_tbx = new TextArea();
	
	RadioButton initiationStage_rbt;
	RadioButton conceptionStage_rbt;
	RadioButton specificationStage_rbt;
	RadioButton projectmgtStage_rbt;

	Button add_btn; 
	Button cancel_btn; 
	
	public AddProjectWidget(ProjectListMediator mediator)
	{
		this.mediator = mediator;
		
		HorizontalPanel name_pnl = new HorizontalPanel();
		name_pnl.setStyleName("boundedVPanel");
		name_pnl.add(new Label(constants.projectName()));
		name_pnl.add(name_tbx);
		mainPanel.add(name_pnl);
		
		VerticalPanel stage_pnl = new VerticalPanel();
		stage_pnl.setStyleName("boundedVPanel");
		Label stage_lbl = new Label(constants.setStage());
		stage_lbl.setStyleName("titleLabel");
		stage_pnl.add(stage_lbl);
		
		initiationStage_rbt = new RadioButton("stageSelectGroup", constants.initiationStage());
		conceptionStage_rbt = new RadioButton("stageSelectGroup", constants.conceptionStage());;
		specificationStage_rbt = new RadioButton("stageSelectGroup", constants.specificationStage());;
		projectmgtStage_rbt = new RadioButton("stageSelectGroup", constants.projectmgtStage());;
		
		stage_pnl.add(initiationStage_rbt);
		stage_pnl.add(conceptionStage_rbt);
		stage_pnl.add(specificationStage_rbt);
		stage_pnl.add(projectmgtStage_rbt);
		mainPanel.add(stage_pnl);
		
		VerticalPanel description_pnl = new VerticalPanel();
		description_pnl.setStyleName("boundedVPanel");
		description_pnl.add(new Label(constants.projectDescription()));
		description_tbx.setWidth("95%");
		description_tbx.setHeight("10em");
		description_pnl.add(description_tbx);
		mainPanel.add(description_pnl);
		
		HorizontalPanel button_pnl = new HorizontalPanel();
		add_btn = new Button(constants.addProject());
		
		add_btn.setWidth("12em");
		add_btn.addClickHandler(this);
		cancel_btn = new Button(constants.cancel());
		cancel_btn.setWidth("12em");
		cancel_btn.addClickHandler(this);
		button_pnl.add(add_btn);
		button_pnl.add(cancel_btn);
		mainPanel.add(button_pnl);
		
		initWidget(mainPanel);
	}

	@Override
	public void onClick(ClickEvent event) {
		if (event.getSource() == add_btn)
		{
			mediator.addProject();
			mediator.removeAddProjectWidget();
		}
		else if (event.getSource() == cancel_btn)
		{
			if (this.getParent().getParent() instanceof DialogBox)
			{
				DialogBox parent = (DialogBox)(this.getParent().getParent());
				parent.hide();
			}
			mediator.removeAddProjectWidget();
		}
	}

	public String getProjectName() {
		return name_tbx.getText();
	}

	public String getDescription() {
		return description_tbx.getText();
	}

	public String getStage() {
		String stage = "";
		
		if (initiationStage_rbt.getValue())
			stage = constants.initiationStage();
		else if (conceptionStage_rbt.getValue())
			stage = constants.conceptionStage();
		else if (specificationStage_rbt.getValue())
			stage = constants.specificationStage();
		else if (projectmgtStage_rbt.getValue())
			stage = constants.projectmgtStage();
		
		return stage;
	}

}
