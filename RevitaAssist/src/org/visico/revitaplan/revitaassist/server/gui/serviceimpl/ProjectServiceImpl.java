package org.visico.revitaplan.revitaassist.server.gui.serviceimpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.visico.revitaassit.data.dao.ProjectDao;
import org.visico.revitaassit.data.dao.UserDao;
import org.visico.revitaassit.data.model.Project;
import org.visico.revitaassit.data.model.User;
import org.visico.revitaplan.revitaassist.client.gui.service.ProjectService;
import org.visico.revitaplan.revitaassist.shared.gui.data.LoginData;
import org.visico.revitaplan.revitaassist.shared.gui.data.ProjectFullData;
import org.visico.revitaplan.revitaassist.shared.gui.data.ProjectSummaryData;


import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class ProjectServiceImpl extends RemoteServiceServlet implements ProjectService {

	@Override
	public String addProject(ProjectSummaryData data, LoginData login) throws IllegalArgumentException {
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
	public ArrayList<ProjectSummaryData> getProjectList(String userEmail)
			throws IllegalArgumentException {
		ProjectDao projectDao = new ProjectDao();
		Set<Project> projects = projectDao.findByUserEmail(userEmail);
		
		ArrayList<ProjectSummaryData> projectdata = new ArrayList<ProjectSummaryData>();
		
		for (Project p : projects)
		{
			ProjectSummaryData data = new ProjectSummaryData();
			data.setDescription(p.getDescription());
			data.setName(p.getName());
			data.setStage(p.getStage());
			data.setDatabaseid(p.getId());
			projectdata.add(data);
		}
		
		return projectdata;
	}

	@Override
	public Boolean archiveProject(int selectedProject)
			throws IllegalArgumentException {
		ProjectDao projectDao = new ProjectDao();
		Project p = projectDao.findById(selectedProject);
		p.setArchive(true);
		projectDao.update(p);
		return true;
	}

	@Override
	public ProjectFullData getProject(String email, int projectId)
			throws IllegalArgumentException {
		ProjectDao projectDao = new ProjectDao();
		Project p = projectDao.findById(projectId);
		
		// check whether the user has access to this project
		Iterator<User> it = p.getUsers().iterator();
		
		boolean hasUser = false;
		while(it.hasNext())
		{
			if (it.next().getEmail().equals(email))
				hasUser = true;
		}
		
		if (hasUser == false)
			return null;
		
		ProjectFullData data = new ProjectFullData();
		data.setDescription(p.getDescription());
		data.setName(p.getName());
		data.setStage(p.getStage());
		data.setDatabaseid(p.getId());
		
		return data;
	}

	

}
