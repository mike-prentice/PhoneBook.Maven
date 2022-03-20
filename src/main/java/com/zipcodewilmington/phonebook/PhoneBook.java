package com.zipcodewilmington.phonebook;

import java.util.*;
import java.util.HashMap;


/**
 * Created by leon on 1/23/18.
 * Made WAY better by kristofer 6/16/20
 */
public class PhoneBook {

    private final Map<String, List<String>> phonebook;

    public PhoneBook(Map<String, List<String>> map) {

        this.phonebook = new LinkedHashMap<>();
        this.phonebook.putAll(map);
    }

    public PhoneBook() {
        this(new HashMap<>());
    }

    public void add(String name, String phoneNumber) {
        phonebook.computeIfAbsent(name, k -> new ArrayList<>());
        phonebook.get(name).add(phoneNumber);
    }

    public void addAll(String name, String... phoneNumbers) {
        phonebook.computeIfAbsent(name, k -> new ArrayList<>());
        for (String s : phoneNumbers) {
            phonebook.get(name).add(s);
        }
    }

    public void remove(String name) {
        phonebook.remove(name);
    }

    public Boolean hasEntry(String name) {
        return phonebook.containsKey(name);
    }

    public List<String> lookup(String name) {
        return phonebook.get(name);
    }

    public String reverseLookup(String phoneNumber)  {

        for (String name : phonebook.keySet()){
            if (phonebook.get(name).contains(phoneNumber)){
              return name;
            }
        }
        return null;
        }

    public List<String> getAllContactNames() {
        ArrayList<String> names = new ArrayList<>();
        names.addAll(phonebook.keySet());

        return names;
    }

    public Map<String, List<String>> getMap() {
        return phonebook;
    }
}
