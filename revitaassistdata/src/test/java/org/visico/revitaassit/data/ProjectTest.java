package org.visico.revitaassit.data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.visico.revitaassit.data.dao.ProjectDao;
import org.visico.revitaassit.data.dao.UserDao;
import org.visico.revitaassit.data.model.Project;
import org.visico.revitaassit.data.model.User;


public class ProjectTest {
	@Test
	public void ProjectTest1()
	{
		Project p = new Project();
    	p.setName("Test Project");
    	p.setStage("initiatio");
    	p.setDescription("Hallo tester");
    	
    	ProjectDao dao = new ProjectDao();
    	dao.save(p);
    	assertNotNull(p.getId());
 
    	/** select **/
    	Project project2 = dao.findById(p.getId());
    	System.out.println(project2);
    	assertEquals(p.getName(), project2.getName());
    	
    	/** update **/
    	project2.setName("Timo");
    	dao.update(project2);
    	
    	User u = new User();
    	Set<Project> s = new HashSet<Project>();
    	s.add(project2);
    	u.setProjects(s);
    	u.setEmail("t.t@t.com");
    	UserDao udao = new UserDao();
    	udao.save(u);
    	
    	Set<Project> projects = dao.findByUserId(u.getId());
    	assertEquals(projects.iterator().next().getName(), "Timo");
    	
    	projects = dao.findByUserEmail(u.getEmail());
    	assertEquals(projects.iterator().next().getName(), "Timo");
    	
    	/** delete **/
    	dao.delete(project2);
    	udao.delete(u);
	}
}
