package gls.app.makescape_ethogram;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class AsksForHelpActivity extends Activity implements 
GestureDetector.OnGestureListener,
GestureDetector.OnDoubleTapListener{

	private static final String DEBUG_TAG = "gls.app.makescape_ethogram.debug";
	private static final String X_POS_SUBJECT = "gls.app.makescape_ethogram.x";
	private static final String Y_POS_SUBJECT = "gls.app.makescape_ethogram.y";
	private static final String X_POS_TARGET = "gls.app.makescape_ethogram.x_target";
	private static final String Y_POS_TARGET = "gls.app.makescape_ethogram.y_target";
	private GestureDetectorCompat mDetector; 
	private float pos_x_subject;
	private float pos_y_subject;
	private float pos_x_target;
	private float pos_y_target;
	private RelativeLayout layout; 
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_map_2);
		Toast.makeText(this, "Mark the position of the Target", Toast.LENGTH_LONG).show();
		mDetector = new GestureDetectorCompat(this, this);
		mDetector.setOnDoubleTapListener(this);
		pos_x_subject= (Float) getIntent().getExtras().get(X_POS_SUBJECT);
		pos_y_subject = (Float) getIntent().getExtras().get(Y_POS_SUBJECT);
		
	}




	@Override
	public boolean onDoubleTap(MotionEvent e) {
		int index = e.getActionIndex();
		int pointerId = e.getPointerId(index);
		
		
		
		Log.d(DEBUG_TAG, "this was a double tap" + " " + e.getX(pointerId) + " " + e.getY(pointerId));
		layout = (RelativeLayout) findViewById(R.id.layout_map);
		Button b =  new Button(this);
		b.setText("Target");

		pos_x_target = e.getX(pointerId);  
		pos_y_target = e.getY(pointerId) - 190 ;
		b.setX(pos_x_target);
		b.setY(pos_y_target);//pog total
		layout.addView(b);	
	
		return true;
	}


	@Override
	public boolean onDoubleTapEvent(MotionEvent e) {
		//Log.d(DEBUG_TAG, "this was a double tap event");
		return false;
	}


	@Override
	public boolean onSingleTapConfirmed(MotionEvent e) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean onDown(MotionEvent e) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
			float velocityY) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public void onLongPress(MotionEvent e) {
		// TODO Auto-generated method stub

	}


	@Override
	public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
			float distanceY) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public void onShowPress(MotionEvent e) {
		// TODO Auto-generated method stub

	}


	@Override
	public boolean onSingleTapUp(MotionEvent e) {
		// TODO Auto-generated method stub
		return false;
	}


	public boolean onTouchEvent(MotionEvent event){ 
		this.mDetector.onTouchEvent(event);
		// Be sure to call the superclass implementation
		return super.onTouchEvent(event);
	}
	
	public void gotoDone(View v)
	{
		Intent intent = new Intent(this, ConfirmEntryActivity.class);
		intent.putExtra(X_POS_SUBJECT, pos_x_subject);
		intent.putExtra(Y_POS_SUBJECT, pos_y_subject);
		intent.putExtra(X_POS_TARGET, pos_x_target);
		intent.putExtra(Y_POS_TARGET, pos_y_target);
		
		startActivity(intent);
	}
}