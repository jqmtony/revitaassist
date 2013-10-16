package org.visico.revitaplan.revitaassist.client;

import org.visico.revitaplan.revitaassist.client.gui.mediator.AppControlMediator;
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
		appControl.drawLogin();
	}
}
