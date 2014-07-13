package gls.app.makescape_ethogram;

import android.app.Fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
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

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_options_layout, container, false);
		//text = (TextView) view.findViewById(R.id.textView);
		list = (ListView) view.findViewById(R.id.listView);
		return view;
	}

	public void changeData(int position) {
		//String[] description = getResources().getStringArray(R.array.description);
		//text.setText(description[position]);
		//String[] head = getResources().getStringArray(R.array.headlines_2);
		ArrayAdapter adapter;
		headline_position = position;

		switch (position)
		{
		case 0:
			adapter = ArrayAdapter.createFromResource(getActivity(), R.array.options_do,android.R.layout.simple_list_item_1);
			break;
		case 1:
			adapter = ArrayAdapter.createFromResource(getActivity(), R.array.options_approach,android.R.layout.simple_list_item_1);
			break;
		case 2:
			adapter = ArrayAdapter.createFromResource(getActivity(), R.array.options_say,android.R.layout.simple_list_item_1);
			break;
		default:
			adapter = ArrayAdapter.createFromResource(getActivity(), R.array.options_do,android.R.layout.simple_list_item_1);
		}

		list.setAdapter(adapter);
		list.setOnItemClickListener(this);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
		if(headline_position == 0){ //Does Things
			Intent intent = null ; 
			switch(position)
			{
			case 0:
				intent = new Intent(getActivity().getBaseContext(), ConfirmEntryActivity.class);
				 startActivity(intent);
				break;
			case 1:
				//Toast.makeText(getActivity(), position + " was clicked", Toast.LENGTH_LONG).show();
				intent = new Intent(getActivity().getBaseContext(), ConfirmEntryActivity.class);
				 startActivity(intent);
				break;
			case 2:
				intent = new Intent(getActivity().getBaseContext(), ConfirmEntryActivity.class);
				 startActivity(intent);
				break;
			case 3:
				intent = new Intent(getActivity().getBaseContext(), ConfirmEntryActivity.class);
				 startActivity(intent);
				break;
			case 4:
				intent = new Intent(getActivity().getBaseContext(), ConfirmEntryActivity.class);
				 startActivity(intent);
				break;
			case 5:
				intent = new Intent(getActivity().getBaseContext(), ConfirmEntryActivity.class);
				 startActivity(intent);
				break;
			default:
				break;
			}
		}
		else if (headline_position == 1){ //Approaches the exhibit
			Intent intent = null ; 
			
			
			switch(position)
			{
			case 0:
				intent = new Intent(getActivity().getBaseContext(), ConfirmEntryActivity.class);
				startActivity(intent);
				break;
			case 1:
				//Toast.makeText(getActivity(), position + " was clicked", Toast.LENGTH_LONG).show();
				 intent = new Intent(getActivity().getBaseContext(), SelectTargetActivity.class);
				 startActivity(intent);
				break;
			case 2:
				intent = new Intent(getActivity().getBaseContext(), ConfirmEntryActivity.class);
				 startActivity(intent);
				break;
			case 3:
				intent = new Intent(getActivity().getBaseContext(), ConfirmEntryActivity.class);
				 startActivity(intent);
				break;
			default:
				break;
			}
			
			
		}
		else if (headline_position == 2){ // Says Things
			Intent intent = null ; 
			switch(position)
			{
			case 0:
				intent = new Intent(getActivity().getBaseContext(), SelectTargetActivity.class);
				 startActivity(intent);
				break;
			case 1:
				//Toast.makeText(getActivity(), position + " was clicked", Toast.LENGTH_LONG).show();
				intent = new Intent(getActivity().getBaseContext(), SelectTargetActivity.class);
				 startActivity(intent);
				break;
			case 2:
				intent = new Intent(getActivity().getBaseContext(), SelectTargetActivity.class);
				 startActivity(intent);
				break;
			case 3:
				intent = new Intent(getActivity().getBaseContext(), SelectTargetActivity.class);
				 startActivity(intent);
				break;
			case 4:
				intent = new Intent(getActivity().getBaseContext(), ConfirmEntryActivity.class);
				 startActivity(intent);
				break;
			case 5:
				intent = new Intent(getActivity().getBaseContext(), SelectTargetActivity.class);
				 startActivity(intent);
				break;
			case 6:
				intent = new Intent(getActivity().getBaseContext(), ConfirmEntryActivity.class);
				 startActivity(intent);
				break;
			case 7:
				intent = new Intent(getActivity().getBaseContext(), ConfirmEntryActivity.class);
				 startActivity(intent);
				break;
			case 8:
				intent = new Intent(getActivity().getBaseContext(), ConfirmEntryActivity.class);
				 startActivity(intent);
				break;
			default:
				break;
			}
		}
	}

}
