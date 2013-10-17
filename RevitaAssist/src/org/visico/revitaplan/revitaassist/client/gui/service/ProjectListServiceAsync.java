package org.visico.revitaplan.revitaassist.client.gui.service;

import java.util.ArrayList;

import org.visico.revitaplan.revitaassist.shared.gui.data.LoginData;
import org.visico.revitaplan.revitaassist.shared.gui.data.ProjectData;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface ProjectListServiceAsync {
	void addProject(ProjectData data, LoginData login, AsyncCallback<String> callback)
			throws IllegalArgumentException;
	
	 void getProjectList(String userEmail, AsyncCallback<ArrayList<ProjectData>> callback) 
			 throws IllegalArgumentException;

	void archiveProject(int selectedProject, AsyncCallback<Boolean> callback) 
			throws IllegalArgumentException;
}
