package com.zipcodewilmington.phonebook;

import org.w3c.dom.DOMStringList;

import java.util.*;
//import java.util.HashMap;


/**
 * Created by leon on 1/23/18.
 * Made WAY better by kristofer 6/16/20
 */
            //key is a string, values is a list of strings
            //values with be


public class PhoneBook {

    private final Map<String, List<String>> phonebook;

    public PhoneBook(Map<String, List<String>> map) {

        this.phonebook = map;
    }
    //nullary constructor...
    public PhoneBook() {
        //this refers to phonebook.. the first constructor
        //while we are using a tree map.. the test is expecting a hashmap
        //our next step is to look at documentation of hashmap to see if there is some sort of conversation
        this(new TreeMap<>());
    }

    public void add(String name, String phoneNumber) {

        //if only name.. access key and add the value
        if(phonebook.containsKey(name)) {
            //looking in phonebook finding the name
            phonebook.get(name).add(phoneNumber);
        //if no name and number we are access the existing list and adding it in
        } else {
            //created a pairing..in the map makes a space for key and value if there is no key to start with
            phonebook.put(name,new ArrayList<>() );
            //get
            phonebook.get(name).add(phoneNumber);

        }
    }

    public void addAll(String name, String... phoneNumbers) {
        //phonenumbers bc thats the array we are going thru
        for (String s: phoneNumbers){
            //s represents the phonenumber
            add(name,s);
        }
    }

    public void remove(String name) {
        phonebook.remove(name);
    }



    //based on the test ... we know that test is looking for two hasEntry constructors...
    // they have to be different and have unique signatures

    public Boolean hasEntry(String name, String phoneNumbers) {
        //boolen checking to see is in phone number is in the list
        //contains part of arraylists
        if (phonebook.containsKey(name) && phonebook.get(name).contains(phoneNumbers)) {
            return true;
        }
        return false ;
    }


    //if we did
    public Boolean hasEntry(String name) {
        return phonebook.containsKey(name);
    }

    public List<String> lookup(String name) {
        //want to return values
        return phonebook.get(name);
    }

    public String reverseLookup(String phoneNumber)  {
        return null;
    }

    public List<String> getAllContactNames() {
        return null;
    }

    public Map<String, List<String>> getMap() {
        //at the top, we are leaving it to be a tree map and then now converting it to a
        //hashmap to pass the constructor test
        //before we put just this.phonebook to return the tree map
        return new HashMap(this.phonebook);
    }
}
