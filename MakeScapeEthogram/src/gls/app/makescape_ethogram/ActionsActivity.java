package gls.app.makescape_ethogram;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class ActionsActivity extends Activity {

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_actions);
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

	public void startSayActions(View v) {
		Intent intent = new Intent(this, SayActionsActivity.class);
		startActivity(intent);
	}
}
