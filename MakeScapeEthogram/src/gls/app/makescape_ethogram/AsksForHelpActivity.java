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
	private static final String X_POS = "gls.app.makescape_ethogram.x";
	private static final String Y_POS = "gls.app.makescape_ethogram.y";
	private GestureDetectorCompat mDetector; 
	private float pos_x;
	private float pos_y;
	private RelativeLayout layout; 
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_map_2);
		Toast.makeText(this, "Mark the position of the Target", Toast.LENGTH_LONG).show();
		mDetector = new GestureDetectorCompat(this, this);
		mDetector.setOnDoubleTapListener(this);
		
	}


	@Override
	public boolean onDoubleTap(MotionEvent e) {
		int index = e.getActionIndex();
		int pointerId = e.getPointerId(index);
		
		
		
		Log.d(DEBUG_TAG, "this was a double tap" + " " + e.getX(pointerId) + " " + e.getY(pointerId));
		layout = (RelativeLayout) findViewById(R.id.layout_map);
		Button b =  new Button(this);
		b.setText("Target");

		pos_x = e.getX(pointerId);  
		pos_y = e.getY(pointerId) - 190 ;
		b.setX(pos_x);
		b.setY(pos_y);//pog total
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
//		Intent intent = new Intent(this, Done.class);
//		intent.putExtra("X_POS", pos_x);
//		intent.putExtra("Y_POS", pos_y);
//		startActivity(intent);
	}
}