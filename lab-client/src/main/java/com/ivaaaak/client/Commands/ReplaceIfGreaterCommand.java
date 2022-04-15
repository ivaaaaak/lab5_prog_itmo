package com.ivaaaak.client.Commands;

import com.ivaaaak.client.CollectionStorage;
import com.ivaaaak.client.Data.Person;
import com.ivaaaak.client.UserInputManager;
import com.ivaaaak.client.util.PersonMaker;

public class ReplaceIfGreaterCommand extends Command {

    private final CollectionStorage collectionStorage;
    private final UserInputManager userInputManager;

    public ReplaceIfGreaterCommand(CollectionStorage collectionStorage,
                                   UserInputManager userInputManager) {
        super("replace_if_greater");
        this.collectionStorage = collectionStorage;
        this.userInputManager = userInputManager;
    }

    @Override
    public CommandResult execute(String arg) {
        if (arg.isEmpty()) {
            return new CommandResult(false, "This command needs an argument. Please try again and enter the key:");
        }
        try {
            int key = Integer.parseInt(arg);
            Person newPerson = new PersonMaker(userInputManager).makePerson(collectionStorage);
            if (collectionStorage.replaceIfNewGreater(key, newPerson)) {
                return new CommandResult(false, "The element has been replaced");
            }
            return new CommandResult(false, "The element is greater than a new one ot equal");
        } catch (NumberFormatException e) {
            return new CommandResult(false, "Argument is an integer number. Use \"show\" to get information about elements\n");
        }
    }
}
