package org.visico.revitaplan.revitaassist.server.gui.serviceimpl;

import org.visico.revitaplan.revitaassist.client.gui.service.LoginService;
import org.visico.revitaplan.revitaassist.shared.gui.data.LoginData;
import org.visico.userdb.dao.UserDao;
import org.visico.userdb.model.User;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class LoginServiceImpl extends RemoteServiceServlet implements LoginService {

	@Override
	public LoginData verifyUser(LoginData data) throws IllegalArgumentException {
		UserDao userdao = new UserDao();
		User u = userdao.findByEmail(data.getEmail());
		
		if (u != null && u.getPassword().equals(data.getPassword()))
			data.setLoggedin(true);
		
		return data;
	}

}
