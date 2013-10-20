package org.visico.revitaplan.revitaassist.client.gui.mediator;

import java.util.ArrayList;

import org.visico.revitaplan.revitaassist.client.gui.composite.ProjectDetailWidget;
import org.visico.revitaplan.revitaassist.client.gui.composite.ProjectInfoWidget;
import org.visico.revitaplan.revitaassist.client.gui.service.ProjectService;
import org.visico.revitaplan.revitaassist.client.gui.service.ProjectServiceAsync;
import org.visico.revitaplan.revitaassist.shared.gui.data.LoginData;
import org.visico.revitaplan.revitaassist.shared.gui.data.ProjectFullData;
import org.visico.revitaplan.revitaassist.shared.gui.data.ProjectSummaryData;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class ProjectDetailMediator {

	ProjectDetailWidget projectDetailWidget = null;
	ProjectFullData projectData = null;
	int projectId; 
	private ProjectServiceAsync service = GWT.create(ProjectService.class);
	
	public ProjectDetailMediator(int projectId)
	{
		this.projectId = projectId;
		getProjectData();
	}
	
	private void drawWidgets()
	{
		if (projectDetailWidget == null)
			throw new NullPointerException("projectListWidget needs to be set first before widget can be drawn");
		
		VerticalPanel panel = new VerticalPanel();
		panel.add(projectDetailWidget);
		
		RootPanel.get("content").clear();
		RootPanel.get("content").add(panel);	
	}

	public void setProjectDetailWidget(ProjectDetailWidget projectDetailWidget) {
		this.projectDetailWidget = projectDetailWidget;
		drawWidgets();
	}
	
	public void setProjectInfoWidget()
	{
		if (projectData == null)
			throw new NullPointerException("projectData null - no project assigned yet");
		
		
		
		ProjectInfoWidget projectInfoWidget = new ProjectInfoWidget();
		projectInfoWidget.setName(projectData.getName());
		projectInfoWidget.setStage(projectData.getStage());
		projectInfoWidget.setDescription(projectData.getDescription());
		projectInfoWidget.setProjectId(projectData.getDatabaseid());
		
		projectDetailWidget.addProjectInfoWidget(projectInfoWidget);
	}
	
	private void getProjectData()
	{
		
		AsyncCallback<ProjectFullData> callback = new AsyncCallback<ProjectFullData>()
		{

			@Override
			public void onFailure(Throwable caught) {
				
			}

			@Override
			public void onSuccess(ProjectFullData result) {
				projectData = result;
				setProjectInfoWidget();
			}
			
		};
				
		LoginData ld = AppControlMediator.getInstance().getLoginData();
		if (ld == null)
			throw new NullPointerException("no valid user logged in");
		
		service.getProject(ld.getEmail(), projectId, callback);
	}
	
}
