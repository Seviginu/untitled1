package org.example.collection.element;

import org.example.collection.Printable;

import java.util.Objects;

public class Location extends Printable {
    private long x;
    private float y;
    private Long z; //Поле не может быть null

    public long getX() {
        return x;
    }

    public void setX(long x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public Long getZ() {
        return z;
    }

    public void setZ(Long z) {
        this.z = z;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name; //Поле не может быть null


    @Override
    public int hashCode(){
        return Objects.hash(x, y, z, name);
    }
}