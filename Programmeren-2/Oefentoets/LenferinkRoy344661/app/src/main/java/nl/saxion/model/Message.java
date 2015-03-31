package nl.saxion.model;

/**
 * Created by Roy on 31-3-2015.
 */
public class Message {

    private String message;
    private String sender;
    private boolean isRead;
    private int priority;

    public Message(String message, String sender, boolean isRead, int priority){
        this.message = message;
        this.sender = sender;
        this.isRead = isRead;
        this.priority = priority;
    }

    public String getMessage() {
        return message;
    }

    public String getSender() {
        return sender;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read){
        this.isRead = read;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
