package com.ivaaaak.client.Commands;

import com.ivaaaak.client.CollectionStorage;

import java.util.StringJoiner;

public class ShowCommand extends Command {

    private final CollectionStorage collectionStorage;

    public ShowCommand(CollectionStorage collectionStorage) {
        super("show");
        this.collectionStorage = collectionStorage;
    }

    @Override
    public CommandResult execute(String inputArg) {

        if (collectionStorage.getHashtable().isEmpty()) {
            return new CommandResult(false, "The collection is empty");
        }
        StringJoiner output = new StringJoiner("\n\n");
        for (Integer key : collectionStorage.getKeysList()) {
            output.add(key + " = " + collectionStorage.getPerson(key).toString());
        }
        return new CommandResult(false, output.toString());
    }

}
