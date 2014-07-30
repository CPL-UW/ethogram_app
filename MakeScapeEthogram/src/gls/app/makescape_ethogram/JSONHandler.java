package gls.app.makescape_ethogram;

import android.annotation.SuppressLint;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONHandler {

	private JSONObject json; 
	private String[] headline_array;
	Map options_map ;


	public JSONHandler(JSONObject json) {
		this.json = json;
	}

	public JSONObject getJson() {
		return json;
	}

	public void setJson(JSONObject json) {
		this.json = json;
	}

	public String[] getHeadline_array() {
		return headline_array;
	}

	public void setHeadline_array(String[] headline_array) {
		this.headline_array = headline_array;
	}

	public Map getOptions_map() {
		return options_map;
	}

	public void setOptions_map(Map options_map) {
		this.options_map = options_map;
	}

	public Map<Integer, Headline> parseJSON() throws JSONException
	{
		/*{
		    "Root": {
		        "num_headlines": 2,
		        "headline_1": "one value",
		        "num_options": 2,
		        "options_1": [
		            {
		                "options_1_1": "sub1_attr_value"
		            },
		            {
		                "options_1_2": "sub2_attr_value"
		            }
		        ]

		        "headline_2": "one value",
		        "num_options": 2,
		        "options_2": [
		            {
		                "options_1_1": "sub1_attr_value"
		            },
		            {
		                "options_1_2": "sub2_attr_value"
		            }
		        ]
		    }
		}*/


		options_map = new HashMap<Integer, Headline>();

		JSONObject object = json.getJSONObject("Root");
		int num_headlines = json.getInt("num_headlines");

		headline_array = new String[num_headlines];

		for (int i = 0; i < num_headlines; i++) {
			String headline = json.getString("headline_"+i);
			headline_array[i] = headline; //redundant

			int num_options = json.getInt("num_options_"+i);
			JSONArray options = json.getJSONArray("options_"+i);
			Headline myHeadline = new Headline();
			myHeadline.setHeadline(headline);
			
			for(int j=0; j< options.length(); j++)
			{
				String strParsedValue =options.getJSONObject(j).getString("options_1_"+j).toString();
				myHeadline.options.add(strParsedValue);

			}
			options_map.put(i, myHeadline);
		}
		return options_map;
	}
}
