package gls.app.makescape_ethogram;

import java.util.Map;

import android.app.Fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class FragmentActionsOptions extends Fragment implements AdapterView.OnItemClickListener{
	TextView text;
	ListView list;
	int headline_position;
	private int father_position;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_options_layout, container, false);
		list = (ListView) view.findViewById(R.id.listView);
		return view;
	}

	
	public void changeData(int position) {

		ArrayAdapter adapter;
		headline_position = position;
		Map<Integer, Headline> map = DataSingleton.getSingleton().getHeadline_map();
		adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, map.get(position).getOptions());
		list.setAdapter(adapter);
		list.setOnItemClickListener(this);
		this.father_position = position;
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		Intent intent = null ;
		
		Map<Integer, Headline> map = DataSingleton.getSingleton().getHeadline_map();
		if (map.get(father_position).getHasTarget().contains(position))
		{
			intent = new Intent(getActivity().getBaseContext(), SelectTargetActivity.class);
			 startActivity(intent);
		}
		
		else 
		{
			intent = new Intent(getActivity().getBaseContext(), ConfirmEntryActivity.class);
			startActivity(intent);
		}
				
	}

}
