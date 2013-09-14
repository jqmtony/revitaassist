package org.visico.revitaplan.revitaassist.client.gui.mediator;

import org.visico.revitaplan.revitaassist.client.gui.composite.AddProjectWidget;
import org.visico.revitaplan.revitaassist.client.gui.composite.ProjectInfoWidget;
import org.visico.revitaplan.revitaassist.shared.gui.data.ProjectData;

public class ProjectSiteMediator {
	static ProjectSiteMediator instance = null;
	
	public static ProjectSiteMediator getInstance()
	{
		if (instance == null)
		{
			instance = new ProjectSiteMediator();
		}
		
		return instance;
	}
	
	
	ProjectData dataItem;
	
	// here add the widgets that need to be updated
	ProjectInfoWidget projectInfoWidget;
	AddProjectWidget addProjectWidget;
	
	private ProjectSiteMediator()
	{
		
	}
	
	public void setProjectData(ProjectData data)
	{
		dataItem = data;
	}
	
	public void addProjectInfoWidget(ProjectInfoWidget widget)
	{
		projectInfoWidget = widget;
		updateProjectInfoWidget();
	}
	
	public void addAddProjectWidget(AddProjectWidget widget)
	{
		addProjectWidget = widget;
	}
	
	private void updateProjectInfoWidget()
	{
		/*if (projectInfoWidget != null)
		{
			projectInfoWidget.setName(dataItem.getName());
			projectInfoWidget.setDescription(dataItem.getDescription());
			projectInfoWidget.setStage(dataItem.getStage());
		}*/
	}
}
