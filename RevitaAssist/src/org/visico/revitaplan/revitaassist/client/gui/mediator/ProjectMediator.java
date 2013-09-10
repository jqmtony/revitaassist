package org.visico.revitaplan.revitaassist.client.gui.mediator;

import org.visico.revitaplan.revitaassist.client.gui.composite.ProjectInfoWidget;
import org.visico.revitaplan.revitaassist.shared.gui.data.ProjectData;

public class ProjectMediator {
	ProjectData dataItem;
	
	// here add the widgets that need to be updated
	ProjectInfoWidget projectInfoWidget;
	
	public ProjectMediator(ProjectData data)
	{
		dataItem = data;
	}
	
	
	public void addProjectInfoWidget(ProjectInfoWidget widget)
	{
		projectInfoWidget = widget;
		updateProjectInfoWidget();
	}
	
	
	
	private void updateProjectInfoWidget()
	{
		if (projectInfoWidget != null)
		{
			projectInfoWidget.setName(dataItem.getName());
			projectInfoWidget.setDescription(dataItem.getDescription());
			projectInfoWidget.setStage(dataItem.getStage());
		}
	}
}
