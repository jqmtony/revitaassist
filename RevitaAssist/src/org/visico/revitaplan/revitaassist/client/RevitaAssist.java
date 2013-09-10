package org.visico.revitaplan.revitaassist.client;

import org.visico.revitaplan.revitaassist.client.gui.composite.LoginWidget;
import org.visico.revitaplan.revitaassist.client.gui.composite.ProjectInfoWidget;
import org.visico.revitaplan.revitaassist.client.gui.mediator.ProjectMediator;
import org.visico.revitaplan.revitaassist.shared.FieldVerifier;
import org.visico.revitaplan.revitaassist.shared.gui.data.ProjectData;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class RevitaAssist implements EntryPoint {
	
	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		VerticalPanel panel = new VerticalPanel();
		panel.add(new LoginWidget());
		
		ProjectData pd = new ProjectData();
		ProjectMediator pm = new ProjectMediator(pd);
		ProjectInfoWidget pw = new ProjectInfoWidget();
		pm.addProjectInfoWidget(pw);
		panel.add(pw);
		
		RootPanel.get().add(panel);
	}
}
