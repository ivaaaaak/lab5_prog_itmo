package com.ivaaaak.client.util;

import com.ivaaaak.client.Data.Coordinates;
import com.ivaaaak.client.UserInputManager;

public class CoordinatesMaker {
    private final UserInputManager userInputManager;

    public CoordinatesMaker(UserInputManager userInputManager) {
        this.userInputManager = userInputManager;
    }

    public Coordinates makeCoordinates() {
        return new Coordinates(getInputX(),
                getInputY());
    }

    public Integer getInputX() {
        System.out.println("Enter an integer value of X coordinate (no more than 172):");
        Integer x = null;
        while (x == null) {
            x = CoordinatesConverter.convertX(userInputManager.readLine());
        }
        return x;
    }

    public Double getInputY() {
        System.out.println("Enter a value of Y coordinate:");
        Double y = null;
        while (y == null) {
            y = CoordinatesConverter.convertY(userInputManager.readLine());
        }
        return y;
    }


    public static class CoordinatesConverter {

        public static Integer convertX(String input) {

            if (input.isEmpty()) {
                System.out.println("Cannot be null. Please try again:");
                return null;
            }
            try {
                int x = Integer.parseInt(input);
                final int max = 172;
                if (x > max) {
                    System.out.println("Please enter numerical value (no more than 172):");
                    return null;
                }
                return x;
            } catch (NumberFormatException e) {
                System.out.println("Please enter numerical value (no more than 172):");
                return null;
            }
        }

        public static Double convertY(String input) {

            if (input.isEmpty()) {
                System.out.println("Cannot be null. Please try again:");
                return null;
            }
            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Please enter numerical value:");
                return null;
            }
        }
    }

}
