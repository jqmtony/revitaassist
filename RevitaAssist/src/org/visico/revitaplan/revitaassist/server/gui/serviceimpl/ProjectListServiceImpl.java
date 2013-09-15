package org.visico.revitaplan.revitaassist.server.gui.serviceimpl;

import java.util.ArrayList;

import org.visico.revitaplan.revitaassist.client.gui.service.LoginService;
import org.visico.revitaplan.revitaassist.client.gui.service.ProjectListService;
import org.visico.revitaplan.revitaassist.shared.gui.data.LoginData;
import org.visico.revitaplan.revitaassist.shared.gui.data.ProjectData;
import org.visico.userdb.dao.UserDao;
import org.visico.userdb.model.User;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class ProjectListServiceImpl extends RemoteServiceServlet implements ProjectListService {

	@Override
	public String addProject(ProjectData data) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return "TODO: Methods still needs to be implemented";
	}

	@Override
	public ArrayList<ProjectData> getProjectList(int userid)
			throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	

}
