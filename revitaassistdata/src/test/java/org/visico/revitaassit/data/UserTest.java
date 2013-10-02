package org.visico.revitaassit.data;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.visico.revitaassit.data.dao.UserDao;
import org.visico.revitaassit.data.model.User;


public class UserTest {
	
	@Test
	public void UserTest1()
	{
		  /** insert **/
    	User user = new User();
    	user.setEmail("t.hartmann@utwente.nl");
    	user.setFunction("Associate professor");
    	user.setLanguage("en");
    	user.setName("Timo Hartmann");
    	user.setOrganization("University of Twente");
    	user.setPassword("pass");
    	
    	UserDao dao = new UserDao();
    	dao.save(user);
    	
 
    	/** select **/
    	User user2 = dao.findById(user.getId());
    	assertEquals(user.getEmail(), user2.getEmail());
 
    	/** update **/
    	user2.setName("Timo");
    	dao.update(user2);
    	
    	User user3 = dao.findByEmail(user.getEmail());
    	assertEquals(user3.getName(), "Timo");
    	
    	
    	/** delete **/
    	dao.delete(user2);
 
    	System.out.println("Done");
	}

}
