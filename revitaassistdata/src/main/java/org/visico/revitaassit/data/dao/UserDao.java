package org.visico.revitaassit.data.dao;

import java.util.List;

import org.hibernate.NonUniqueObjectException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.visico.revitaassit.data.model.User;




public class UserDao {
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
	
	public void save(User user) {
		Session session = sessionFactory.getCurrentSession();
	    session.beginTransaction();
	    session.save(user);
		session.getTransaction().commit();
	}

	public void update(User user) {
		Session session = sessionFactory.getCurrentSession();
	    session.beginTransaction();
	    session.update(user);
		session.getTransaction().commit();
	}

	public void delete(User user) {
		Session session = sessionFactory.getCurrentSession();
	    session.beginTransaction();
	    session.delete(user);
		session.getTransaction().commit();
	}

	public User findById(int id) {
		Session session = sessionFactory.getCurrentSession();
	    session.beginTransaction();
	    Query q = session.createQuery("from User where id= :id");
	    q.setInteger("id", id);
	    List<User> users = (List<User>)q.list();
	    session.getTransaction().commit();
		return (User)users.get(0);
	}
	
	public User findByEmail(String email) {
		Session session = sessionFactory.getCurrentSession();
	    session.beginTransaction();
	    Query q = session.createQuery("from User where email= :email");
	    q.setString("email", email);
	    List<User> users = (List<User>)q.list();
	    session.getTransaction().commit();
	    if (users.isEmpty())
	    	return null;
	    else
	    	return (User)users.get(0);
	}
}
