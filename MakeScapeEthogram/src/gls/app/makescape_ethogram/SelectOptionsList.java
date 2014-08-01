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

     	String json = "{\"Root\" : {\"num_headlines\": 2,\"headline_1\": \"one value\",\"options_1\":" +
     			" [{\"options_1_1\": \"sub1_attr_value\", \"options_1_1_hasTarget\" : \"no\"},{\"options_1_2\":" +
     			" \"sub1_attr_value\", \"options_1_2_hasTarget\" : \"no\"}], \"headline_2\": \"one value\",\"options_2\": " +
     			"[{\"options_2_1\": \"sub2_attr_value\", \"options_2_1_hasTarget\" : \"yes\"},{\"options_2_2\": " +
     			"\"sub2_attr_value\", \"options_2_2_hasTarget\" : \"yes\"}]}}";

		try {
			JSONObject jsonObject = new JSONObject(json);
			
			JSONHandler handler = new JSONHandler(jsonObject);
			
			handler.parseJSON();
			

			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			Log.d("name", e.toString());
			
		}
		
		Log.d("after", "this is after");
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
