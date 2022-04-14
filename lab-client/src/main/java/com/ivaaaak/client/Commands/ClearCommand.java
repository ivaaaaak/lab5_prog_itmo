package com.ivaaaak.client.Commands;

import com.ivaaaak.client.CollectionStorage;

public class ClearCommand extends Command {
    private final CollectionStorage collectionStorage;

    public ClearCommand(CollectionStorage collectionStorage) {
        super("clear");
        this.collectionStorage = collectionStorage;
    }

    @Override
    public CommandResult execute(String inputArg) {
        collectionStorage.clear();
        return new CommandResult(false, "Collection has been cleared");
    }
}
