package com.ivaaaak.client.util;

import com.ivaaaak.client.Data.Color;
import com.ivaaaak.client.Data.Country;
import com.ivaaaak.client.UserInputManager;

public final class PersonConverter {

    /**
     * This class converts string input into possible value
     */

    private PersonConverter() {

    }

    public static String convertName(String input) {
        if (input.isEmpty()) {
            System.out.println("Cannot be an empty string. Please try again:");
            return null;
        } else {
            return input;
        }
    }

    public static Integer convertCoordinatesX(String input) {
        int x;
        final int max = 172;

        if (input.isEmpty()) {
            System.out.println("Cannot be null. Please try again:");
            return null;
        } else {
            try {
                x = Integer.parseInt(input);
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

    }

    public static Double convertCoordinatesY(String input) {
        double y;

        if (input.isEmpty()) {
            System.out.println("Cannot be null. Please try again:");
            return null;
        } else {
            try {
                y = Double.parseDouble(input);
                return y;
            } catch (NumberFormatException e) {
                System.out.println("Please enter numerical value:");
                return null;
            }
        }
    }

    public static Float convertHeightOrWeight(String input) {
        float height;

        if (input.isEmpty()) {
            return null;
        } else {
            try {
                height = Float.parseFloat(input);
                if (height <= 0) {
                    System.out.println("Enter value of height (more than 0)");
                    return convertHeightOrWeight(UserInputManager.readLine());
                }
                return height;
            } catch (NumberFormatException e) {
                System.out.println("Enter value of height (more than 0) (can be null)");
                return convertHeightOrWeight(UserInputManager.readLine());
            }
        }

    }

    public static Color convertColor(String input) {

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

    public static Country convertCountry(String input) {

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
                    System.out.println("Wrong input.Please try again:");
                    convertCountry(UserInputManager.readLine());
                    break;
            }
        }
        return nationality;
    }

    public static Long convertLocationX(String input) {
        long x;

        if (input.isEmpty()) {
            System.out.println("Cannot be null. Please try again:");
            return null;
        } else {
            try {
                x = Long.parseLong(input);
                return x;
            } catch (NumberFormatException e) {
                System.out.println("Please enter numerical value:");
                return null;
            }
        }

    }

    public static Integer convertLocationY(String input) {
        int y;

        if (input.isEmpty()) {
            System.out.println("Cannot be null. Please try again:");
            return null;
        } else {
            try {
                y = Integer.parseInt(input);
                return y;
            } catch (NumberFormatException e) {
                System.out.println("Please enter numerical value:");
                return null;
            }
        }
    }

    public static Integer convertLocationZ(String input) {
        int z;

        if (input.isEmpty()) {
            System.out.println("Please enter numerical value:");
            return null;
        } else {
            try {
                z = Integer.parseInt(input);
                return z;
            } catch (NumberFormatException e) {
                System.out.println("Please enter numerical value:");
                return null;
            }
        }
    }


}
