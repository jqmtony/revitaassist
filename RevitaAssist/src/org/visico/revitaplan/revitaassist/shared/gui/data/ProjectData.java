package org.visico.revitaplan.revitaassist.shared.gui.data;


import java.io.Serializable;

public class ProjectData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1238290418251711033L;
	
	public String name = "Test Project";
	public String stage = "Initiation";
	public String description = "The test project is the default data " +
			"assignment for the ProjectData class";
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStage() {
		return stage;
	}
	public void setStage(String stage) {
		this.stage = stage;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
