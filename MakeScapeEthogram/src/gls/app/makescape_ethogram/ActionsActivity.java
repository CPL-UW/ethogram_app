package gls.app.makescape_ethogram;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class ActionsActivity extends Activity {
	
	private static String X_POS_SUBJECT = "gls.app.makescape_ethogram.x";
	private static String Y_POS_SUBJECT = "gls.app.makescape_ethogram.y";
	private float pos_x;
	private float pos_y;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_actions);
		pos_x = (Float) getIntent().getExtras().get(X_POS_SUBJECT);
		pos_y = (Float) getIntent().getExtras().get(Y_POS_SUBJECT);
		
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
		intent.putExtra(X_POS_SUBJECT, pos_x);
		intent.putExtra(Y_POS_SUBJECT, pos_y);
		startActivity(intent);
	}
}
