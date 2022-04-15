package com.ivaaaak.client.Commands;

import com.ivaaaak.client.CollectionStorage;
import com.ivaaaak.client.Data.Person;
import com.ivaaaak.client.UserInputManager;
import com.ivaaaak.client.util.PersonMaker;

public class RemoveLowerCommand extends Command {

    private final CollectionStorage collectionStorage;
    private final UserInputManager userInputManager;

    public RemoveLowerCommand(CollectionStorage collectionStorage,
                              UserInputManager userInputManager) {
        super("remove_lower");
        this.collectionStorage = collectionStorage;
        this.userInputManager = userInputManager;
    }

    @Override
    public CommandResult execute(String arg) {
        Person person = new PersonMaker(userInputManager).makePerson(collectionStorage);
        collectionStorage.removeLowerPerson(person);
        return new CommandResult(false, "Lower elements were removed");
    }
}
