package com.roylenferink.contactlist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.roylenferink.contactlist.model.Contact;
import com.roylenferink.contactlist.model.Model;

/**
 * Created by Roy on 8-3-2015.
 */
public class EditContactActivity extends Activity {

    private static final int REQUEST_IMAGE_CODE = 16;

    private Model model;
    private TextView tvFirstName, tvSurName;
    private EditText etPhoneNumber, etLocation;
    private ImageView ivContact;
    private int contactId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_contact);

        ContactApplication app = (ContactApplication) getApplicationContext();
        model = app.getModel();

        Intent intent = getIntent();
        contactId = intent.getIntExtra("contactId", 0);
        Contact contact = model.getContactAtPosition(contactId);

        tvFirstName = (TextView) findViewById(R.id.tvFirstName);
        tvSurName = (TextView) findViewById(R.id.tvSurName);
        etPhoneNumber = (EditText) findViewById(R.id.etPhoneNumber);
        etLocation = (EditText) findViewById(R.id.etLocation);
        ivContact = (ImageView) findViewById(R.id.ivContact);

        if (contact.getImage() != null) {
            ivContact.setImageBitmap(contact.getImage());
        }

        ivContact.setOnClickListener(new ContactImageClickListener());

        tvFirstName.setText(contact.getFirstName());

        if (contact.getInsertion() != null){
            tvSurName.setText(contact.getInsertion() + " " + contact.getSurName());
        }else{
            tvSurName.setText(contact.getSurName());
        }

        etPhoneNumber.setText(contact.getPhoneNumber());
        if (contact.getLocation() != null){
            etLocation.setText(contact.getLocation());
        }

        etPhoneNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                model.changeContactPhoneNumber(contactId, etPhoneNumber.getText().toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        etLocation.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                model.changeContactLocation(contactId, etLocation.getText().toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    private class ContactImageClickListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            Intent imageIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(imageIntent, REQUEST_IMAGE_CODE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CODE){
            if (resultCode == Activity.RESULT_OK){
                model.chanceContactImage(contactId, (android.graphics.Bitmap) data.getExtras().get("data"));
                ivContact.setImageBitmap((android.graphics.Bitmap) data.getExtras().get("data"));
            }
        }
    }
}
