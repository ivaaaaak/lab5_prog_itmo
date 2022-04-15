package com.ivaaaak.client.Commands;

import com.ivaaaak.client.CollectionStorage;
import com.ivaaaak.client.util.PersonMaker;

public class InsertCommand extends Command {
    private final CollectionStorage collectionStorage;

    public InsertCommand(CollectionStorage collectionStorage) {
        super("insert");
        this.collectionStorage = collectionStorage;
    }

    @Override
    public CommandResult execute(String arg) {

        if (arg.isEmpty()) {
            return new CommandResult(false, "This command needs an argument. Please try again and enter the key:");
        }
        try {
            Integer key = Integer.valueOf(arg);
            if (collectionStorage.checkIfContains(key)) {
                return new CommandResult(false, "Collection have already got element with this key.");
            }
            collectionStorage.add(key, PersonMaker.makePerson(collectionStorage));
            return new CommandResult(false, "The element has been added");
        } catch (NumberFormatException e) {
            return new CommandResult(false, "KEY is an integer number. Use \"show\" to get information about elements\n");
        }
    }
}
