package gls.app.makescape_ethogram;

import java.util.HashMap;
import java.util.Map;

public class DataSingleton {
	private static final DataSingleton SINGLETON = new DataSingleton();

	private DataSingleton() {
		subjectString = new String();
		targetString = new String();
		headline_map = new HashMap<Integer, Headline>();
		headlinesArray = new String[100];
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
	private String targetString;
	private String[] headlinesArray;

	public String getSubjectString() {
		return subjectString;
	}

	public void setSubjectString(String subjectString) {
		this.subjectString = subjectString;
	}

	public String getTargetString() {
		return targetString;
	}

	public void setTargetString(String targetString) {
		this.targetString = targetString;
	}
}