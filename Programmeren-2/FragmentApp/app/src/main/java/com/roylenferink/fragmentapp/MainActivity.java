package com.roylenferink.fragmentapp;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;

import com.roylenferink.fragmentapp.model.Contact;
import com.roylenferink.fragmentapp.model.Model;
import com.roylenferink.fragmentapp.view.ListAdapter;


public class MainActivity extends ActionBarActivity {

    private Model model;

    private View fragmentListView, fragmentGridView;
    private int screenOrientation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        screenOrientation = getResources().getConfiguration().orientation;

        // add some contacts to the model
        FragmentApplication app = (FragmentApplication) getApplicationContext();
        model = app.getModel();
        model.clear();
        model.addContact(new Contact("Evert Duipmans", "0612345678", "Enschede", R.drawable.avatar));
        model.addContact(new Contact("Wilco Bonestroo", "0698765432", "Hengelo", R.drawable.avatar));
        model.addContact(new Contact("Rogier Hommels", "06321654987", "Delden", R.drawable.avatar));
        model.addContact(new Contact("Paul de Groot", "0655544433", "Gronau", R.drawable.avatar));
        model.addContact(new Contact("Ruud Greven", "0611211211", "Enschede", R.drawable.avatar));

        // get the fragments
        fragmentListView = findViewById(R.id.fragment_list);
        fragmentGridView = findViewById(R.id.fragment_grid);

        // set the visibility when the screen turns
        if (screenOrientation == Configuration.ORIENTATION_PORTRAIT){
            fragmentListView.setVisibility(View.VISIBLE);
            fragmentGridView.setVisibility(View.GONE);
        }else{
            fragmentListView.setVisibility(View.VISIBLE);
            fragmentGridView.setVisibility(View.VISIBLE);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (screenOrientation == Configuration.ORIENTATION_PORTRAIT){
            getMenuInflater().inflate(R.menu.menu_main, menu);
        }

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_listview) {
            fragmentListView.setVisibility(View.VISIBLE);
            fragmentGridView.setVisibility(View.GONE);
        }else if (id == R.id.action_gridview){
            fragmentListView.setVisibility(View.GONE);
            fragmentGridView.setVisibility(View.VISIBLE);
        }

        return super.onOptionsItemSelected(item);
    }
}
