package com.ivaaaak.client.Commands;

import com.ivaaaak.client.CollectionStorage;
import com.ivaaaak.client.util.FileManager;
import com.ivaaaak.client.util.JsonParser;

public class SaveCommand extends Command {
    private final CollectionStorage collectionManager;


    public SaveCommand(CollectionStorage collectionManager) {
        super("save");
        this.collectionManager = collectionManager;

    }

    @Override
    public CommandResult execute(String inputArg) {
        FileManager.write(JsonParser.serialize(collectionManager.getHashtable()), FileManager.FILE_PATH);
        return new CommandResult(false, "Collection has been saved");
    }
}
