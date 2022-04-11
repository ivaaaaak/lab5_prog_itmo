package com.ivaaaak.client.Commands;

import com.ivaaaak.client.CollectionStorage;

public class ClearCommand extends Command {
    private final CollectionStorage collectionManager;

    public ClearCommand(CollectionStorage collectionManager) {
        super("clear");
        this.collectionManager = collectionManager;
    }

    @Override
    public CommandResult execute(String inputArg) {
        collectionManager.getHashtable().clear();
        return new CommandResult(false, "Collection has been cleared");
    }
}
