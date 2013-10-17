package org.visico.revitaplan.revitaassist.client.gui.composite;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
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
	
	int projectId;
	

	public ProjectInfoWidget()
	{
		name_lbl = new Label();
		
		stage_lbl = new Label();
		description_lbl = new Label();
		
		labelPanel.setStyleName("projectInfoPanel");
		labelPanel.add(name_lbl);
		labelPanel.add(stage_lbl);
		labelPanel.add(description_lbl);
		
		name_lbl.addStyleName("projectInfoTitle");
		stage_lbl.addStyleName("projectInfoStage");
		description_lbl.addStyleName("projectInfoDescription");
		
		mainPanel.setWidget(0, 0, labelPanel);
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
		
		
	}


	public int getProjectId() {
		return projectId;
	}


	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}


	

}
