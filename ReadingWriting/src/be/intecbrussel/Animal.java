package be.intecbrussel;

import java.io.Serializable;

public class Animal implements Serializable {

    private String name;
    private boolean edible;

    public Animal(String name, boolean edible) {
        this.name = name;
        this.edible = edible;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isEdible() {
        return edible;
    }

    public void setEdible(boolean edible) {
        this.edible = edible;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", edible=" + edible +
                '}';
    }
}
