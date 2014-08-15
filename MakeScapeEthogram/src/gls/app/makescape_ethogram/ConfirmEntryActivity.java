package gls.app.makescape_ethogram;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.Time;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ConfirmEntryActivity extends Activity {
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_confirm_entry);

		Time time = new Time();
		time.setToNow();

		// Create the text view from Data Singleton
		TextView timeEntryView = (TextView) findViewById(R.id.TimeEntry);
		timeEntryView.setText(time.format3339(false));

        TextView subjectEntryView = (TextView) findViewById(R.id.subject);
		subjectEntryView.setText(DataSingleton.getSingleton().getSubjectDescription());
        TextView targetEntryView = (TextView) findViewById(R.id.target);
        targetEntryView.setText(DataSingleton.getSingleton().getTargetDescription());


        TextView actionView = (TextView) findViewById(R.id.action);
        actionView.setText(DataSingleton.getSingleton().getActionString());     //TODO: where should the action string be set?

	}

	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	public void startApproachActions(View v) {
		// Intent intent = new Intent(this, ApproachActivity.class);
		// startActivity(intent);
	}

	public void startDoActions(View v) {
		// Intent intent = new Intent(this, DoActivity.class);
		// startActivity(intent);
	}

	public void confirmButton(View v) {
        //TODO: store JSON somewhere
		Toast.makeText(this, "Entry saved", Toast.LENGTH_LONG).show();
		Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);
	}
}
