package nl.saxion;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.Observable;
import java.util.Observer;

import nl.saxion.model.Message;
import nl.saxion.model.Model;
import nl.saxion.view.MessageAdapter;


public class MainActivity extends Activity implements Observer{

    private Model model;
    private ListView lvMessages;
    private MessageAdapter messageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MessageApplication app = (MessageApplication) getApplicationContext();
        model = app.getModel();
        model.addObserver(this);

        model.addMessage(new Message("Biertje doen vanavond?", "Ruud", false, 3));
        model.addMessage(new Message("Je hebt je tas laten liggen!", "Tristan", true, 2));
        model.addMessage(new Message("Todo: Boek terugbrengen", "Me", true, 2));
        model.addMessage(new Message("Eet je wel goed?", "Mama", true, 1));

        lvMessages = (ListView) findViewById(R.id.lvMessages);

        messageAdapter = new MessageAdapter(getApplicationContext(), R.layout.message_item, model.getMessages());

        lvMessages.setOnItemClickListener(new MessageItemClicked());

        lvMessages.setAdapter(messageAdapter);
    }



    @Override
    public void update(Observable observable, Object data) {
        messageAdapter.notifyDataSetChanged();
    }

    private class MessageItemClicked implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Intent editMessageIntent = new Intent(MainActivity.this, DetailsActivity.class);
            editMessageIntent.putExtra("messageId", position);
            startActivity(editMessageIntent);
        }
    }
}
