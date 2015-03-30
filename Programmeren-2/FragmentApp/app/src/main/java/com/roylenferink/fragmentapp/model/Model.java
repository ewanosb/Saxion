package com.roylenferink.fragmentapp.model;

import java.util.ArrayList;

/**
 * Created by Roy on 27-3-2015.
 */
public class Model {

    private ArrayList<Contact> contacts;

    public Model(){
        this.contacts = new ArrayList<Contact>();
    }

    public ArrayList<Contact> getContacts(){
        return this.contacts;
    }

    public void addContact(Contact contact){
        this.contacts.add(contact);
    }

    public void clear(){
        this.contacts.clear();
    }

}
