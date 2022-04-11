package com.ivaaaak.client.Commands;

import com.ivaaaak.client.CollectionStorage;
import com.ivaaaak.client.Data.Person;

import java.util.Enumeration;
import java.util.StringJoiner;

public class ShowCommand extends Command {

    private final CollectionStorage collectionManager;

    public ShowCommand(CollectionStorage collectionManager) {
        super("show");
        this.collectionManager = collectionManager;
    }

    @Override
    public CommandResult execute(String inputArg) {
        if (collectionManager.getHashtable().isEmpty()) {
            return new CommandResult(false, "The collection is empty");
        } else {
            StringJoiner output = new StringJoiner("\n\n");
            Enumeration<Integer> enumKey = collectionManager.getHashtable().keys();

            while (enumKey.hasMoreElements()) {
                Person p = collectionManager.getHashtable().get(enumKey.nextElement());
                output.add(p.toString());
            }
            return new CommandResult(false, output.toString());
        }

    }

}
