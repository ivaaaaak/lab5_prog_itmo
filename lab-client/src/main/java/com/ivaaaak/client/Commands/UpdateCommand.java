package com.ivaaaak.client.Commands;

import com.ivaaaak.client.CollectionStorage;
import com.ivaaaak.client.Data.Person;
import com.ivaaaak.client.util.PersonMaker;


public class UpdateCommand extends Command {

    private final CollectionStorage collectionStorage;

    public UpdateCommand(CollectionStorage collectionStorage) {
        super("update");
        this.collectionStorage = collectionStorage;
    }

    @Override
    public CommandResult execute(String arg) {

        if (arg.isEmpty()) {
            return new CommandResult(false, "This command needs an argument. Please try again and enter the id:");
        } else {
            try {
                Integer id = Integer.valueOf(arg);
                Integer key = collectionStorage.getMatchingKey(id);
                if (!(key == null)) {
                    Person newPerson = new Person(id);
                    PersonMaker.initializePerson(newPerson);
                    collectionStorage.replace(key, newPerson);
                    return new CommandResult(false, "The element has been updated");
                }
                return new CommandResult(false, "There's no element with this id. Use \"show\" to get information about elements");

            } catch (NumberFormatException e) {
                return new CommandResult(false, "ID is an integer number. Use \"show\" to get information about elements\n");
            }

        }
    }
}
