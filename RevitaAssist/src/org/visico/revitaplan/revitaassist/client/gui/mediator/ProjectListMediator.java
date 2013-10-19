package org.visico.revitaplan.revitaassist.client.gui.mediator;

import java.util.ArrayList;

import org.visico.revitaplan.revitaassist.client.gui.composite.AddProjectWidget;
import org.visico.revitaplan.revitaassist.client.gui.composite.ProjectInfoWidget;
import org.visico.revitaplan.revitaassist.client.gui.composite.ProjectListWidget;
import org.visico.revitaplan.revitaassist.client.gui.service.ProjectService;
import org.visico.revitaplan.revitaassist.client.gui.service.ProjectServiceAsync;
import org.visico.revitaplan.revitaassist.shared.gui.data.LoginData;
import org.visico.revitaplan.revitaassist.shared.gui.data.ProjectSummaryData;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class ProjectListMediator {

	
	private ProjectServiceAsync service = GWT.create(ProjectService.class);
	
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
		
		fillProjectList();
		
		panel.add(projectListWidget);
		
		RootPanel.get("content").clear();
		RootPanel.get("content").add(panel);	
	}
	
	
	
	public void setAddProjectWidget() {
		PopupPanel add_dlg = new PopupPanel();
		add_dlg.setGlassEnabled(true);
		add_dlg.setStyleName("popup");
		AddProjectWidget addProjectWidget = new AddProjectWidget( this );
		this.addProjectWidget = addProjectWidget;
		add_dlg.add(addProjectWidget);
		add_dlg.center();
	}

	public void setProjectListWidget(ProjectListWidget projectListWidget) {
		this.projectListWidget = projectListWidget;
		drawWidgets();
	}

	public void addProject()
	{
		if (projectListWidget == null)
			throw new NullPointerException("no active addProjectWidget existsing - project cannot be added");
	
		ProjectSummaryData pd = new ProjectSummaryData();
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
				
		service.addProject(pd, AppControlMediator.getInstance().getLoginData(), callback);
	}

	public void fillProjectList()
	{
		if (projectListWidget == null)
			throw new NullPointerException("no active addProjectWidget existsing - project cannot be added");
		projectListWidget.clear();
		projectListWidget.resetSelectedRow();
		
		AsyncCallback<ArrayList<ProjectSummaryData>> callback = new AsyncCallback<ArrayList<ProjectSummaryData>>()
		{

			@Override
			public void onFailure(Throwable caught) {
				
			}

			@Override
			public void onSuccess(ArrayList<ProjectSummaryData> result) {
				projectListWidget.clear();
				for (ProjectSummaryData d : result)
				{
					ProjectInfoWidget w = new ProjectInfoWidget();
					w.setName(d.getName());
					w.setStage(d.getStage());
					w.setDescription(d.getDescription());
					w.setProjectId(d.getDatabaseid());
					projectListWidget.addProjectInfoWidget(w);
				}
				
			}
			
		};
				
		LoginData ld = AppControlMediator.getInstance().getLoginData();
		if (ld == null)
			throw new NullPointerException("no valid user logged in");
		
		service.getProjectList(ld.getEmail(), callback);
	}

	public void removeAddProjectWidget() {
		PopupPanel parentPanel = (PopupPanel)addProjectWidget.getParent();
		parentPanel.hide();
		addProjectWidget = null;
		
	}

	public void archiveProject() {
		if (projectListWidget == null)
			throw new NullPointerException("no active addProjectWidget existsing - project cannot be archived");
	
		
		AsyncCallback<Boolean> callback = new AsyncCallback<Boolean>()
		{

			@Override
			public void onFailure(Throwable caught) {
				
			}

			@Override
			public void onSuccess(Boolean result) {
				
			}
			
		};
				
		service.archiveProject(projectListWidget.getSelectedProject(), callback);
		
	}

	public void projectDetailWidget() {
		AppControlMediator.getInstance().drawProjectDetail(projectListWidget.getSelectedProject());
		
	}
	
}
