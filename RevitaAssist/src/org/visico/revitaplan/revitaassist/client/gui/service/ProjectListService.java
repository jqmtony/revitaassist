package org.visico.revitaplan.revitaassist.client.gui.service;

import java.util.ArrayList;

import org.visico.revitaplan.revitaassist.shared.gui.data.LoginData;
import org.visico.revitaplan.revitaassist.shared.gui.data.ProjectData;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("projectList")
public interface ProjectListService extends RemoteService {
	
	String addProject(ProjectData data, LoginData login) throws IllegalArgumentException;
	
	ArrayList<ProjectData> getProjectList(String userEmail) throws IllegalArgumentException;
	
	Boolean archiveProject(int selectedProject) throws IllegalArgumentException;
}
