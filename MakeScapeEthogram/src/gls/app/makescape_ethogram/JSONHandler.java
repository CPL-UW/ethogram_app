package gls.app.makescape_ethogram;

import android.annotation.SuppressLint;
import android.util.Log;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONHandler {

	private JSONObject json;
	private String[] headline_array;
	Map options_map ;
    private static FileOutputStream out;
    private static BufferedReader reader;


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

		//Correct format for config file after turned into json
		/*{
		    "Root": {
		        "num_headlines": 2,
		        "headline_1": "onevalue",		        
		        "options_1": [
		            {
		                "options_1_1": "sub1_attr_value", 
		                "options_1_1_hasTarget" : "no"
		            },
		            {
		                "options_1_2": "sub2_attr_value",
		                "options_1_2_hasTarget" : "no"
		            }
		        ],
		        "headline_2": "onevalue",		        
		        "options_2": [
		            {
		                "options_2_1": "sub1_attr_value",
		                "options_2_1_hasTarget" : "no"
		            },
		            {
		                "options_2_2": "sub2_attr_value",
		                "options_2_2_hasTarget" : "no"
		            }
		        ]
		    }
		}*/


		options_map = new HashMap<Integer, Headline>();

		JSONObject object = json.getJSONObject("Root");
        Log.d("parsing", object.toString());
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
				String hasTargetstr =options.getJSONObject(j).getString("options_"+ (i+1)+"_" +(j+1) + "_hasTarget").toString();
				
				if(hasTargetstr.equals("yes")){
				
					myHeadline.hasTarget.add(j);
					
				}
				
				myHeadline.options.add(strParsedValue);

			}
			options_map.put(i, myHeadline);
		}
		Log.d("JSONHandler", headline_array[0]);
		DataSingleton.getSingleton().setHeadlinesArray(headline_array);
		DataSingleton.getSingleton().setHeadline_map(options_map);
	}



    public String csvToJSON(InputStream in) throws IOException {
        json = new JSONObject();
        reader = new BufferedReader(new InputStreamReader(in));


        String headlines = reader.readLine();

        String json = "{\"Root\" : {";

        //TODO: add all info from config file


        json = json + "}}";


        return "";
    }

}
