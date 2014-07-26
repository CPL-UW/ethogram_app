package gls.app.makescape_ethogram;

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

public class FragmentActionsOptions extends Fragment implements
		AdapterView.OnItemClickListener {
	TextView text;
	ListView list;
	int headline_position;

	private final String DO_OPTIONS[] = { "Picks up a dowel",
			"Combines dowels", "Creates a working thing",
			"Modifies an already working thing",
			"Touches another child\'s design",
			"Tries to create a group to work on something" };

	private final String APPROACH_OPTIONS[] = {
			"Look at the exhibit and stays longer than ~5s",
			"Looks at other children using the exhibit",
			"Enters the use space",
			"Looks at any of the museum-text in the use space" };

	private final String SAY_OPTIONS[] = { "Asks another child for help",
			"Tells another child to do something",
			"Asks a design-oriented question",
			"Answers a design-oriented question",
			"Says something design-oriented",
			"Explains their design to someone else",
			"Justifies a design choice",
			"Says something about a design failing",
			"Suggests a fix after a fail" };

	private final String[][] OPTIONS = { DO_OPTIONS, APPROACH_OPTIONS,
			SAY_OPTIONS };

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_options_layout,
				container, false);
		// text = (TextView) view.findViewById(R.id.textView);
		list = (ListView) view.findViewById(R.id.listView);
		return view;
	}

	public void changeData(int position) {
		// String[] description =
		// getResources().getStringArray(R.array.description);
		// text.setText(description[position]);
		// String[] head = getResources().getStringArray(R.array.headlines_2);
		ArrayAdapter adapter;
		headline_position = position;

		switch (position) {
		case 0:
			adapter = ArrayAdapter.createFromResource(getActivity(),
					R.array.options_do, android.R.layout.simple_list_item_1);
			break;
		case 1:
			adapter = ArrayAdapter.createFromResource(getActivity(),
					R.array.options_approach,
					android.R.layout.simple_list_item_1);
			break;
		case 2:
			adapter = ArrayAdapter.createFromResource(getActivity(),
					R.array.options_say, android.R.layout.simple_list_item_1);
			break;
		default:
			adapter = ArrayAdapter.createFromResource(getActivity(),
					R.array.options_do, android.R.layout.simple_list_item_1);
		}

		list.setAdapter(adapter);
		list.setOnItemClickListener(this);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		DataSingleton.getSingleton().setActionString(
				OPTIONS[headline_position][position]);
		// TODO Auto-generated method stub
		if (headline_position == 0) { // Does Things
			Intent intent = null;
			switch (position) {
			case 0:
				intent = new Intent(getActivity().getBaseContext(),
						ConfirmEntryActivity.class);
				startActivity(intent);
				break;
			case 1:
				// Toast.makeText(getActivity(), position + " was clicked",
				// Toast.LENGTH_LONG).show();
				intent = new Intent(getActivity().getBaseContext(),
						ConfirmEntryActivity.class);
				startActivity(intent);
				break;
			case 2:
				intent = new Intent(getActivity().getBaseContext(),
						ConfirmEntryActivity.class);
				startActivity(intent);
				break;
			case 3:
				intent = new Intent(getActivity().getBaseContext(),
						ConfirmEntryActivity.class);
				startActivity(intent);
				break;
			case 4:
				intent = new Intent(getActivity().getBaseContext(),
						ConfirmEntryActivity.class);
				startActivity(intent);
				break;
			case 5:
				intent = new Intent(getActivity().getBaseContext(),
						ConfirmEntryActivity.class);
				startActivity(intent);
				break;
			default:
				break;
			}
		} else if (headline_position == 1) { // Approaches the exhibit
			Intent intent = null;

			switch (position) {
			case 0:
				intent = new Intent(getActivity().getBaseContext(),
						ConfirmEntryActivity.class);
				startActivity(intent);
				break;
			case 1:
				// Toast.makeText(getActivity(), position + " was clicked",
				// Toast.LENGTH_LONG).show();
				intent = new Intent(getActivity().getBaseContext(),
						SelectTargetActivity.class);
				startActivity(intent);
				break;
			case 2:
				intent = new Intent(getActivity().getBaseContext(),
						ConfirmEntryActivity.class);
				startActivity(intent);
				break;
			case 3:
				intent = new Intent(getActivity().getBaseContext(),
						ConfirmEntryActivity.class);
				startActivity(intent);
				break;
			default:
				break;
			}

		} else if (headline_position == 2) { // Says Things
			Intent intent = null;
			switch (position) {
			case 0:
				intent = new Intent(getActivity().getBaseContext(),
						SelectTargetActivity.class);
				startActivity(intent);
				break;
			case 1:
				// Toast.makeText(getActivity(), position + " was clicked",
				// Toast.LENGTH_LONG).show();
				intent = new Intent(getActivity().getBaseContext(),
						SelectTargetActivity.class);
				startActivity(intent);
				break;
			case 2:
				intent = new Intent(getActivity().getBaseContext(),
						SelectTargetActivity.class);
				startActivity(intent);
				break;
			case 3:
				intent = new Intent(getActivity().getBaseContext(),
						SelectTargetActivity.class);
				startActivity(intent);
				break;
			case 4:
				intent = new Intent(getActivity().getBaseContext(),
						ConfirmEntryActivity.class);
				startActivity(intent);
				break;
			case 5:
				intent = new Intent(getActivity().getBaseContext(),
						SelectTargetActivity.class);
				startActivity(intent);
				break;
			case 6:
				intent = new Intent(getActivity().getBaseContext(),
						ConfirmEntryActivity.class);
				startActivity(intent);
				break;
			case 7:
				intent = new Intent(getActivity().getBaseContext(),
						ConfirmEntryActivity.class);
				startActivity(intent);
				break;
			case 8:
				intent = new Intent(getActivity().getBaseContext(),
						ConfirmEntryActivity.class);
				startActivity(intent);
				break;
			default:
				break;
			}
		}
	}
}
