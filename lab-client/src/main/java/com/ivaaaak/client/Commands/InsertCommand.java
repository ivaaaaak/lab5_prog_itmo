package com.ivaaaak.client.Commands;

import com.ivaaaak.client.CollectionStorage;
import com.ivaaaak.client.Data.Person;
import com.ivaaaak.client.UserInputManager;
import com.ivaaaak.client.util.PersonMaker;

public class InsertCommand extends Command {
    private final CollectionStorage collectionStorage;
    private final UserInputManager userInputManager;

    public InsertCommand(CollectionStorage collectionStorage,
                         UserInputManager userInputManager) {
        super("insert");
        this.collectionStorage = collectionStorage;
        this.userInputManager = userInputManager;
    }

    @Override
    public CommandResult execute(String arg) {

        if (arg.isEmpty()) {
            return new CommandResult(false, "This command needs an argument. Please try again and enter the key:");
        }
        try {
            Integer key = Integer.valueOf(arg);
            if (collectionStorage.containsKey(key)) {
                return new CommandResult(false, "Collection have already got element with this key.");
            }
            Person newPerson = new PersonMaker(userInputManager).makePerson(collectionStorage);
            collectionStorage.add(key, newPerson);
            return new CommandResult(false, "The element has been added");
        } catch (NumberFormatException e) {
            return new CommandResult(false, "KEY is an integer number. Use \"show\" to get information about elements\n");
        }
    }
}
