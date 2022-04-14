package com.ivaaaak.client.util;

import com.ivaaaak.client.Data.Location;

public final class LocationMaker {

    private LocationMaker() {

    }

    public static Location makeLocation() {
        return new Location(getInputX(), getInputY(), getInputZ());
    }

    public static Long getInputX() {
        System.out.println("Enter location X:");
        Long x = null;
        while (x == null) {
            x = LocationConverter.convertX(UserInputManager.readLine());
        }
        return x;
    }

    public static Integer getInputY() {
        System.out.println("Enter integer location Y:");
        Integer y = null;
        while (y == null) {
            y = LocationConverter.convertY(UserInputManager.readLine());
        }
        return y;
    }

    public static Integer getInputZ() {
        System.out.println("Enter integer location Z:");
        Integer z = null;
        while (z == null) {
            z = LocationConverter.convertZ(UserInputManager.readLine());
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
