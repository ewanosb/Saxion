package com.roylenferink.fragmentapp.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.roylenferink.fragmentapp.R;
import com.roylenferink.fragmentapp.model.Contact;

import java.util.List;

/**
 * Created by Roy on 27-3-2015.
 */
public class GridAdapter extends ArrayAdapter<Contact> {

    private LayoutInflater li;
    private ImageView ivContact;
    private TextView tvName, tvPhone;

    public GridAdapter(Context context, int resource, List<Contact> objects) {
        super(context, resource, objects);
        li = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            convertView = li.inflate(R.layout.grid_item, parent, false);
        }

        ivContact = (ImageView) convertView.findViewById(R.id.ivContact);
        tvName = (TextView) convertView.findViewById(R.id.tvGridName);
        tvPhone = (TextView) convertView.findViewById(R.id.tvGridPhone);

        Contact selectedContact = getItem(position);

        ivContact.setImageResource(selectedContact.getImage());
        tvName.setText(selectedContact.getName());
        tvPhone.setText(selectedContact.getPhoneNumber());

        return convertView;
    }
}
