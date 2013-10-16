package org.visico.revitaplan.revitaassist.server.gui.serviceimpl;

import java.util.ArrayList;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.visico.revitaassit.data.dao.ProjectDao;
import org.visico.revitaassit.data.dao.UserDao;
import org.visico.revitaassit.data.model.Project;
import org.visico.revitaassit.data.model.User;
import org.visico.revitaplan.revitaassist.client.gui.service.ProjectListService;
import org.visico.revitaplan.revitaassist.shared.gui.data.LoginData;
import org.visico.revitaplan.revitaassist.shared.gui.data.ProjectData;


import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class ProjectListServiceImpl extends RemoteServiceServlet implements ProjectListService {

	@Override
	public String addProject(ProjectData data, LoginData login) throws IllegalArgumentException {
		UserDao userDao = new UserDao();
		User u = userDao.findByEmail(login.getEmail());
		if (u == null)
		{
			throw new java.lang.NullPointerException("no user logged in, cannot add project");
		}
		
		// add project
		ProjectDao dao = new ProjectDao();
		Project p = new Project();
		p.setDescription(data.getDescription());
		p.setName(data.getName());
		p.setStage(data.getStage());
		p.getUsers().add(u);
		dao.save(p);
		
		return "Project added to the database";
	}

	@Override
	public ArrayList<ProjectData> getProjectList(String userEmail)
			throws IllegalArgumentException {
		ProjectDao projectDao = new ProjectDao();
		Set<Project> projects = projectDao.findByUserEmail(userEmail);
		
		ArrayList<ProjectData> projectdata = new ArrayList<ProjectData>();
		
		for (Project p : projects)
		{
			ProjectData data = new ProjectData();
			data.setDescription(p.getDescription());
			data.setName(p.getName());
			data.setStage(p.getStage());
			data.setDatabaseid(p.getId());
			projectdata.add(data);
		}
		
		return projectdata;
	}

	

}
