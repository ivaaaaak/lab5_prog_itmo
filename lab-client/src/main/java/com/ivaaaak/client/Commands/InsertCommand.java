package com.ivaaaak.client.Commands;

import com.ivaaaak.client.CollectionStorage;
import com.ivaaaak.client.Data.Person;
import com.ivaaaak.client.util.PersonMaker;

public class InsertCommand extends Command {
    private final CollectionStorage collectionManager;

    public InsertCommand(CollectionStorage collectionManager) {
        super("insert");
        this.collectionManager = collectionManager;
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
            Person p = PersonMaker.initializePerson(collectionManager.getMaxId() + 1);
            collectionManager.getHashtable().put(key, p);
            return new CommandResult(false, "The element has been added");
        }
    }
}