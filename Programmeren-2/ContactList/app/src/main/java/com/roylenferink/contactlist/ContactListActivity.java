package com.roylenferink.contactlist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.roylenferink.contactlist.model.Contact;
import com.roylenferink.contactlist.model.Model;
import com.roylenferink.contactlist.view.ContactAdapter;

import java.util.Observable;
import java.util.Observer;


public class ContactListActivity extends Activity implements Observer{

    private ListView lvContacts;
    private ContactAdapter contactAdapter;
    private Model model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        ContactApplication app = (ContactApplication) getApplicationContext();
        model = app.getModel();
        model.addObserver(this);

        model.addContact(new Contact("Roy", "Lenferink", "0622620675", "Geesteren"));
        model.addContact(new Contact("Irma", "Lenferink", "0637258837", null));
        model.addContact(new Contact("Iris", "Lenferink", "0637258835", null));
        model.addContact(new Contact("First name", "insertion", "Surname", "0612345678", null));

        lvContacts = (ListView) findViewById(R.id.lvContacts);
        contactAdapter = new ContactAdapter(this, R.layout.contact_item, model.getContacts());

        lvContacts.setOnItemClickListener(new ContactListItemClicked());

        lvContacts.setAdapter(contactAdapter);
    }

    @Override
    public void update(Observable observable, Object data) {
        contactAdapter.notifyDataSetChanged();
    }

    protected class ContactListItemClicked implements AdapterView.OnItemClickListener{
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Intent editContactIntent = new Intent(ContactListActivity.this, EditContactActivity.class);
            editContactIntent.putExtra("contactId", position);
            startActivity(editContactIntent);
        }
    }

}
