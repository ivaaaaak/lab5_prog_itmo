package com.ivaaaak.client.Commands;

import com.ivaaaak.client.CollectionStorage;
import com.ivaaaak.client.Data.Person;

public class MaxByHairColorCommand extends Command {

    private final CollectionStorage collectionStorage;

    public MaxByHairColorCommand(CollectionStorage collectionStorage) {
        super("max_by_hair_color");
        this.collectionStorage = collectionStorage;
    }

    @Override
    public CommandResult execute(String arg) {
        Person maxPerson = collectionStorage.getMaxColorPerson();

        if (maxPerson == null) {
            return new CommandResult(false, "The collection is empty");
        } else {
            return new CommandResult(false, maxPerson.toString());
        }
    }
}
