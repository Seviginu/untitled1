package org.example.collection;

import java.lang.reflect.Field;

abstract public class Printable {
    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        for(Field field : this.getClass().getDeclaredFields()){
            try {
                stringBuilder.append(field.getName()).append(": ").append(field.get(this)).append("\n");
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }

        return stringBuilder.toString();
    }
}
