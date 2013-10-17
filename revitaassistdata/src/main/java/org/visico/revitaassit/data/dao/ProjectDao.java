package org.visico.revitaassit.data.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Restrictions;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.visico.revitaassit.data.model.Project;
import org.visico.revitaassit.data.model.User;



public class ProjectDao {
	private static final SessionFactory sessionFactory;
	private static final ServiceRegistry serviceRegistry;
	
	static
	{
		try
		{
			Configuration configuration = new Configuration();
			configuration.configure();
			serviceRegistry = new ServiceRegistryBuilder().
					applySettings(configuration.getProperties()).buildServiceRegistry(); 
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		}
		catch (Throwable ex)
		{
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	public void save(Project project) {
		Session session = sessionFactory.getCurrentSession();
	    session.beginTransaction();
	    session.save(project);
		session.getTransaction().commit();
	}

	public void update(Project project) {
		Session session = sessionFactory.getCurrentSession();
	    session.beginTransaction();
	    session.update(project);
		session.getTransaction().commit();
	}

	public void delete(Project project) {
		Session session = sessionFactory.getCurrentSession();
	    session.beginTransaction();
	    session.delete(project);
		session.getTransaction().commit();
	}

	public Project findById(int id) {
		Session session = sessionFactory.getCurrentSession();
	    session.beginTransaction();
	    Query q = session.createQuery("from Project where id= :id and archive=false");
	    q.setInteger("id", id);
	    List<Project> projects = (List<Project>)q.list();
	    session.getTransaction().commit();
		return (Project)projects.get(0);
	}
	
	public Set<Project> findByUserId(int id) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
	    Query q = session.createQuery("from User u where id= :id");
	    q.setInteger("id", id);
	    User u = (User)q.list().get(0);
	    Set<Project> projects = new HashSet<Project>();
	    for (Project p : u.getProjects())
	    {
	    	if (p.isArchive() != true)
	    	{
		    	Hibernate.initialize(p);
		    	projects.add(p);
	    	}
	    }
	     
	    session.getTransaction().commit();
	    return projects;
	}
	
	public void addUser(int project, int user)
	{
		Session session = sessionFactory.getCurrentSession();
	    session.beginTransaction();
	    Query q = session.createSQLQuery("insert into USERPROJECTREL (projectid, userid) VALUES (:project, :user)");
	    q.setInteger("project", project);
	    q.setInteger("user", user);
	    q.executeUpdate();
	    session.getTransaction().commit();
	}

	public Set<Project> findByUserEmail(String userEmail) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
	    Query q = session.createQuery("from User u where email= :mail");
	    q.setString("mail", userEmail);
	    User u = (User)q.list().get(0);
	    Set<Project> projects = new HashSet<Project>();
	    for (Project p : u.getProjects())
	    {
	    	if (p.isArchive() != true)
	    	{
		    	Hibernate.initialize(p);
		    	projects.add(p);
	    	}
	    }
	     
	    session.getTransaction().commit();
	    return projects;
		
	}
}
