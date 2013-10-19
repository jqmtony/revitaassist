package org.visico.revitaplan.revitaassist.client.gui.composite;

import org.visico.revitaplan.revitaassist.client.gui.mediator.ProjectDetailMediator;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.HTML;


public class ProjectDetailWidget extends DataComposite implements ClickHandler {

	ProjectDetailMediator mediator;
	DockLayoutPanel mainPanel;
	
	
	public ProjectDetailWidget(ProjectDetailMediator mediator)
	{
		mainPanel = new DockLayoutPanel(Unit.PX);
		mainPanel.setStyleName("projectDetail");
			
		initWidget(mainPanel);
	}
	
	public void addProjectInfoWidget(ProjectInfoWidget projectInfoWidget)
	{
		mainPanel.addNorth(projectInfoWidget, 100);
	}
	
	
	@Override
	public void onClick(ClickEvent event) {
		// TODO Auto-generated method stub
		
	}

}
