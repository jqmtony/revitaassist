package org.visico.revitaplan.revitaassist.client.gui.service;

import java.util.ArrayList;

import org.visico.revitaplan.revitaassist.shared.gui.data.LoginData;
import org.visico.revitaplan.revitaassist.shared.gui.data.ProjectFullData;
import org.visico.revitaplan.revitaassist.shared.gui.data.ProjectSummaryData;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface ProjectServiceAsync {
	void addProject(ProjectSummaryData data, LoginData login, AsyncCallback<String> callback)
			throws IllegalArgumentException;
	
	 void getProjectList(String userEmail, AsyncCallback<ArrayList<ProjectSummaryData>> callback) 
			 throws IllegalArgumentException;

	void archiveProject(int selectedProject, AsyncCallback<Boolean> callback) 
			throws IllegalArgumentException;

	void getProject(String email, int projectId, AsyncCallback<ProjectFullData> callback)
			throws IllegalArgumentException;
}
