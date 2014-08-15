package gls.app.makescape_ethogram;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
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
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_select_options_list);


        //TODO: get json object from user
//        String json = getJSONFromFile();
        String json="";
        if (json == "") {
            //Test string
//         json = "{\"Root\" : {\"num_headlines\": 2,\"headline_1\": \"one value\",\"options_1\":" +
//                    " [{\"options_1_1\": \"sub1_attr_value\", \"options_1_1_hasTarget\" : \"no\"},{\"options_1_2\":" +
//                    " \"sub1_attr_value\", \"options_1_2_hasTarget\" : \"no\"}], \"headline_2\": \"one value\",\"options_2\": " +
//                    "[{\"options_2_1\": \"sub2_attr_value\", \"options_2_1_hasTarget\" : \"yes\"},{\"options_2_2\": " +
//                    "\"sub2_attr_value\", \"options_2_2_hasTarget\" : \"yes\"}]}}";

        json = "{\"Root\": {\"num_headlines\":2,\"headline_1\":\"Do\",\"options_1\":[{\"options_1_1\":\"AddBlock\",\"options_1_1_hasTarget\":\"no\"},{\"options_1_2\":\"Adds more than one block\",\"options_1_2_hasTarget\":\"no\"},{\"options_1_3\":\"Catches a Fish\",\"options_1_3_hasTarget\":\"no\"},{\"options_1_4\":\"Completes circuit\",\"options_1_4_hasTarget\":\"no\"},{\"options_1_5\":\"Connects 2 Blocks\",\"options_1_5_hasTarget\":\"no\"},{\"options_1_6\":\"Looks at another players cicuit\",\"options_1_6_hasTarget\":\"yes\"},{\"options_1_7\":\"Looks at demo video\",\"options_1_7_hasTarget\":\"no\"},{\"options_1_8\":\"Looks at leaderboard\",\"options_1_8_hasTarget\":\"no\"},{\"options_1_9\":\"Takes block from another player space\",\"options_1_9_hasTarget\":\"yes\"},{\"options_1_10\":\"Touches another players circuit\",\"options_1_10_hasTarget\":\"yes\"},{\"options_1_11\":\"Takes block from another player space\",\"options_1_11_hasTarget\":\"yes\"}],\"headline_2\":\"Say\",\"options_2\":[{\"options_2_1\":\"Answers design-oriented question\",\"options_2_1_hasTarget\":\"no\"},{\"options_2_2\":\"Argues game decision\",\"options_2_2_hasTarget\":\"no\"},{\"options_2_3\":\"Asks for help with game\",\"options_2_3_hasTarget\":\"no\"},{\"options_2_4\":\"Askstoborrowblock\",\"options_2_4_hasTarget\":\"no\"},{\"options_2_5\":\"Explains circuit design to someone else\",\"options_2_5_hasTarget\":\"no\"},{\"options_2_6\":\"Talks about leaderboard\",\"options_2_6_hasTarget\":\"no\"},{\"options_2_7\":\"Talksaboutadesignfailing\",\"options_2_7_hasTarget\":\"no\"},{\"options_2_8\":\"Justifiesadesignchoice\",\"options_2_8_hasTarget\":\"no\"},{\"options_2_9\":\"Suggests a fix after a fail\",\"options_2_9_hasTarget\":\"no\"}]}}";

        }
     	try {
//			JSONObject jsonObject = new JSONObject(json);
            JSONObject jsonObject = new JSONObject(json1);

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


    /*
    Build JSON object from .csv config file
     */
    private String getJSONFromFile(){
        String str = "";
        try {

           InputStream is = getAssets().open("assets/ethogram_config.json");
           BufferedReader reader = new BufferedReader(new InputStreamReader(is));
           String line;
           StringBuilder builder = new StringBuilder("");
           while((line = reader.readLine()) != null)
           {
               builder.append(line);
           }
           str = builder.toString();

           //TODO: escape " char in str
           is.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
//        String json = "{\"Root\" : {";
//
//        //TODO: add all info from config file
//
//
//        json = json + "}}";

        Log.d("SelectOptionsList", str);
        return str;
    }
}
