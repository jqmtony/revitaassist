package org.visico.userdb;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Test;
import org.visico.userdb.dao.UserDao;
import org.visico.userdb.model.User;


public class DaoTest {
	
	@Test
	public void testUser()
	{
		/** insert **/
    	User user = new User();
    	user.setEmail("tester@test.nl");
    	user.setFunction("Tester");
    	user.setLanguage("en");
    	user.setName("Tester Test");
    	user.setOrganization("TestOrg");
    	user.setPassword("pass");
    	
    	UserDao dao = new UserDao();
    	dao.save(user);
 
    	/** select **/
    	User user2 = dao.findByEmail("tester@test.nl");
    	assertNotNull(user2);
 
    	/** update **/
    	user2.setName("Tester");
    	dao.update(user2);
    	User user3 = dao.findByEmail("tester@test.nl");
    	assertEquals(user3.getName(), "Tester");
    	
    	/** delete **/
    	dao.delete(user3);
    	User user4 = dao.findByEmail("tester@test.nl");
    	assertNull(user4);
	}
	
	@After 
	public void deleteEntries()
	{
		UserDao dao = new UserDao();
		User user = dao.findByEmail("tester@test.nl");
		if (user != null)
			dao.delete(user);
	}
	
	
}
