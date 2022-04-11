package com.ivaaaak.client.util;

import com.ivaaaak.client.Data.Color;
import com.ivaaaak.client.Data.Country;
import com.ivaaaak.client.Data.Person;
import com.ivaaaak.client.UserInputManager;

import java.util.Arrays;

public final class PersonMaker {

    private PersonMaker() {

    }

    public static Person initializePerson(Integer id) {
        Person p = new Person();
        p.setId(id);

        initializeName(p);
        p.setCoordinates(CoordinatesMaker.initialize());
        initializeHeight(p);
        initializeWeight(p);
        initializeColor(p);
        initializeCountry(p);
        p.setLocation(LocationMaker.initialize());

        return p;
    }

    public static void initializeName(Person p) {
        System.out.println("Enter NAME: (cannot be an empty string)");
        String name;
        do {
            name = PersonConverter.convertName(UserInputManager.readLine());
        } while (name == null);
        p.setName(name);
    }


    public static void initializeHeight(Person p) {
        System.out.println("Enter HEIGHT (more than 0 or empty string):");
        Float height = PersonConverter.convertHeightOrWeight(UserInputManager.readLine());
        if (!(height == null)) {
            p.setHeight(height);
        }

    }

    public static void initializeWeight(Person p) {
        System.out.println("Enter WEIGHT (more than 0 or empty string):");
        Float weight = PersonConverter.convertHeightOrWeight(UserInputManager.readLine());
        if (!(weight == null)) {
            p.setWeight(weight);
        }
    }

    public static void initializeColor(Person p) {
        System.out.println(Arrays.toString(Color.values()));
        System.out.println("Enter the COLOR exactly as it is printed above: ");
        Color hairColor;
        do {
            hairColor = PersonConverter.convertColor(UserInputManager.readLine());
        } while (hairColor == null);
        p.setHairColor(hairColor);
    }

    public static void initializeCountry(Person p) {
        System.out.println(Arrays.toString(Country.values()));
        System.out.println("Enter NATIONALITY exactly as it is printed above or empty string:");

        Country nationality = PersonConverter.convertCountry(UserInputManager.readLine());
        if (!(nationality == null)) {
            p.setNationality(nationality);
        }

    }




}
