package com.ivaaaak.client.Commands;

import com.ivaaaak.client.CollectionStorage;
import com.ivaaaak.client.util.PersonMaker;

public class RemoveLowerCommand extends Command {

    private final CollectionStorage collectionStorage;

    public RemoveLowerCommand(CollectionStorage collectionStorage) {
        super("remove_lower");
        this.collectionStorage = collectionStorage;
    }

    @Override
    public CommandResult execute(String arg) {

        float height = PersonMaker.initializeHeight();
        collectionStorage.removeLowerPerson(height);

        return new CommandResult(false, "Lower elements were removed");
    }
}
