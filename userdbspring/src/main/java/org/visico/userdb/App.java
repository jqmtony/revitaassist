package org.visico.userdb;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.visico.userdb.bo.UserBo;
import org.visico.userdb.model.User;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext appContext = 
    	    	  new ClassPathXmlApplicationContext("spring/config/BeanLocations.xml");
    	 
    	    	UserBo userBo = (UserBo)appContext.getBean("userBo");
    	 
    	    	/** insert **/
    	    	User user = new User();
    	    	user.setEmail("t.hartmann@utwente.nl");
    	    	user.setFunction("Associate professor");
    	    	user.setLanguage("en");
    	    	user.setName("Timo Hartmann");
    	    	user.setOrganization("University of Twente");
    	    	user.setPassword("pass");
    	    	
    	    	userBo.save(user);
    	 
    	    	/** select **/
    	    	User user2 = userBo.findById(1);
    	    	System.out.println(user2);
    	 
    	    	/** update **/
    	    	user2.setName("Timo");
    	    	userBo.update(user2);
    	 
    	    	/** delete **/
    	    	userBo.delete(user2);
    	 
    	    	System.out.println("Done");
    }
}
