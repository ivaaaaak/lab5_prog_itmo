package com.ivaaaak.client.Commands;

import com.ivaaaak.client.CollectionStorage;
import com.ivaaaak.client.Data.Person;

import java.util.StringJoiner;

public class ShowCommand extends Command {

    private final CollectionStorage collectionManager;

    public ShowCommand(CollectionStorage collectionManager) {
        super("show");
        this.collectionManager = collectionManager;
    }

    @Override
    public CommandResult execute(String inputArg) {
        StringJoiner output = new StringJoiner("\n\n");
        for (Person person : collectionManager.getElementsList()) {
            output.add(person.toString());
        }
        if (output.toString().isEmpty()) {
            return new CommandResult(false, "The collection is empty");
        }
        return new CommandResult(false, output.toString());

    }

}
