package gls.app.makescape_ethogram;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class SelectTargetActivity extends Activity implements
		GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {

	private static final String DEBUG_TAG = "gls.app.makescape_ethogram.debug";
	private GestureDetectorCompat mDetector;
	private float pos_x;
	private float pos_y;
	private RelativeLayout layout;
	private int numDoubleClick= 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_map_2);
		Toast.makeText(this, "Mark the position of the Target",
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
			image.setImageResource(R.drawable.target);
			
			

			pos_x = e.getX(pointerId);
			pos_y = e.getY(pointerId) - 190;

	
			
			RelativeLayout rl = (RelativeLayout) findViewById(R.id.layout_map);
			
			
			RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
			    RelativeLayout.LayoutParams.WRAP_CONTENT,
			    RelativeLayout.LayoutParams.WRAP_CONTENT);

			image.setX(pos_x);
			image.setY(pos_y);
			rl.addView(image);

            promptTargetDescription();
            return true;
			}
		return true;
	}

    private void promptTargetDescription() {
        //get the target description via alert window
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Target Description");
        alert.setMessage(R.string.selector_prompt_targ);
        final EditText input = new EditText(this);
        alert.setView(input);

        alert.setPositiveButton("Enter", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String description = String.valueOf(input.getText());
                DataSingleton.getSingleton().setTargetDescription(description);
            }
        });

        alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                DataSingleton.getSingleton().setTargetDescription("None");
            }
        });

        alert.show();
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

	public void gotoDone(View v) {
		DataSingleton.getSingleton().setTargetString(pos_x + ", " + pos_y);
		Intent intent = new Intent(this, ConfirmEntryActivity.class);

		startActivity(intent);
	}
	
	public void clear(View v)
	{
		recreate();
	}
}