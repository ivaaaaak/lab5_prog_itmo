package com.ivaaaak.client.Commands;

import com.ivaaaak.client.CollectionStorage;
import com.ivaaaak.client.Data.Person;

import java.util.ArrayList;
import java.util.StringJoiner;


public class FilterStartsWithNameCommand extends Command {

    private final CollectionStorage collectionStorage;

    public FilterStartsWithNameCommand(CollectionStorage collectionStorage) {
        super("filter_starts_with_name");
        this.collectionStorage = collectionStorage;
    }

    @Override
    public CommandResult execute(String arg) {
        if (arg.isEmpty()) {
            return new CommandResult(false, "This command needs an argument. Please try again and enter the substring:");
        } else {
            ArrayList<Person> list = collectionStorage.getMatchingPeople(arg);
            if (list == null) {
                return new CommandResult(false, "The collection is empty");
            } else {
                StringJoiner output = new StringJoiner("\n\n");
                for (Person person : list) {
                    output.add(person.toString());
                }
                if (output.toString().isEmpty()) {
                    return new CommandResult(false, "There aren't any elements whose name starts like this");
                }
                return new CommandResult(false, output.toString());
            }
        }
    }
}
