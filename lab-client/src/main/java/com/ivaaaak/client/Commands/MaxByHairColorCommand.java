package com.ivaaaak.client.Commands;

import com.ivaaaak.client.CollectionStorage;
import com.ivaaaak.client.Data.Color;
import com.ivaaaak.client.Data.Person;

import java.util.Enumeration;

public class MaxByHairColorCommand extends Command {

    private final CollectionStorage collectionStorage;

    public MaxByHairColorCommand(CollectionStorage collectionStorage) {
        super("max_by_hair_color");
        this.collectionStorage = collectionStorage;
    }

    @Override
    public CommandResult execute(String arg) {
        Person maxPerson = null;
        Enumeration<Person> enumValue = collectionStorage.getHashtable().elements();

        while (enumValue.hasMoreElements()) {
            Person p = enumValue.nextElement();
            if (p.getHairColor().equals(Color.ORANGE)) {
                maxPerson = p;
                break;
            } else if (p.getHairColor().equals(Color.BLUE)) {
                maxPerson = p;
            } else if (p.getHairColor().equals(Color.RED)) {
                maxPerson = p;
            }
        }
        assert maxPerson != null;
        return new CommandResult(false, maxPerson.toString());
    }
}
