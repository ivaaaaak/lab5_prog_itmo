package com.ivaaaak.client.util;

import com.ivaaaak.client.CollectionStorage;
import com.ivaaaak.client.Data.Person;
import com.ivaaaak.client.Data.Color;
import com.ivaaaak.client.Data.Country;
import com.ivaaaak.client.UserInputManager;

import java.util.Arrays;

public final class PersonMaker {

    private PersonMaker() {

    }

    public static Person makePerson(CollectionStorage collectionStorage) {
        return new Person(collectionStorage, getInputName(), CoordinatesMaker.makeCoordinates(),
                getInputHeight(), getInputWeight(), getInputColor(), getInputCountry(),
                LocationMaker.makeLocation());
    }
    public static Person makePerson(Integer id) {
        return new Person(id, getInputName(), CoordinatesMaker.makeCoordinates(),
                getInputHeight(), getInputWeight(), getInputColor(), getInputCountry(),
                LocationMaker.makeLocation());
    }


    public static String getInputName() {
        System.out.println("Enter NAME: (cannot be an empty string)");

        String name = null;
        while (name == null) {
            name = PersonConverter.convertToName(UserInputManager.readLine());
        }
        return name;
    }

    public static Float getInputHeight() {
        System.out.println("Enter HEIGHT (more than 0 or null):");
        return PersonConverter.convertToHeightOrWeight(UserInputManager.readLine());
    }

    public static Float getInputWeight() {
        System.out.println("Enter WEIGHT (more than 0 or null):");
        return PersonConverter.convertToHeightOrWeight(UserInputManager.readLine());
    }

    public static Color getInputColor() {
        System.out.println(Arrays.toString(Color.values()));
        System.out.println("Enter the COLOR exactly as it is printed above: ");

        Color hairColor = null;
        while (hairColor == null) {
            hairColor = PersonConverter.convertToColor(UserInputManager.readLine());
        }
        return hairColor;
    }

    public static Country getInputCountry() {
        System.out.println(Arrays.toString(Country.values()));
        System.out.println("Enter NATIONALITY exactly as it is printed above or empty string:");
        return PersonConverter.convertToCountry(UserInputManager.readLine());
    }



    public static class PersonConverter {

        public static String convertToName(String input) {
            if (input.isEmpty()) {
                System.out.println("Cannot be an empty string. Please try again:");
                return null;
            }
            return input;
        }

        public static Float convertToHeightOrWeight(String input) {

            if (input.isEmpty()) {
                return 0f;
            }
            try {
                float height = Float.parseFloat(input);
                if (height <= 0) {
                    System.out.println("Please enter numerical value (more than 0) (can be null)");
                    return convertToHeightOrWeight(UserInputManager.readLine());
                }
                return height;
            } catch (NumberFormatException e) {
                System.out.println("Please enter numerical value (more than 0) (can be null)");
                return convertToHeightOrWeight(UserInputManager.readLine());
            }

        }

        public static Color convertToColor(String input) {

            Color hairColor = null;

            switch (input) {
                case "RED":
                    hairColor = Color.RED;
                    break;
                case "BLUE":
                    hairColor = Color.BLUE;
                    break;
                case "ORANGE":
                    hairColor = Color.ORANGE;
                    break;
                default:
                    System.out.println("Wrong input. Please try again:");
                    break;
            }
            return hairColor;
        }

        public static Country convertToCountry(String input) {

            Country nationality = null;

            if (!input.isEmpty()) {
                switch (input) {
                    case "USA":
                        nationality = Country.USA;
                        break;
                    case "CHINA":
                        nationality = Country.CHINA;
                        break;
                    case "VATICAN":
                        nationality = Country.VATICAN;
                        break;
                    case "NORTH_KOREA":
                        nationality = Country.NORTH_KOREA;
                        break;
                    default:
                        System.out.println("Wrong input. Please try again:");
                        convertToCountry(UserInputManager.readLine());
                        break;
                }
            }
            return nationality;
        }
    }

}
