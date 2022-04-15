package com.ivaaaak.client;

import com.ivaaaak.client.Data.Color;
import com.ivaaaak.client.Data.Location;
import com.ivaaaak.client.Data.Person;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class CollectionStorage {
    private Hashtable<Integer, Person> hashtable = new Hashtable<>();
    private LocalDate creationDate;

    public Integer getMaxId() {
        int maxID = 0;
        for (Map.Entry<Integer, Person> hashtableEntry : hashtable.entrySet()) {
            Person person = hashtableEntry.getValue();
            if (person.getId() > maxID) {
                maxID = person.getId();
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

    public void initializeHashtable(Hashtable<Integer, Person> fileHashtable) {
        creationDate = LocalDate.now();
        hashtable = fileHashtable;
    }

    public void clear() {
        hashtable.clear();
    }

    public void remove(Integer key) {
        hashtable.remove(key);
    }

    public void add(Integer key, Person person) {
        hashtable.put(key, person);
    }

    public void replace(Integer key, Person newPerson) {
        hashtable.replace(key, newPerson);
    }

    public Person getPerson(Integer key) {
        return hashtable.get(key);
    }

    public List<Person> getMatchingPeople(Location location) {
        ArrayList<Person> list = new ArrayList<>();

        for (Map.Entry<Integer, Person> hashtableEntry : hashtable.entrySet()) {
            Person person = hashtableEntry.getValue();
            if (person.getLocation().equals(location)) {
                list.add(person);
            }
        }
        return list;

    }
    public List<Person> getMatchingPeople(String substring) {
        ArrayList<Person> list = new ArrayList<>();

        for (Map.Entry<Integer, Person> hashtableEntry : hashtable.entrySet()) {
            Person person = hashtableEntry.getValue();
            if (person.getName().startsWith(substring)) {
                list.add(person);
            }
        }
        return list;

    }
    public Person getMaxColorPerson() {
        Person maxPerson = null;
        Color maxColor = Color.RED;

        for (Map.Entry<Integer, Person> hashtableEntry : hashtable.entrySet()) {
            Person person = hashtableEntry.getValue();
            if (person.getHairColor().compareTo(maxColor) >= 0) {
                maxColor = person.getHairColor();
                maxPerson = person;
            }
        }
        return maxPerson;
    }
    public void removeLowerPerson(Person person) {
        ArrayList<Integer> keys = new ArrayList<>();

        for (Map.Entry<Integer, Person> hashtableEntry : hashtable.entrySet()) {
            Integer currentKey = hashtableEntry.getKey();
            Person oldPerson = hashtable.get(currentKey);

            if (oldPerson.compareTo(person) < 0) {
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

    public Set<Integer> getKeysSet() {
        return hashtable.keySet();
    }

    public boolean containsKey(Integer key) {
        return getKeysSet().contains(key);
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
