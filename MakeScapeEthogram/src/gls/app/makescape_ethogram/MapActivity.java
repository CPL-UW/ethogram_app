package gls.app.makescape_ethogram;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.*;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v4.view.MotionEventCompat;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView.FindListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.view.GestureDetector;

public class MapActivity extends Activity implements
		GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {
	private GestureDetectorCompat mDetector;
	private float pos_x;
	private float pos_y;
	private RelativeLayout layout;
	private int numDoubleClick;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_map);
		Toast.makeText(this, "Double Tap to Mark the position of the Subject",
				Toast.LENGTH_LONG).show();
		mDetector = new GestureDetectorCompat(this, this);
		mDetector.setOnDoubleTapListener(this);

	}

	@Override
	public boolean onDoubleTap(MotionEvent e) {
			if (numDoubleClick++ < 1)
			{
			
			int index = e.getActionIndex();
			int pointerId = e.getPointerId(index);
			
			ImageView image = new ImageView(this);
			image.setImageResource(R.drawable.subject);
			
			
	//		
	//		
	//
	//		Log.d("gls.app.makescape_ethogram.debug", "this was a double tap" + " "
	//				+ e.getX(pointerId) + " " + e.getY(pointerId));
	//		layout = (RelativeLayout) findViewById(R.id.layout_map);
	//		Button b = new Button(this);
	//		b.setText("Subject");
	//
			pos_x = e.getX(pointerId);
			pos_y = e.getY(pointerId) - 190;
	//		b.setX(pos_x);
	//		b.setY(pos_y);// pog total
	
			
			RelativeLayout rl = (RelativeLayout) findViewById(R.id.layout_map);
			
			
			RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
			    RelativeLayout.LayoutParams.WRAP_CONTENT,
			    RelativeLayout.LayoutParams.WRAP_CONTENT);
			//lp.addRule(RelativeLayout.BELOW, R.id.ButtonRecalculate);
			//lp.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
			
			
			image.setX(pos_x);
			image.setY(pos_y);
			rl.addView(image);

            promptSubjectDescription();
            return true;
			}
		return true;
	}

	@Override
	public boolean onDoubleTapEvent(MotionEvent e) {
		// Log.d(DEBUG_TAG, "this was a double tap event");
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

	public boolean onTouchEvent(MotionEvent event) {
		this.mDetector.onTouchEvent(event);
		// Be sure to call the superclass implementation
		return super.onTouchEvent(event);
	}

	public void gotoActions(View v) {
		//DataSingleton.getSingleton().setSubjectString(pos_x + ", " + pos_y);
		//Intent intent = new Intent(this, ActionsActivity.class);
		Log.d("Map", "lflfl");
		Intent intent = new Intent(this, ActionsNewActivity.class);
		startActivity(intent);
	}

    public void promptSubjectDescription() {
        //get the subject description via alert window
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Subject Description");
        alert.setMessage(R.string.selector_prompt_subj);
        final EditText input = new EditText(this);
        alert.setView(input);

        alert.setPositiveButton("Enter", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String description = String.valueOf(input.getText());
                DataSingleton.getSingleton().setSubjectDescription(description);
            }
        });

        alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                DataSingleton.getSingleton().setSubjectDescription("None");
            }
        });

        alert.show();
    }

	public void clearActivity(View v)
	{
		recreate();
	}
}
