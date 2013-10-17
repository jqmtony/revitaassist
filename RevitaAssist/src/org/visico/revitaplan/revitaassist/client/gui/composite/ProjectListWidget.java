package org.visico.revitaplan.revitaassist.client.gui.composite;

import org.visico.revitaplan.revitaassist.client.gui.mediator.ProjectListMediator;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HTMLTable.Cell;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class ProjectListWidget extends DataComposite implements ClickHandler {

	RevitaAssistConstants constants = GWT.create(RevitaAssistConstants.class);
	
	private ProjectListMediator mediator;
	
	private VerticalPanel mainPanel = new VerticalPanel();
	
	private Grid projectGrid = new Grid(0,1);
	private Button add_btn = new Button(constants.addProject());
	private Button select_btn = new Button(constants.selectProject());
	private Button archive_btn = new Button(constants.archiveProject());
	
	private int selectedRow = -1;
	
	public ProjectListWidget(ProjectListMediator mediator)
	{
		this.mediator = mediator;
		
		mainPanel.setStyleName("centerPanel");
		ScrollPanel scroller = new ScrollPanel();
		scroller.setStyleName("boundedVPanel");
		scroller.setHeight("400px");
		scroller.setWidth( "695px");
		scroller.add(projectGrid);
		mainPanel.add(scroller);
		
		HorizontalPanel btn_pnl = new HorizontalPanel();
		btn_pnl.setWidth("100%");
		btn_pnl.setStyleName("centerPanel");
		add_btn.setWidth("10em");
		btn_pnl.add(add_btn);
		add_btn.addClickHandler(this);
		select_btn.setWidth("10em");
		btn_pnl.add(select_btn);
		select_btn.addClickHandler(this);
		btn_pnl.add(archive_btn);
		archive_btn.setWidth("10em");
		archive_btn.addClickHandler(this);
		mainPanel.add(btn_pnl);
		
		projectGrid.addClickHandler(this);
		
		initWidget(mainPanel);
	}
	
	public void addProjectInfoWidget(ProjectInfoWidget widget)
	{
		int newRow = projectGrid.insertRow(projectGrid.getRowCount() );
		projectGrid.setWidget(newRow, 0, widget);
	}
	
	

	@Override
	public void onClick(ClickEvent event) {
		if (event.getSource() == projectGrid)
		{
			Cell cell = projectGrid.getCellForEvent(event);
			if (cell != null) {
				int row = cell.getRowIndex();
				selectRow(row);
			}
		}
		else if (event.getSource() == add_btn)
		{
			mediator.setAddProjectWidget();
		}
		else if (event.getSource() == archive_btn)
		{
			if (Window.confirm(constants.reallyArchive()))
				mediator.archiveProject();
			mediator.fillProjectList();
		}
	}
	

	private void selectRow(int row) {
	  // When a row (other than the first one, which is used as a header) is
	  // selected, display its associated MailItem.
	 
	  styleRow(selectedRow, false);
	  styleRow(row, true);  
	  selectedRow = row;
	
	}

	private void styleRow(int row, boolean selected) {
	    if (row != -1) {
	      if (selected) {
	    	projectGrid.getWidget(row, 0).removeStyleName("projectInfoPanel");
	        projectGrid.getWidget(row, 0).setStyleName("projectInfoPanel-selectedPanel");
	      } else {
	    	  projectGrid.getWidget(row, 0).removeStyleName("projectInfoPanel-selectedPanel");
	    	  projectGrid.getWidget(row, 0).setStyleName("projectInfoPanel");
	      }
	    }
	  }

	public void clear() {
		projectGrid.clear();
		
	}

	public int getSelectedProject() {
		ProjectInfoWidget widget = (ProjectInfoWidget)projectGrid.getWidget(selectedRow, 0);
		return widget.getProjectId();
		
	}
	
	public void resetSelectedRow()
	{
		selectedRow = -1;
	}
}
