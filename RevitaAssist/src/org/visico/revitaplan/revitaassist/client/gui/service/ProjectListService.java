package org.visico.revitaplan.revitaassist.client.gui.service;

import java.util.ArrayList;

import org.visico.revitaplan.revitaassist.shared.gui.data.LoginData;
import org.visico.revitaplan.revitaassist.shared.gui.data.ProjectData;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("projectList")
public interface ProjectListService extends RemoteService {
	String addProject(ProjectData data) throws IllegalArgumentException;
	ArrayList<ProjectData> getProjectList(int userid) throws IllegalArgumentException;
}
