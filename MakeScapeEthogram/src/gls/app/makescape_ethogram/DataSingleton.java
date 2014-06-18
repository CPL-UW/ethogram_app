package gls.app.makescape_ethogram;

public class DataSingleton {
	private static final DataSingleton SINGLETON = new DataSingleton();

	private DataSingleton() {
		subjectString = new String();
		targetString = new String();
	}

	public static DataSingleton getSingleton() {
		return SINGLETON;
	}

	private String subjectString;
	private String targetString;

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