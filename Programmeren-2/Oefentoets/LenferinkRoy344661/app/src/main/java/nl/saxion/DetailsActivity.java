package nl.saxion;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import nl.saxion.model.Message;
import nl.saxion.model.Model;

/**
 * Created by Roy on 31-3-2015.
 */
public class DetailsActivity extends Activity {

    private Model model;
    private TextView tvSender, tvMessage;
    private EditText etPriority;
    private CheckBox cbRead;
    private Button btSave;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        MessageApplication app = (MessageApplication) getApplicationContext();
        model = app.getModel();

        Intent intent = getIntent();
        final int messageId = intent.getIntExtra("messageId", -1);
        Message selectedMessage = model.getMessageAtPosition(messageId);

        tvSender = (TextView) findViewById(R.id.tvSender);
        tvMessage = (TextView) findViewById(R.id.tvMessage);
        etPriority = (EditText) findViewById(R.id.etPriority);
        cbRead = (CheckBox) findViewById(R.id.cbRead);
        btSave = (Button) findViewById(R.id.btSave);

        tvSender.setText(selectedMessage.getSender());
        tvMessage.setText(selectedMessage.getMessage());
        etPriority.setText(selectedMessage.getPriority() + "");
        cbRead.setChecked(selectedMessage.isRead());

        btSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int priority = Integer.parseInt(etPriority.getText().toString());
                if (priority == 1 || priority == 2 || priority == 3){
                    model.changeMessagePriority(messageId, priority);
                    model.setMessageRead(messageId, cbRead.isChecked());
                }
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
