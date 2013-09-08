package org.visico.userdb;

import org.visico.userdb.dao.UserDao;
import org.visico.userdb.model.User;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
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
    	User user2 = dao.findById(1);
    	System.out.println(user2);
 
    	/** update **/
    	user2.setName("Timo");
    	dao.update(user2);
    	
    	
    	/** delete **/
    	dao.delete(user2);
 
    	System.out.println("Done");
    }
}
