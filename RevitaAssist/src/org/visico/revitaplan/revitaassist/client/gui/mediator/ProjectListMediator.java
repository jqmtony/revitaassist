package org.visico.revitaplan.revitaassist.client.gui.mediator;

import org.visico.revitaplan.revitaassist.client.gui.composite.AddProjectWidget;
import org.visico.revitaplan.revitaassist.client.gui.composite.ProjectInfoWidget;
import org.visico.revitaplan.revitaassist.client.gui.composite.ProjectListWidget;
import org.visico.revitaplan.revitaassist.client.gui.service.ProjectListService;
import org.visico.revitaplan.revitaassist.client.gui.service.ProjectListServiceAsync;
import org.visico.revitaplan.revitaassist.shared.gui.data.LoginData;
import org.visico.revitaplan.revitaassist.shared.gui.data.ProjectData;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class ProjectListMediator {

	
	private ProjectListServiceAsync service = GWT.create(ProjectListService.class);
	
	private AddProjectWidget addProjectWidget = null;
	private ProjectListWidget projectListWidget = null;
	
	
	public ProjectListMediator(String user)
	{
		
	}
	
	private void drawWidgets()
	{
		if (projectListWidget == null)
			throw new NullPointerException("projectListWidget needs to be set first before widget can be drawn");
		
		VerticalPanel panel = new VerticalPanel();
		
		for (int i=0; i<5; i++)
		{
			ProjectInfoWidget w = new ProjectInfoWidget();
			w.setName("project " + i);
			w.setStage("Initiation");
			w.setDescription("stupid test");
			
			projectListWidget.addProjectInfoWidget(w);
		}
		
		panel.add(projectListWidget);
		
		RootPanel.get("content").clear();
		RootPanel.get("content").add(panel);	
	}
	
	
	
	public void setAddProjectWidget(AddProjectWidget addProjectWidget) {
		this.addProjectWidget = addProjectWidget;
	}

	public void setProjectListWidget(ProjectListWidget projectListWidget) {
		this.projectListWidget = projectListWidget;
		drawWidgets();
	}

	public void addProject()
	{
		if (projectListWidget == null)
			throw new NullPointerException("no active addProjectWidget existsing - project cannot be added");
	
		ProjectData pd = new ProjectData();
		pd.setName(addProjectWidget.getProjectName());
		pd.setDescription(addProjectWidget.getDescription());
		pd.setStage(addProjectWidget.getStage());
			
		AsyncCallback<String> callback = new AsyncCallback<String>()
		{

			@Override
			public void onFailure(Throwable caught) {
				
			}

			@Override
			public void onSuccess(String result) {
					Window.alert(result);
				}
			
		};
				
		service.addProject(pd, callback);
	}


	public void removeAddProjectWidget() {
		addProjectWidget = null;
		
	}
	
}
