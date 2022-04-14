package com.ivaaaak.client;

import com.ivaaaak.client.Data.Color;
import com.ivaaaak.client.Data.Location;
import com.ivaaaak.client.Data.Person;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;


public class CollectionStorage {
    private Hashtable<Integer, Person> hashtable = new Hashtable<>();
    private LocalDate creationDate;

    public Integer getMaxId() {
        int maxID = 0;
        for (Map.Entry<Integer, Person> hashtableEntry : hashtable.entrySet()) {
            Person p = hashtableEntry.getValue();
            if (p.getId() > maxID) {
                maxID = p.getId();
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

    public void clear() {
        hashtable.clear();
    }

    public void remove(Integer key) {
        hashtable.remove(key);
    }

    public void add(Integer key, Person p) {
        hashtable.put(key, p);
    }

    public void replace(Integer key, Person newPerson) {
        hashtable.replace(key, newPerson);
    }

    public Person getPerson(Integer key) {
        return hashtable.get(key);
    }

    public ArrayList<Person> getMatchingPeople(Location l) {
        ArrayList<Person> list = new ArrayList<>();

        for (Map.Entry<Integer, Person> hashtableEntry : hashtable.entrySet()) {
            Person p = hashtableEntry.getValue();
            if (p.getLocation().equals(l)) {
                list.add(p);
            }
        }
        return list;

    }
    public ArrayList<Person> getMatchingPeople(String substring) {
        ArrayList<Person> list = new ArrayList<>();

        for (Map.Entry<Integer, Person> hashtableEntry : hashtable.entrySet()) {
            Person p = hashtableEntry.getValue();
            if (p.getName().startsWith(substring)) {
                list.add(p);
            }
        }
        return list;

    }
    public Person getMaxColorPerson() {
        Person maxPerson = null;
        Color maxColor = Color.RED;

        for (Map.Entry<Integer, Person> hashtableEntry : hashtable.entrySet()) {
            Person p = hashtableEntry.getValue();
            if (p.getHairColor().compareTo(maxColor) >= 0) {
                maxColor = p.getHairColor();
                maxPerson = p;
            }
        }
        return maxPerson;
    }
    public void removeLowerPerson(float height) {
        ArrayList<Integer> keys = new ArrayList<>();

        for (Map.Entry<Integer, Person> hashtableEntry : hashtable.entrySet()) {
            Integer currentKey = hashtableEntry.getKey();
            Person oldPerson = hashtable.get(currentKey);

            if (oldPerson.getHeight() - height < 0) {
               keys.add(currentKey);
            }
        }
        for (Integer key : keys) {
            hashtable.remove(key);
        }
    }
    public boolean replaceIfNewGreater(Integer oldKey, Person newPerson) {
        Person oldPerson = hashtable.get(oldKey);
        if (oldPerson.compareTo(newPerson) < 0) {
            hashtable.replace(oldKey, oldPerson, newPerson);
            return true;
        }
        return false;

    }
    public boolean replaceIfNewLower(Integer oldKey, Person newPerson) {
        Person oldPerson = hashtable.get(oldKey);
        if (oldPerson.compareTo(newPerson) > 0) {
            hashtable.replace(oldKey, oldPerson, newPerson);
            return true;
        }
        return false;

    }

    public ArrayList<Integer> getKeysList() {
        ArrayList<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Person> hashtableEntry : hashtable.entrySet()) {
            Integer key = hashtableEntry.getKey();
            list.add(key);
        }
        return list;
    }

    public Integer getMatchingKey(Integer id) {
        for (Map.Entry<Integer, Person> hashtableEntry : hashtable.entrySet()) {
            Integer currentKey = hashtableEntry.getKey();
            Person oldPerson = hashtable.get(currentKey);

            if (oldPerson.getId().equals(id)) {
                return currentKey;
            }
        }
        return null;
    }

}
