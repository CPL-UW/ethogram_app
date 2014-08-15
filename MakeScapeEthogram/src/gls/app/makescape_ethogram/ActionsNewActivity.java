package gls.app.makescape_ethogram;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class ActionsNewActivity extends Activity implements FragmentActionsHeadline.Communicator{
	FragmentActionsHeadline fragment_a;
    FragmentActionsOptions fragment_b;
    FragmentManager manager;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_activity_layout);
       
        Log.d("actionsNewActivity", "funcionou");

        manager= getFragmentManager();
        fragment_a = (FragmentActionsHeadline) manager.findFragmentById(R.id.fragment);

        fragment_a.setCommunicator(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
    @Override
    public void respond(int position) {
        fragment_b = (FragmentActionsOptions) manager.findFragmentById(R.id.fragment2);

        //landscape
        if(fragment_b != null && fragment_b.isVisible())
        {
            fragment_b.changeData(position);
        }
        //portrait
        else
        {
//            Intent intent = new Intent(this, AnotherActivity.class);
//            intent.putExtra("position", position);
//            startActivity(intent);
        }
    }
}
