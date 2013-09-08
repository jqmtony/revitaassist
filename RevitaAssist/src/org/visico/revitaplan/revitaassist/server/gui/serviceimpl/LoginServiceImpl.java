package org.visico.revitaplan.revitaassist.server.gui.serviceimpl;

import org.visico.revitaplan.revitaassist.client.gui.service.LoginService;
import org.visico.revitaplan.revitaassist.shared.gui.data.LoginData;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class LoginServiceImpl extends RemoteServiceServlet implements LoginService {

	@Override
	public LoginData verifyUser(LoginData data) throws IllegalArgumentException {
		if (data.getUser().equals("Joe Doe") && data.getPassword().equals("pass"))
			data.setLoggedin(true);
		return data;
	}

}
