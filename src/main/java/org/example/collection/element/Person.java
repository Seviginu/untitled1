package org.example.collection.element;

import org.example.collection.Printable;

import java.lang.reflect.Field;
import java.util.Objects;

public class Person extends Printable {
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Float height; //Поле может быть null, Значение поля должно быть больше 0
    private Color hairColor; //Поле не может быть null
    private Country nationality; //Поле не может быть null

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getHeight() {
        return height;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    public Color getHairColor() {
        return hairColor;
    }

    public void setHairColor(Color hairColor) {
        this.hairColor = hairColor;
    }

    public Country getNationality() {
        return nationality;
    }

    public void setNationality(Country nationality) {
        this.nationality = nationality;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    private Location location; //Поле не может быть null

    @Override
    public int hashCode(){
        return Objects.hash(name, height, hairColor, nationality, location);
    }
}