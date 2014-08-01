package gls.app.makescape_ethogram;
import java.util.ArrayList;


public class Headline {

	private String headline; 
	ArrayList<String> options;
	ArrayList<Integer> hasTarget;
	
	public ArrayList<Integer> getHasTarget() {
		return hasTarget;
	}

	public void setHasTarget(ArrayList<Integer> hasTarget) {
		this.hasTarget = hasTarget;
	}

	public Headline (){
		options = new ArrayList<String>(); 
		hasTarget = new ArrayList<Integer>();
	}
	
	public String getHeadline() {
		return headline;
	}
	public void setHeadline(String headline) {
		this.headline = headline;
	}
	public ArrayList<String> getOptions() {
		return options;
	}
	public void setOptions(ArrayList<String> options) {
		this.options = options;
	}
}
