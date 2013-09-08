package org.visico.revitaplan.revitaassist.client.gui.service;

import org.visico.revitaplan.revitaassist.shared.gui.data.LoginData;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("login")
public interface LoginService extends RemoteService {
	LoginData verifyUser(LoginData data) throws IllegalArgumentException;
}
