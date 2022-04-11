package com.ivaaaak.client.Commands;

import com.ivaaaak.client.CollectionStorage;
import com.ivaaaak.client.Data.Person;
import com.ivaaaak.client.util.PersonMaker;

public class ReplaceIfLowerCommand extends Command {

    private final CollectionStorage collectionStorage;

    public ReplaceIfLowerCommand(CollectionStorage collectionStorage) {
        super("replace_if_greater");
        this.collectionStorage = collectionStorage;
    }

    @Override
    public CommandResult execute(String arg) {
        if (arg.isEmpty()) {
            return new CommandResult(false, "This command needs an argument. Please try again and enter the key:");
        } else {
            int key;
            try {
                key = Integer.parseInt(arg);
            } catch (NumberFormatException e) {
                return new CommandResult(false, "KEY is an integer number. Use \"show\" to get information about elements\n");
            }
            Person oldPerson = collectionStorage.getHashtable().get(key);
            Person p = PersonMaker.initializePerson(collectionStorage.getMaxId() + 1);
            if (oldPerson.compareTo(p) > 0) {
                collectionStorage.getHashtable().replace(key, oldPerson, p);
                return new CommandResult(false, "The element has been replaced");
            }

            return new CommandResult(false, "The element is lower than a new one");
        }
    }
}
