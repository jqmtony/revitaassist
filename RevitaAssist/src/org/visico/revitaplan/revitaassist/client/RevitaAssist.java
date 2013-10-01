package org.visico.revitaplan.revitaassist.client;

import org.visico.revitaplan.revitaassist.client.gui.mediator.AppControlMediator;
import org.visico.revitaplan.revitaassist.shared.gui.data.LoginData;
import com.google.gwt.core.client.EntryPoint;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class RevitaAssist implements EntryPoint {
	
	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		
		AppControlMediator appControl= AppControlMediator.getInstance();
		LoginData data = new LoginData();
		appControl.startSession(data);
	}
}
