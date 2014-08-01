package gls.app.makescape_ethogram;

import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class SelectOptionsList extends Activity {

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_select_options_list);

		//This is the begin of the example.
		//Before this, the app should get the JSON object 
		//STEPS: 
		//	1- Get the JSON code from the server based on the experiment (this code should do this) 
		// 	2- Use the JSONObject to populate the file with the headlines and options. ( this code should do this)
		//	3- Use the values/string using the database. 

			
		//String json = "{\"Root\": {\"attr1\": \"ona value\",\"attr2\": \"two value\",\"sbu\": {\"sub1\": [{	\"sub1_attr\": \"sub1_attr_value\"},{\"sub1_attr\": \"sub2_attr_value\"	}]}}}";
     	String json = "{\"Root\" : {\"num_headlines\": 2,\"headline_1\": \"one value\",\"options_1\": [{\"options_1_1\": \"sub1_attr_value\"},{\"options_1_2\": \"sub1_attr_value\"}], \"headline_2\": \"one value\",\"options_2\": [{\"options_2_1\": \"sub2_attr_value\"},{\"options_2_2\": \"sub2_attr_value\"}]}}";
     	//String teste = "{\"errors\":[{\"message\":\"The Twitter REST API v1 is no longer active. Please migrate to API v1.1. https://dev.twitter.com/docs/api/1.1/overview.\",\"code\":64}]}";
     	//Gson gson =  new Gson();
     	//String string_to_parse= gson.toJson(teste);
		try {
			Log.d("before", "this");
			JSONObject jsonObject = new JSONObject(json);
			
			Log.d("after", "this");
			//Json Parsing
			//parseJson(jsonObject);
			
			JSONHandler handler = new JSONHandler(jsonObject);
			
			handler.parseJSON();
			Log.d("teste", "something");
			

			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			Log.d("teste", e.toString());
			
		}
		
		//This is the end of the example.


		ListView lv = (ListView) findViewById(R.id.list_options);

		ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.experiments,android.R.layout.simple_list_item_1);
		lv.setAdapter(adapter);

		lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Intent intent = new Intent(SelectOptionsList.this, MainActivity.class); // change to actual class
				intent.putExtra("OPTION_POSITION", position);
				startActivity(intent);
			}			
		});
	}

	private void parseJson(JSONObject jsonObject) {
		try {
			JSONObject root =jsonObject.getJSONObject("Root");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
