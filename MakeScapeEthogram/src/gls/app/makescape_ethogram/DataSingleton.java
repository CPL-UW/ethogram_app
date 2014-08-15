package gls.app.makescape_ethogram;

import java.util.HashMap;
import java.util.Map;

public class DataSingleton {
	private static final DataSingleton SINGLETON = new DataSingleton();

	private DataSingleton() {
		subjectString = new String();
        subjectDescription = new String();
		targetString = new String();
        targetDescription = new String();
		headline_map = new HashMap<Integer, Headline>();
		headlinesArray = new String[100];
        actionString = new String();
	}

	public String[] getHeadlinesArray() {
		return headlinesArray;
	}

	public void setHeadlinesArray(String[] headlinesArray) {
		this.headlinesArray = headlinesArray;
	}

	public Map<Integer, Headline> getHeadline_map() {
		return headline_map;
	}

	public void setHeadline_map(Map<Integer, Headline> headline_map) {
		this.headline_map = headline_map;
	}

	public static DataSingleton getSingleton() {
		return SINGLETON;
	}
	private Map<Integer, Headline> headline_map;
	private String subjectString;
    private String subjectDescription;
	private String targetString;
    private String targetDescription;
	private String[] headlinesArray;
    private String actionString;

	public String getSubjectString() {
		return subjectString;
	}

	public void setSubjectString(String subjectString) {
		this.subjectString = subjectString;
	}

    public String getSubjectDescription() {return subjectDescription; }

    public void setSubjectDescription(String subjectDescription) { this.subjectDescription = subjectDescription; }

    public String getTargetString() {
		return targetString;
	}

    public String getTargetDescription() {return targetDescription; }

    public void setTargetDescription(String targetDescription) { this.targetDescription = targetDescription; }

    public void setTargetString(String targetString) {
		this.targetString = targetString;
	}

    public String getActionString() {return actionString; }

    public void setActionString(String actionString) { this.actionString = actionString; }

}