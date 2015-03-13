package com.roylenferink.contactlist.model;

import android.graphics.Bitmap;
import android.net.Uri;

import java.util.ArrayList;
import java.util.Observable;

/**
 * Created by Roy on 8-3-2015.
 */
public class Model extends Observable{

    private ArrayList<Contact> contacts;

    public Model(){
        this.contacts = new ArrayList<Contact>();
    }

    public void addContact(Contact contact){
        this.contacts.add(contact);
    }

    public ArrayList<Contact> getContacts(){
        return this.contacts;
    }

    public Contact getContactAtPosition(int id){
        return contacts.get(id);
    }

    public void changeContactPhoneNumber(int position, String phoneNumber){
        contacts.get(position).setPhoneNumber(phoneNumber);
        setChanged();
        notifyObservers();
    }

    public void changeContactLocation(int position, String location){
        contacts.get(position).setLocation(location);
        setChanged();
        notifyObservers();
    }

    public void chanceContactImage(int position, Bitmap image){
        contacts.get(position).setImage(image);
        setChanged();
        notifyObservers();
    }

}
