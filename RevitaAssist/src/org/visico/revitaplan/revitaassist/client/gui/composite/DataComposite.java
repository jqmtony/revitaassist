package org.visico.revitaplan.revitaassist.client.gui.composite;

import org.visico.revitaplan.revitaassist.shared.gui.data.DataObject;

import com.google.gwt.user.client.ui.Composite;

public class DataComposite extends Composite
{
	private DataObject dobj;
	
	public void getData()
	{
		dobj.getData();
	}
	
	public void saveData()
	{
		dobj.saveData();
	}
}
