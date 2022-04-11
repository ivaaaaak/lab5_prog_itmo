package com.ivaaaak.client.util;

import com.ivaaaak.client.Data.Coordinates;
import com.ivaaaak.client.UserInputManager;

public final class CoordinatesMaker {

    private CoordinatesMaker() {

    }

    public static Coordinates initialize() {
        Coordinates c = new Coordinates();

        System.out.println("Enter an integer value of X coordinate (no more than 172):");
        Integer x;
        do {
            x = PersonConverter.convertCoordinatesX(UserInputManager.readLine());
        } while (x == null);
        c.setX(x);

        System.out.println("Enter a value of Y coordinate:");
        Double y;
        do {
            y = PersonConverter.convertCoordinatesY(UserInputManager.readLine());
        } while (y == null);
        c.setY(y);

        return c;
    }


}
