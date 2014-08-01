package gls.app.makescape_ethogram;

import android.annotation.SuppressLint;
import android.util.Log;

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

	public void parseJSON() throws JSONException
	{
		
		/*{
		    "Root": {
		        "num_headlines": 2,
		        "headline_1": "onevalue",
		        "num_options_1": 2,
		        "options_1": [
		            {
		                "options_1_1": "sub1_attr_value"
		            },
		            {
		                "options_1_2": "sub2_attr_value"
		            }
		        ],
		        "headline_2": "onevalue",
		        "num_options_2": 2,
		        "options_2": [
		            {
		                "options_2_1": "sub1_attr_value"
		            },
		            {
		                "options_2_2": "sub2_attr_value"
		            }
		        ]
		    }
		}*/


		options_map = new HashMap<Integer, Headline>();

		JSONObject object = json.getJSONObject("Root");
		int num_headlines = 2;
		try {
			num_headlines = object.getInt("num_headlines");	
			
		} catch (Exception e) {
			// TODO: handle exception
			Log.d("jsonhandler", e.toString());
		}
		
		headline_array = new String[num_headlines];

		for (int i = 0; i < num_headlines; i++) {
			String headline = object.getString("headline_" + (i+1) );
			headline_array[i] = headline; //redundant

			
			JSONArray options = object.getJSONArray("options_"+(i+1));
			Headline myHeadline = new Headline();
			myHeadline.setHeadline(headline);
			
			for(int j=0; j< options.length(); j++)
			{
				String strParsedValue =options.getJSONObject(j).getString("options_"+ (i+1)+"_" +(j+1)).toString();
				myHeadline.options.add(strParsedValue);

			}
			options_map.put(i, myHeadline);
		}
		Log.d("JSONHandler", headline_array[0]);
		DataSingleton.getSingleton().setHeadlinesArray(headline_array);
		DataSingleton.getSingleton().setHeadline_map(options_map);
	}
}
