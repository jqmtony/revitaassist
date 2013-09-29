package org.visico.revitaplan.revitaassist.client.gui.composite;

import org.visico.revitaplan.revitaassist.client.gui.mediator.ProjectListMediator;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class ProjectButtonsWidget extends DataComposite implements ClickHandler {

	RevitaAssistConstants constants = GWT.create(RevitaAssistConstants.class);
	
	ProjectListMediator mediator;
	
	Button addProject_btn = new Button(constants.addProject()); 
	Button deleteProject_btn = new Button(constants.deleteProject());
	Button changeStage_btn = new Button(constants.changeStage());
	Button editUsers_btn = new Button(constants.editUsers());
	Button newMaturityAss_btn = new Button(constants.assessMaturity());
	
	VerticalPanel btnPanel = new VerticalPanel();
	
	public void ProjectsButtonsWidget(ProjectListMediator mediator)
	{
		this.mediator = mediator;
		
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
		
		initWidget(btnPanel);
	}
	@Override
	public void onClick(ClickEvent event) {
		if (event.getSource() == addProject_btn)
		{
			DialogBox add_dlg = new DialogBox();
			add_dlg.add(new AddProjectWidget(mediator));
			add_dlg.show();
			
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
