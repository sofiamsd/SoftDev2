package output;

import data.Salesman;

public abstract class Report {

	protected Salesman agent;
	
	public abstract void saveFile();
}
