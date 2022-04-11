package com.ivaaaak.client.Commands;

import com.ivaaaak.client.CollectionStorage;
import com.ivaaaak.client.Data.Person;
import com.ivaaaak.client.util.PersonMaker;

import java.util.Enumeration;

public class RemoveLowerCommand extends Command {

    private final CollectionStorage collectionStorage;

    public RemoveLowerCommand(CollectionStorage collectionStorage) {
        super("remove_lower");
        this.collectionStorage = collectionStorage;
    }

    @Override
    public CommandResult execute(String arg) {
        Person p = new Person();
        PersonMaker.initializeHeight(p);

        Enumeration<Integer> enumKeys = collectionStorage.getHashtable().keys();

        while (enumKeys.hasMoreElements()) {
            Integer currentKey = enumKeys.nextElement();
            Person oldPerson = collectionStorage.getHashtable().get(currentKey);

            if (oldPerson.compareTo(p) < 0) {
                collectionStorage.getHashtable().remove(currentKey, oldPerson);
            }
        }
        return new CommandResult(false, "Lower elements were removed");
    }
}
