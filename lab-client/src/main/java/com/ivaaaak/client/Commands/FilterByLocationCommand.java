package com.ivaaaak.client.Commands;

import com.ivaaaak.client.CollectionStorage;
import com.ivaaaak.client.Data.Location;
import com.ivaaaak.client.Data.Person;
import com.ivaaaak.client.util.LocationMaker;

import java.util.Enumeration;
import java.util.StringJoiner;

public class FilterByLocationCommand extends Command {

    private final CollectionStorage collectionStorage;

    public FilterByLocationCommand(CollectionStorage collectionStorage) {
        super("filter_by_location");
        this.collectionStorage = collectionStorage;
    }

    @Override
    public CommandResult execute(String arg) {
        Location l = LocationMaker.initialize();

        Enumeration<Person> enumValue = collectionStorage.getHashtable().elements();
        StringJoiner output = new StringJoiner("\n");

        while (enumValue.hasMoreElements()) {
            Person p = enumValue.nextElement();

            if (p.getLocation().equals(l)) {
                output.add(p.toString());
            }
        }
        if (output.toString().equals("")) {
            return new CommandResult(false, "There aren't any elements with this location");
        }
        return new CommandResult(false, output.toString());

    }
}
