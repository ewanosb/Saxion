package com.roylenferink.contactlist.view;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.roylenferink.contactlist.R;
import com.roylenferink.contactlist.model.Contact;

import java.util.List;

/**
 * Created by Roy on 8-3-2015.
 */
public class ContactAdapter extends ArrayAdapter<Contact> {

    private LayoutInflater li;
    private TextView tvName, tvPhoneNumber;
    private ImageView ivContactImage, ivCall;

    public ContactAdapter(Context context, int resource, List<Contact> objects) {
        super(context, resource, objects);
        li = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            convertView = li.inflate(R.layout.contact_item, parent, false);
        }

        final Contact contact = getItem(position);

        tvName = (TextView) convertView.findViewById(R.id.tvName);
        tvPhoneNumber = (TextView) convertView.findViewById(R.id.tvNumber);
        ivContactImage = (ImageView) convertView.findViewById(R.id.ivContact);
        ivCall = (ImageView) convertView.findViewById(R.id.ivCall);

        if (contact.getInsertion() != null){
            tvName.setText(contact.getFirstName() + " " + contact.getInsertion() + " " + contact.getSurName());
        }else{
            tvName.setText(contact.getFirstName() + " " + contact.getSurName());
        }
        tvPhoneNumber.setText(contact.getPhoneNumber());

        ivCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:" + contact.getPhoneNumber()));
                v.getContext().startActivity(callIntent);
            }
        });

        if(contact.getImage() != null){
            ivContactImage.setImageBitmap(contact.getImage());
        }

        return convertView;
    }
}
