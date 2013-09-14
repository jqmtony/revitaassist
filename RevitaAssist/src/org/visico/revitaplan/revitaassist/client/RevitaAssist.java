package org.visico.revitaplan.revitaassist.client;

import org.visico.revitaplan.revitaassist.client.gui.composite.LoginWidget;
import org.visico.revitaplan.revitaassist.client.gui.composite.ProjectInfoWidget;
import org.visico.revitaplan.revitaassist.client.gui.composite.ProjectListWidget;
import org.visico.revitaplan.revitaassist.client.gui.mediator.ProjectSiteMediator;
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
import com.google.gwt.user.client.ui.ListBox;
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
		
		//panel.add(new LoginWidget());
		
		/*ProjectData pd = new ProjectData();
		ProjectSiteMediator pm = ProjectSiteMediator.getInstance();
		ProjectInfoWidget pw = new ProjectInfoWidget();
		pm.addProjectInfoWidget(pw);
		panel.add(pw);
		*/
		ProjectListWidget list_wdg = new ProjectListWidget();
		
		for (int i=0; i<5; i++)
		{
			ProjectInfoWidget w = new ProjectInfoWidget();
			w.setName("project " + i);
			w.setStage("Initiation");
			w.setDescription("stupid test");
			
			list_wdg.addProjectInfoWidget(w);
		}
		
		panel.add(list_wdg);
		
		//RootPanel.get().add(panel);
		RootPanel.get("content").add(panel);
	}
}
