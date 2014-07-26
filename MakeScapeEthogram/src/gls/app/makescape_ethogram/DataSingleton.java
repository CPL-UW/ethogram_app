package gls.app.makescape_ethogram;

public class DataSingleton {
	private static final DataSingleton SINGLETON = new DataSingleton();

	private DataSingleton() {
		timeString = new String();
		subjectString = new String();
		targetString = new String();
		actionString = new String();
	}

	public static DataSingleton getSingleton() {
		return SINGLETON;
	}

	private String timeString;
	private String subjectString;
	private String targetString;
	private String actionString;

	public String getTimeString() {
		return timeString;
	}

	public void setTimeString(String timeString) {
		this.timeString = timeString;
	}

	public String getActionString() {
		return actionString;
	}

	public void setActionString(String actionString) {
		this.actionString = actionString;
	}

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