package org.visico.revitaplan.revitaassist.client.gui.service;

import org.visico.revitaplan.revitaassist.shared.gui.data.LoginData;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface LoginServiceAsync {
	void verifyUser(LoginData data, AsyncCallback<LoginData> callback)
			throws IllegalArgumentException;
	void changeUser(LoginData data, AsyncCallback<LoginData> callback) 
			throws IllegalArgumentException;
	void changePassword(int userid, String password, AsyncCallback<Integer> callback) 
			throws IllegalArgumentException;
}
