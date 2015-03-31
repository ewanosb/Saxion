package nl.saxion.view;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import nl.saxion.R;
import nl.saxion.model.Message;

/**
 * Created by Roy on 31-3-2015.
 */
public class MessageAdapter extends ArrayAdapter<Message> {

    private LayoutInflater li;

    public MessageAdapter(Context context, int resource, List<Message> objects) {
        super(context, resource, objects);
        li = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            convertView = li.inflate(R.layout.message_item, parent, false);
        }

        Message selectedMessage = getItem(position);

        TextView tvSender = (TextView) convertView.findViewById(R.id.tvSender);
        TextView tvMessage = (TextView) convertView.findViewById(R.id.tvMessage);
        Priority prOne = (Priority) convertView.findViewById(R.id.prOne);
        Priority prTwo = (Priority) convertView.findViewById(R.id.prTwo);
        Priority prThree = (Priority) convertView.findViewById(R.id.prThree);

        tvSender.setText(selectedMessage.getSender() + ":");
        tvMessage.setText(selectedMessage.getMessage());

        if (selectedMessage.isRead()){
            tvSender.setTextColor(Color.LTGRAY);
            tvMessage.setTextColor(Color.LTGRAY);
        }else{
            tvSender.setTextColor(Color.BLACK);
            tvMessage.setTextColor(Color.BLACK);
        }

        if (selectedMessage.getPriority() == 3){
            prThree.setVisibility(View.VISIBLE);
            prTwo.setVisibility(View.VISIBLE);
            prOne.setVisibility(View.VISIBLE);
        }else if (selectedMessage.getPriority() == 2){
            prThree.setVisibility(View.GONE);
            prTwo.setVisibility(View.VISIBLE);
            prOne.setVisibility(View.VISIBLE);
        }else if (selectedMessage.getPriority() == 1){
            prThree.setVisibility(View.GONE);
            prTwo.setVisibility(View.GONE);
            prOne.setVisibility(View.VISIBLE);
        }

        return convertView;
    }
}
