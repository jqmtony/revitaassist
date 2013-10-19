package org.visico.revitaplan.revitaassist.client.gui.service;

import java.util.ArrayList;

import org.visico.revitaplan.revitaassist.shared.gui.data.LoginData;
import org.visico.revitaplan.revitaassist.shared.gui.data.ProjectFullData;
import org.visico.revitaplan.revitaassist.shared.gui.data.ProjectSummaryData;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("projectList")
public interface ProjectService extends RemoteService {
	
	String addProject(ProjectSummaryData data, LoginData login) throws IllegalArgumentException;
	
	ArrayList<ProjectSummaryData> getProjectList(String userEmail) throws IllegalArgumentException;
	
	Boolean archiveProject(int selectedProject) throws IllegalArgumentException;
	
	ProjectFullData getProject(String email, int projectid)
			throws IllegalArgumentException;
}
