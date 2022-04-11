package com.ivaaaak.client.Commands;

import com.ivaaaak.client.CollectionStorage;
import com.ivaaaak.client.Data.Person;

import java.util.Enumeration;
import java.util.StringJoiner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
            Enumeration<Person> enumValue = collectionStorage.getHashtable().elements();
            StringJoiner output = new StringJoiner("\n");

            while (enumValue.hasMoreElements()) {
                Person realPerson = enumValue.nextElement();
                Pattern pattern = Pattern.compile("^" + arg, Pattern.CASE_INSENSITIVE);
                Matcher matcher = pattern.matcher(realPerson.getName());

                if (matcher.find()) {
                    output.add(realPerson.toString());
                }
            }
            if (output.toString().equals("")) {
                return new CommandResult(false, "There aren't any elements whose name starts like this");
            }
            return new CommandResult(false, output.toString());
        }
    }
}
