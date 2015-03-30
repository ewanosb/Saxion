package com.roylenferink.fragmentapp.model;

/**
 * Created by Roy on 27-3-2015.
 */
public class Contact {

    private String name;
    private String phoneNumber;
    private String location;
    private int image;

    public Contact(String name, String phoneNumber, String location, int image){
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.location = location;
        this.image = image;
    }

    public String getName() {
        return this.name;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public String getLocation() {
        return this.location;
    }

    public int getImage(){
        return this.image;
    }

}
