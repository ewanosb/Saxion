package com.roylenferink.fragmentapp;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.roylenferink.fragmentapp.model.Model;
import com.roylenferink.fragmentapp.view.ListAdapter;

import org.w3c.dom.Text;

/**
 * Created by Roy on 27-3-2015.
 */
public class FragmentList extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_list, container, false);

        FragmentApplication app = (FragmentApplication) view.getContext().getApplicationContext();
        Model model = app.getModel();

        ListAdapter listAdapter = new ListAdapter(view.getContext().getApplicationContext(), R.layout.list_item, model.getContacts());

        //set the adapter to the listview
        ListView lvContacts = (ListView) view.findViewById(R.id.lvContacts);
        lvContacts.setAdapter(listAdapter);

        Button btToggleInformation = (Button) view.findViewById(R.id.btToggleInformation);
        btToggleInformation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView tvPhone = (TextView) view.findViewById(R.id.tvListPhone);
                TextView tvLocation = (TextView) view.findViewById(R.id.tvListLocation);

                if (tvPhone.getVisibility() == View.VISIBLE){
                    tvPhone.setVisibility(View.GONE);
                    tvLocation.setVisibility(View.VISIBLE);
                }else{
                    tvPhone.setVisibility(View.VISIBLE);
                    tvLocation.setVisibility(View.GONE);
                }
            }
        });

        return view;
    }
}
