package com.ivaaaak.client.util;

import com.ivaaaak.client.Data.Location;
import com.ivaaaak.client.UserInputManager;

public final class LocationMaker {

    private LocationMaker() {

    }

    public static Location initialize() {
        Location l = new Location();

        System.out.println("Enter location X:");
        Long x;
        do {
            x = PersonConverter.convertLocationX(UserInputManager.readLine());
        } while (x == null);
        l.setX(x);

        System.out.println("Enter integer location Y:");
        Integer y;
        do {
            y = PersonConverter.convertLocationY(UserInputManager.readLine());
        } while (y == null);
        l.setY(y);

        System.out.println("Enter integer location Z:");
        Integer z;
        do {
            z = PersonConverter.convertLocationZ(UserInputManager.readLine());
        } while (z == null);
        l.setZ(z);

        return l;
    }

}
