package gls.app.makescape_ethogram;

import android.app.Fragment;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class FragmentActionsHeadline extends Fragment implements AdapterView.OnItemClickListener{
	  ListView list;
	    Communicator communicator;

	        @Override
	        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
	            View view = inflater.inflate(R.layout.fragment_headlines_layout, container, false);
	            list = (ListView) view.findViewById(R.id.listViewFragmentA);
	            ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(), R.array.headlines,android.R.layout.simple_list_item_1);
	            list.setAdapter(adapter);
	            list.setOnItemClickListener(this);
	            return view;
	    }

	    @Override
	    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
	        communicator.respond(position);
	    }

	    public interface Communicator
	    {
	        public void respond(int position);
	    }

	    public void setCommunicator (Communicator communicator)
	    {
	        this.communicator = communicator;
	    }
}
