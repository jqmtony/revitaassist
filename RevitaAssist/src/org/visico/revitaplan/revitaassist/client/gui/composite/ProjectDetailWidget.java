package org.visico.revitaplan.revitaassist.client.gui.composite;

import org.visico.revitaplan.revitaassist.client.gui.mediator.AppControlMediator;
import org.visico.revitaplan.revitaassist.client.gui.mediator.ProjectDetailMediator;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;


public class ProjectDetailWidget extends DataComposite implements ClickHandler {

	RevitaAssistConstants constants = GWT.create(RevitaAssistConstants.class);
	
	ProjectDetailMediator mediator;
	DockLayoutPanel mainPanel;
	Button back;
	Button maturity;
	Button stakeholder;
	Button process;
	Button sketch;
	
	
	public ProjectDetailWidget(ProjectDetailMediator mediator)
	{
		mainPanel = new DockLayoutPanel(Unit.PX);
		mainPanel.setStyleName("projectDetail");
			
		HorizontalPanel btn_pnl = new HorizontalPanel();
		btn_pnl.setWidth("100%");
		btn_pnl.setStyleName("centerPanel");
		
		back = new Button();
		back.setWidth("7em");
		back.setText(constants.back());
		back.addClickHandler(this);
		btn_pnl.add(back);
		
		maturity = new Button();
		maturity.setWidth("7em");
		maturity.setText(constants.maturity());
		maturity.addClickHandler(this);
		btn_pnl.add(maturity);
		
		stakeholder = new Button();
		stakeholder.setWidth("7em");
		stakeholder.setText(constants.stakeholder());
		stakeholder.addClickHandler(this);
		btn_pnl.add(stakeholder);
		
		process = new Button();
		process.setWidth("7em");
		process.setText(constants.process());
		process.addClickHandler(this);
		btn_pnl.add(process);
		
		sketch = new Button();
		sketch.setWidth("7em");
		sketch.setText(constants.sketch());
		sketch.addClickHandler(this);
		btn_pnl.add(sketch);
		
		mainPanel.addSouth(btn_pnl, 60);
		
		initWidget(mainPanel);
	}
	
	public void addProjectInfoWidget(ProjectInfoWidget projectInfoWidget)
	{
		HorizontalPanel panel = new HorizontalPanel();
		panel.setStyleName("centeredPanel");
		
		panel.add(projectInfoWidget);
		
		mainPanel.addNorth(panel, 120);
	}
	
	
	@Override
	public void onClick(ClickEvent event) {
		if (event.getSource() == back)
		{
			AppControlMediator.getInstance().drawProjectList();
		}
		else if (event.getSource() == maturity)
		{
			AppControlMediator.getInstance().startMaturityAssessment();
		}
		
	}

}
