package org.visico.revitaplan.revitaassist.server.gui.serviceimpl;

import javax.servlet.http.HttpSession;

import org.visico.revitaassit.data.dao.UserDao;
import org.visico.revitaassit.data.model.User;
import org.visico.revitaplan.revitaassist.client.gui.service.LoginService;
import org.visico.revitaplan.revitaassist.shared.gui.data.LoginData;


import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class LoginServiceImpl extends RemoteServiceServlet implements LoginService {

	@Override
	public LoginData verifyUser(LoginData data) throws IllegalArgumentException {
		UserDao userdao = new UserDao();
		User u = userdao.findByEmail(data.getEmail());
		
		if (u != null && u.getPassword().equals(data.getPassword()))
		{
			data.setLoggedin(true);
			HttpSession session = this.getThreadLocalRequest().getSession(true);
			session.setAttribute("user", data.getEmail());
			data.setSessionId(session.getId());
			data.setName(u.getName());
			data.setFunction(u.getFunction());
			data.setOrganization(u.getOrganization());
			data.setLanguage(u.getLanguage());
			data.setDatabaseId(u.getId());
		}
		
		return data;
	}

	@Override
	public LoginData changeUser(LoginData data) throws IllegalArgumentException {
		UserDao userdao = new UserDao();
		User u = userdao.findById(data.getDatabaseId());
		
		if (u == null)
			throw new NullPointerException("user with this id not in the database");
		
		u.setEmail(data.getEmail());
		u.setFunction(data.getFunction());
		u.setLanguage(data.getLanguage());
		u.setName(data.getName());
		u.setOrganization(data.getOrganization());
		
		userdao.update(u);
		return data;
	}

	@Override
	public Integer changePassword(int userid, String password) throws IllegalArgumentException {
		UserDao userdao = new UserDao();
		User u = userdao.findById(userid);
		
		if (u == null)
			throw new NullPointerException("user with this id not in the database");
		
		u.setPassword(password);
		
		userdao.update(u);
		return new Integer(1);
	}
	
	

}
