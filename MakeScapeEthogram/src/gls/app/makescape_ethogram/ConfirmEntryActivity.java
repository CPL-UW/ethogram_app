package gls.app.makescape_ethogram;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class ConfirmEntryActivity extends Activity {
	private static final String DEBUG_TAG = "gls.app.makescape_ethogram.debug";
	private static final String X_POS_SUBJECT = "gls.app.makescape_ethogram.x";
	private static final String Y_POS_SUBJECT = "gls.app.makescape_ethogram.y";
	private static final String X_POS_TARGET = "gls.app.makescape_ethogram.x_target";
	private static final String Y_POS_TARGET = "gls.app.makescape_ethogram.y_target";
	private float pos_x_subject;
	private float pos_y_subject;
	private float pos_x_target;
	private float pos_y_target;
	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_confirm_entry);
		
		pos_x_subject= (Float) getIntent().getExtras().get(X_POS_SUBJECT);
		pos_y_subject = (Float) getIntent().getExtras().get(Y_POS_SUBJECT);
		pos_x_target= (Float) getIntent().getExtras().get(X_POS_TARGET);
		pos_y_target = (Float) getIntent().getExtras().get(Y_POS_TARGET);
		
		Log.d(DEBUG_TAG, pos_x_subject + " " + pos_y_subject + " " + pos_x_target + " " + pos_y_target);
		
	}
}
