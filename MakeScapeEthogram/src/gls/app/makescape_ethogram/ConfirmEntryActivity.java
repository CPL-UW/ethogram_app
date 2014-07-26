package gls.app.makescape_ethogram;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract.Contacts.Data;
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

		// Create the text view
		TextView timeEntryView = (TextView) findViewById(R.id.timeEntry);
		timeEntryView.setText(DataSingleton.getSingleton().getTimeString());
		TextView subjectEntryView = (TextView) findViewById(R.id.subjectEntry);
		subjectEntryView.setText(DataSingleton.getSingleton()
				.getSubjectString());
		TextView targetEntryView = (TextView) findViewById(R.id.targetEntry);
		targetEntryView.setText(DataSingleton.getSingleton().getTargetString());
		TextView actionEntryView = (TextView) findViewById(R.id.actionEntry);
		actionEntryView.setText(DataSingleton.getSingleton().getActionString());

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
		Toast.makeText(this, "Entry saved", Toast.LENGTH_LONG).show();
		Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);
	}
}
