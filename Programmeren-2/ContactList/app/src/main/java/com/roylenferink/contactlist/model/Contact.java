package com.roylenferink.contactlist.model;

import android.graphics.Bitmap;
import android.net.Uri;
import android.util.Log;

import java.util.Observable;

/**
 * Created by Roy on 8-3-2015.
 */
public class Contact extends Observable{

    private String firstName;
    private String insertion;
    private String surName;
    private String phoneNumber;
    private String location;
    private Bitmap image;


    public Contact(String firstName, String surName, String phoneNumber, String location){
        this.firstName = firstName;
        this.surName = surName;
        this.phoneNumber = phoneNumber;
        this.location = location;
    }

    public Contact(String firstName, String insertion, String surName, String phoneNumber, String location){
        this.firstName = firstName;
        this.insertion = insertion;
        this.surName = surName;
        this.phoneNumber = phoneNumber;
        this.location = location;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public void setLocation(String location){
        this.location = location;
    }

    public void setImage(Bitmap bitmap){
        this.image = bitmap;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public String getInsertion(){
        return this.insertion;
    }

    public String getSurName(){
        return this.surName;
    }

    public String getPhoneNumber(){
        return this.phoneNumber;
    }

    public String getLocation(){
        return this.location;
    }

    public Bitmap getImage(){
        return this.image;
    }

}
