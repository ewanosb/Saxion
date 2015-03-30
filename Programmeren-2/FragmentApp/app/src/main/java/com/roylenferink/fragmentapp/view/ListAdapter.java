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
public class ListAdapter extends ArrayAdapter<Contact> {

    private LayoutInflater li;
    private ImageView ivContact;
    private TextView tvListName, tvListPhone, tvListLocation;

    public ListAdapter(Context context, int resource, List<Contact> objects) {
        super(context, resource, objects);
        li = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            convertView = li.inflate(R.layout.list_item, parent, false);
        }

        ivContact = (ImageView) convertView.findViewById(R.id.ivContact);
        tvListName = (TextView) convertView.findViewById(R.id.tvListName);
        tvListPhone = (TextView) convertView.findViewById(R.id.tvListPhone);
        tvListLocation = (TextView) convertView.findViewById(R.id.tvListLocation);

        Contact selectedContact = getItem(position);

        ivContact.setImageResource(selectedContact.getImage());
        tvListName.setText(selectedContact.getName());
        tvListPhone.setText(selectedContact.getPhoneNumber());
        tvListLocation.setText(selectedContact.getLocation());

        return convertView;
    }
}
