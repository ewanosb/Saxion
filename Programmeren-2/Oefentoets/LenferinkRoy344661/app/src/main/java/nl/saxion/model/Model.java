package nl.saxion.model;

import java.util.ArrayList;
import java.util.Observable;

/**
 * Created by Roy on 31-3-2015.
 */
public class Model extends Observable {

    private ArrayList<Message> messages;

    public Model(){
        this.messages = new ArrayList<>();
    }

    public ArrayList<Message> getMessages(){
        return this.messages;
    }

    public Message getMessageAtPosition(int position){
        return this.messages.get(position);
    }

    public void addMessage(Message message){
        this.messages.add(message);
    }

    public void changeMessagePriority(int messageId, int priority){
        this.messages.get(messageId).setPriority(priority);
        setChanged();
        notifyObservers();
    }

    public void setMessageRead(int messageId, boolean read){
        this.messages.get(messageId).setRead(read);
        setChanged();
        notifyObservers();
    }

}
