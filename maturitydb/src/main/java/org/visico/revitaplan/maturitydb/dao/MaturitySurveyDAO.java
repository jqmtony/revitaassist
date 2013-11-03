package org.visico.revitaplan.maturitydb.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import org.visico.revitaplan.maturitydb.model.Groupings;
import org.visico.revitaplan.maturitydb.model.Question;

public class MaturitySurveyDAO {

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
	
	public List<Question> getQuestions()
	{	
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
	    Query q = session.createQuery(
	    		"select q from Question as q, Survey as s where q.id = s.question order by s.position");
	    @SuppressWarnings("unchecked")
		List<Question> questions = (List<Question>)q.list();     
	    session.getTransaction().commit();
	    return questions;
	}
	
	public List<Groupings> getGroupings()
	{
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
	    Query q = session.createQuery(
	    		"from Groupings");
	    @SuppressWarnings("unchecked")
		List<Groupings> groupings = (List<Groupings>)q.list();     
	    session.getTransaction().commit();
	    return groupings;
	}
}
