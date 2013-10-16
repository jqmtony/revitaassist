package org.visico.revitaplan.revitaassist.shared.gui.data;


import java.io.Serializable;

public class ProjectData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1238290418251711033L;
	
	private String name = "Test Project";
	private String stage = "Initiation";
	private String description = "The test project is the default data " +
			"assignment for the ProjectData class";
	private int databaseid;
	
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
	public int getDatabaseid() {
		return databaseid;
	}
	public void setDatabaseid(int databaseid) {
		this.databaseid = databaseid;
	}

	
}
