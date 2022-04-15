package com.ivaaaak.client.Commands;

import com.ivaaaak.client.CollectionStorage;
import com.ivaaaak.client.Data.Person;
import com.ivaaaak.client.UserInputManager;
import com.ivaaaak.client.util.PersonMaker;


public class UpdateCommand extends Command {

    private final CollectionStorage collectionStorage;
    private final UserInputManager userInputManager;

    public UpdateCommand(CollectionStorage collectionStorage,
                         UserInputManager userInputManager) {
        super("update");
        this.collectionStorage = collectionStorage;
        this.userInputManager = userInputManager;
    }

    @Override
    public CommandResult execute(String arg) {

        if (arg.isEmpty()) {
            return new CommandResult(false, "This command needs an argument. Please try again and enter the id:");
        }
        try {
            Integer id = Integer.valueOf(arg);
            Integer key = collectionStorage.getMatchingKey(id);
            if (key != null) {
                Person newPerson = new PersonMaker(userInputManager).makePerson(id);
                collectionStorage.replace(key, newPerson);
                return new CommandResult(false, "The element has been updated");
            }
            return new CommandResult(false, "There's no element with this id. Use \"show\" to get information about elements");

        } catch (NumberFormatException e) {
            return new CommandResult(false, "ID is an integer number. Use \"show\" to get information about elements\n");
        }

    }
}
