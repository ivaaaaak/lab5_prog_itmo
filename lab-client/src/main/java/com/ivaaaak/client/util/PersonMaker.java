package com.ivaaaak.client.util;

import com.ivaaaak.client.Data.Color;
import com.ivaaaak.client.Data.Country;
import com.ivaaaak.client.Data.Person;
import com.ivaaaak.client.UserInputManager;

import java.util.Arrays;

public final class PersonMaker {

    private PersonMaker() {

    }

    public static void initializePerson(Person p) {

        p.setName(initializeName());
        p.setCoordinates(CoordinatesMaker.initialize());
        p.setHeight(initializeHeight());
        p.setWeight(initializeWeight());
        p.setHairColor(initializeColor());
        p.setNationality(initializeCountry());
        p.setLocation(LocationMaker.initialize());

    }


    public static String initializeName() {
        System.out.println("Enter NAME: (cannot be an empty string)");
        String name;
        do {
            name = PersonConverter.convertName(UserInputManager.readLine());
        } while (name == null);
        return name;
    }


    public static Float initializeHeight() {
        System.out.println("Enter HEIGHT (more than 0 or empty string):");
        Float height = PersonConverter.convertHeightOrWeight(UserInputManager.readLine());
        if (!(height == null)) {
            return height;
        }
        return 0f;
    }

    public static Float initializeWeight() {
        System.out.println("Enter WEIGHT (more than 0 or empty string):");
        Float weight = PersonConverter.convertHeightOrWeight(UserInputManager.readLine());
        if (!(weight == null)) {
            return weight;
        }
        return 0f;
    }

    public static Color initializeColor() {
        System.out.println(Arrays.toString(Color.values()));
        System.out.println("Enter the COLOR exactly as it is printed above: ");
        Color hairColor;
        do {
            hairColor = PersonConverter.convertColor(UserInputManager.readLine());
        } while (hairColor == null);
        return hairColor;
    }

    public static Country initializeCountry() {
        System.out.println(Arrays.toString(Country.values()));
        System.out.println("Enter NATIONALITY exactly as it is printed above or empty string:");

        Country nationality = PersonConverter.convertCountry(UserInputManager.readLine());
        if (!(nationality == null)) {
            return nationality;
        }
        return null;
    }

}
