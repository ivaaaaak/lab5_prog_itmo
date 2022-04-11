package com.ivaaaak.client.Data;


import com.ivaaaak.client.CollectionStorage;

import java.util.Objects;

public class Person implements Comparable<Person> {

    private final Integer id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private final java.time.LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private float height; //Значение поля должно быть больше 0
    private float weight; //Значение поля должно быть больше 0
    private Color hairColor; //Поле не может быть null
    private Country nationality; //Поле может быть null
    private Location location; //Поле не может быть null



    public Person(CollectionStorage collectionStorage) {
        this.creationDate = java.time.LocalDateTime.now();
        this.id = collectionStorage.getMaxId() + 1;
    }
    public Person(Integer id) {
        this.creationDate = java.time.LocalDateTime.now();
        this.id = id;
    }

    @Override
    public String toString() {
        return "Person{"
                + "id=" + id
                + ", name='" + name + '\''
                + ", coordinates=" + coordinates
                + ", creationDate=" + creationDate
                + ", height=" + height
                + ", weight=" + weight
                + ", hairColor=" + hairColor
                + ", nationality=" + nationality
                + ", location=" + location
                + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Person person = (Person) o;
        return Float.compare(person.height, height) == 0 && Float.compare(person.weight, weight) == 0 && Objects.equals(id, person.id) && Objects.equals(name, person.name) && Objects.equals(coordinates, person.coordinates) && Objects.equals(creationDate, person.creationDate) && hairColor == person.hairColor && nationality == person.nationality && Objects.equals(location, person.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, coordinates, creationDate, height, weight, hairColor, nationality, location);
    }


    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Location getLocation() {
        return location;
    }

    public float getHeight() {
        return height;
    }

    public Color getHairColor() {
        return hairColor;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setHairColor(Color hairColor) {
        this.hairColor = hairColor;
    }

    public void setNationality(Country nationality) {
        this.nationality = nationality;
    }

    @Override
    public int compareTo(Person o) {
        return (int) (this.height - o.getHeight());
    }
}
