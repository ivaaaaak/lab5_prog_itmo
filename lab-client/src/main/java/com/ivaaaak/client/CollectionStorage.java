package com.ivaaaak.client;

import com.ivaaaak.client.Data.Person;

import java.time.LocalDate;
import java.util.Enumeration;
import java.util.Hashtable;

public class CollectionStorage {
    private Hashtable<Integer, Person> hashtable = new Hashtable<>();
    private LocalDate creationDate;

    public Integer getMaxId() {
        int maxID = 0;
        Enumeration<Integer> keys = hashtable.keys();
        for (int i = 0; i < hashtable.size(); i++) {
            int key = keys.nextElement();
            if (key > maxID) {
                maxID = key;
            }
        }
        return maxID;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public Hashtable<Integer, Person> getHashtable() {
        return hashtable;
    }

    public void initializeHashtable(Hashtable<Integer, Person> ht) {
        creationDate = LocalDate.now();
        hashtable = ht;
    }
}
