package com.roylenferink.fragmentapp;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.roylenferink.fragmentapp.model.Model;
import com.roylenferink.fragmentapp.view.GridAdapter;
import com.roylenferink.fragmentapp.view.ListAdapter;

/**
 * Created by Roy on 27-3-2015.
 */
public class FragmentGrid extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_grid, container, false);

        FragmentApplication app = (FragmentApplication) view.getContext().getApplicationContext();
        Model model = app.getModel();

        GridAdapter gridAdapter = new GridAdapter(view.getContext().getApplicationContext(), R.layout.grid_item, model.getContacts());

        //set the adapter to the listview
        GridView gvContacts = (GridView) view.findViewById(R.id.gvContacts);
        gvContacts.setAdapter(gridAdapter);

        Button btToggleText = (Button) view.findViewById(R.id.btToggleText);
        btToggleText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView tvName = (TextView) view.findViewById(R.id.tvGridName);
                TextView tvPhone = (TextView) view.findViewById(R.id.tvGridPhone);

                if (tvName.getVisibility() == View.VISIBLE){
                    tvName.setVisibility(View.GONE);
                    tvPhone.setVisibility(View.GONE);
                }else{
                    tvName.setVisibility(View.VISIBLE);
                    tvPhone.setVisibility(View.VISIBLE);
                }
            }
        });

        return view;

    }
}
