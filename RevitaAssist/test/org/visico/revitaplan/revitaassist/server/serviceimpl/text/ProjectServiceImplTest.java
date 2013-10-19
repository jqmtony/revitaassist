package org.visico.revitaplan.revitaassist.server.serviceimpl.text;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.visico.revitaassit.data.dao.ProjectDao;
import org.visico.revitaassit.data.dao.UserDao;
import org.visico.revitaassit.data.model.Project;
import org.visico.revitaassit.data.model.User;
import org.visico.revitaplan.revitaassist.server.gui.serviceimpl.ProjectServiceImpl;
import org.visico.revitaplan.revitaassist.shared.gui.data.LoginData;
import org.visico.revitaplan.revitaassist.shared.gui.data.ProjectSummaryData;

public class ProjectServiceImplTest {
	@Test
	public void addProjectTest()
	{
		User u = new User();
    	u.setEmail("tester.test@t.com");
    	UserDao udao = new UserDao();
    	udao.save(u);
    	
    	ProjectSummaryData projectData = new ProjectSummaryData();
    	projectData.setDescription("Test");
    	projectData.setName("Test Project");
    	projectData.setStage("initialization");
    	
    	LoginData loginData = new LoginData();
    	loginData.setEmail(u.getEmail());
    	ProjectServiceImpl service = new ProjectServiceImpl();
    	service.addProject(projectData, loginData);
    	
    	ProjectDao dao = new ProjectDao();
    	Project p = dao.findByUserId(u.getId()).iterator().next();
    	assertTrue(p.getName().equals("Test Project"));
    	
    	/** delete and clean up**/
    	dao.delete(p);
    	udao.delete(u);
	}
	
	
	@Test 
	public void archiveProjectTest()
	{
		Project p = new Project();
    	p.setName("Test Project");
    	p.setStage("initiatio");
    	p.setDescription("Hallo tester");
    	ProjectDao dao = new ProjectDao();
    	dao.save(p);
    	assertNotNull(p.getId());
 
    	ProjectServiceImpl service = new ProjectServiceImpl();
    	service.archiveProject(p.getId());
    	
    	// archived projects should not be returned
    	assertNull(dao.findById(p.getId()));
    	
    	/** delete and clean up**/
    	dao.delete(p);
	}
	
	@Test
	public void getProjectTest()
	{
		Project p = new Project();
    	p.setName("Test Project");
    	p.setStage("initiatio");
    	p.setDescription("Hallo tester");
    	User u = new User();
    	u.setEmail("tester.test@t.com");
    	Set<User> users = new HashSet<User>();
    	users.add(u);
    	p.setUsers(users);
    	UserDao udao = new UserDao();
    	udao.save(u);
    	ProjectDao dao = new ProjectDao();
    	dao.save(p);
    	assertNotNull(p.getId());
 
    	ProjectServiceImpl service = new ProjectServiceImpl();
    	assertNull(service.getProject("wrong@mail.com", p.getId()));
    	assertTrue(service.getProject("tester.test@t.com", p.getId()).getName().equals("Test Project"));
    	
    	/** delete and clean up**/
    	dao.delete(p);
    	udao.delete(u);
	}
	
	@Test
	public  void getProjectListTest()
	{
		Project p = new Project();
    	p.setName("Test Project");
    	p.setStage("initiatio");
    	p.setDescription("Hallo tester");
    	User u = new User();
    	u.setEmail("tester.test@t.com");
    	Set<User> users = new HashSet<User>();
    	users.add(u);
    	p.setUsers(users);
    	UserDao udao = new UserDao();
    	udao.save(u);
    	ProjectDao dao = new ProjectDao();
    	dao.save(p);
    	assertNotNull(p.getId());
 
    	ProjectServiceImpl service = new ProjectServiceImpl();
    	assertTrue(service.getProjectList("tester.test@t.com").get(0).getName().equals("Test Project"));
    
    	
    	/** delete and clean up**/
    	dao.delete(p);
    	udao.delete(u);
	}
	
}
