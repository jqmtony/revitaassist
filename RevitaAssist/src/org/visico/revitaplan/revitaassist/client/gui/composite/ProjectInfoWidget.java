package org.visico.revitaplan.revitaassist.client.gui.composite;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class ProjectInfoWidget extends DataComposite implements ClickHandler {

	RevitaAssistConstants constants = GWT.create(RevitaAssistConstants.class);
	
	Grid mainPanel = new Grid(1,2);
	
	VerticalPanel labelPanel = new VerticalPanel();;
	Label name_lbl;
	Label stage_lbl;
	Label description_lbl;
	
	VerticalPanel btnPanel = new VerticalPanel();
	
	Button addProject_btn = new Button(constants.addProject()); 
	Button deleteProject_btn = new Button(constants.deleteProject());
	Button changeStage_btn = new Button(constants.changeStage());
	Button editUsers_btn = new Button(constants.editUsers());
	Button newMaturityAss_btn = new Button(constants.assessMaturity());
	

	public ProjectInfoWidget()
	{
		name_lbl = new Label();
		stage_lbl = new Label();
		description_lbl = new Label();
		
		labelPanel.setStyleName("boundedVPanel");
		labelPanel.setHeight("12em");
		labelPanel.add(name_lbl);
		labelPanel.add(stage_lbl);
		labelPanel.add(description_lbl);
		name_lbl.addStyleName("captionLabel");
		mainPanel.setWidget(0, 0, labelPanel);
		
		btnPanel.setStyleName("boundedVPanel");
		btnPanel.setSize("10em", "12em");
		btnPanel.add(addProject_btn);
		addProject_btn.addClickHandler(this);
		addProject_btn.setStyleName("normalButton");
		btnPanel.add(deleteProject_btn);
		deleteProject_btn.addClickHandler(this);
		deleteProject_btn.setStyleName("normalButton");
		btnPanel.add(changeStage_btn);
		changeStage_btn.addClickHandler(this);
		changeStage_btn.setStyleName("normalButton");
		btnPanel.add(editUsers_btn);
		editUsers_btn.addClickHandler(this);
		editUsers_btn.setStyleName("normalButton");
		btnPanel.add(newMaturityAss_btn);
		newMaturityAss_btn.addClickHandler(this);
		newMaturityAss_btn.setStyleName("normalButton");
		mainPanel.setWidget(0, 1, btnPanel);
		
		initWidget(mainPanel);
	}
	
	
	public void setName(String name) {
		name_lbl.setText(name);
	}

	public void setDescription(String description) {
		description_lbl.setText(description);
		
	}

	public void setStage(String stage) {
		stage_lbl.setText(stage);
		
	}

	@Override
	public void onClick(ClickEvent event) {
		if (event.getSource() == addProject_btn)
		{
			Window.alert("TODO: Add Project Panel");
		}
		else if (event.getSource() == deleteProject_btn)
		{
			Window.alert("TODO: Delete Project and move to project list");
		}
		else if (event.getSource() == changeStage_btn)
		{
			Window.alert("TODO: change stage panel");
		}
		else if (event.getSource() == editUsers_btn)
		{
			Window.alert("TODO: edit users panel");
		}
		else if (event.getSource() == newMaturityAss_btn)
		{
			Window.alert("TODO: start new maturity model");
		}
		
	}

}
