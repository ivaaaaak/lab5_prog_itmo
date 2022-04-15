package com.ivaaaak.client.util;

import com.ivaaaak.client.Data.Location;
import com.ivaaaak.client.UserInputManager;

public class LocationMaker {
    private final UserInputManager userInputManager;

    public LocationMaker(UserInputManager userInputManager) {
        this.userInputManager = userInputManager;
    }

    public Location makeLocation() {
        return new Location(getInputX(),
                getInputY(),
                getInputZ());
    }

    public Long getInputX() {
        System.out.println("Enter location X:");
        Long x = null;
        while (x == null) {
            x = LocationConverter.convertX(userInputManager.readLine());
        }
        return x;
    }

    public Integer getInputY() {
        System.out.println("Enter integer location Y:");
        Integer y = null;
        while (y == null) {
            y = LocationConverter.convertY(userInputManager.readLine());
        }
        return y;
    }

    public Integer getInputZ() {
        System.out.println("Enter integer location Z:");
        Integer z = null;
        while (z == null) {
            z = LocationConverter.convertZ(userInputManager.readLine());
        }
        return z;
    }

    public static class LocationConverter {

        public static Long convertX(String input) {

            if (input.isEmpty()) {
                System.out.println("Cannot be null. Please try again:");
                return null;
            }
            try {
                return Long.parseLong(input);
            } catch (NumberFormatException e) {
                System.out.println("Please enter numerical value:");
                return null;
            }
        }

        public static Integer convertY(String input) {

            if (input.isEmpty()) {
                System.out.println("Cannot be null. Please try again:");
                return null;
            }
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Please enter numerical value:");
                return null;
            }
        }

        public static Integer convertZ(String input) {

            if (input.isEmpty()) {
                System.out.println("Please enter numerical value:");
                return null;
            }
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Please enter numerical value:");
                return null;
            }
        }

    }

}
