package gls.app.makescape_ethogram;

import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
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

			
		String json = "{\"Root\": {\"attr1\": \"ona value\",\"attr2\": \"two value\",\"sbu\": {\"sub1\": [{	\"sub1_attr\": \"sub1_attr_value\"},{\"sub1_attr\": \"sub2_attr_value\"	}]}}}";
		try {
			JSONObject jsonObject = new JSONObject(json);
			//Json Parsing
			parseJson(jsonObject);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
