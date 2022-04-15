package com.ivaaaak.client.util;

import com.ivaaaak.client.CollectionStorage;
import com.ivaaaak.client.Data.Person;
import com.ivaaaak.client.Data.Color;
import com.ivaaaak.client.Data.Country;
import com.ivaaaak.client.UserInputManager;

import java.util.Arrays;

public class PersonMaker {
    private final UserInputManager userInputManager;
    private final LocationMaker locationMaker;
    private final CoordinatesMaker coordinatesMaker;

    public PersonMaker(UserInputManager userInputManager) {
        this.userInputManager = userInputManager;
        this.coordinatesMaker = new CoordinatesMaker(userInputManager);
        this.locationMaker = new LocationMaker(userInputManager);
    }

    public Person makePerson(CollectionStorage collectionStorage) {
        return new Person(collectionStorage,
                getInputName(),
                coordinatesMaker.makeCoordinates(),
                getInputHeight(),
                getInputWeight(),
                getInputColor(),
                getInputCountry(),
                locationMaker.makeLocation());
    }
    public Person makePerson(Integer id) {
        return new Person(id,
                getInputName(),
                coordinatesMaker.makeCoordinates(),
                getInputHeight(),
                getInputWeight(),
                getInputColor(),
                getInputCountry(),
                locationMaker.makeLocation());
    }


    public String getInputName() {
        System.out.println("Enter NAME: (cannot be an empty string)");

        String name = null;
        while (name == null) {
            name = PersonConverter.convertToName(userInputManager.readLine());
        }
        return name;
    }

    public Float getInputHeight() {
        System.out.println("Enter HEIGHT (more than 0 or null):");
        Float height = null;
        while (height == null) {
            height = PersonConverter.convertToHeightOrWeight(userInputManager.readLine());
        }
        return height;
    }

    public Float getInputWeight() {
        System.out.println("Enter WEIGHT (more than 0 or null):");
        Float weight = null;
        while (weight == null) {
            weight = PersonConverter.convertToHeightOrWeight(userInputManager.readLine());
        }
        return weight;
    }

    public Color getInputColor() {
        System.out.println(Arrays.toString(Color.values()));
        System.out.println("Enter the COLOR exactly as it is printed above: ");

        Color hairColor = null;
        while (hairColor == null) {
            hairColor = PersonConverter.convertToColor(userInputManager.readLine());
        }
        return hairColor;
    }

    public Country getInputCountry() {
        System.out.println(Arrays.toString(Country.values()));
        System.out.println("Enter NATIONALITY exactly as it is printed above or empty string:");
        Country nationality = Country.NULL;
        while (nationality == Country.NULL) {
            nationality = PersonConverter.convertToCountry(userInputManager.readLine());
        }
        return nationality;
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
                    return null;
                }
                return height;
            } catch (NumberFormatException e) {
                System.out.println("Please enter numerical value (more than 0) (can be null)");
                return null;
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
                        nationality = Country.NULL;
                        break;
                }
            }
            return nationality;
        }
    }

}
