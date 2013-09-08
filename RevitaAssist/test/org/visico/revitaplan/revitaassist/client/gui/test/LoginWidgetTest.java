package org.visico.revitaplan.revitaassist.client.gui.test;

import org.visico.revitaplan.revitaassist.client.gui.composite.LoginWidget;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

public class LoginWidgetTest implements EntryPoint {

	@Override
	public void onModuleLoad() {
		RootPanel.get().add(new LoginWidget());
		
	}

}
