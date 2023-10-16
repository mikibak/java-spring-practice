package org.example;
import java.io.Serializable;

class SlopeDto implements Serializable{
    String name;
    int steepness;
    String skiResort;

    public SlopeDto(String name, int steepness, String skiResort) {
        this.name = name;
        this.steepness = steepness;
        this.skiResort = skiResort;
    }

    public String toString() {
        return "Slope name: " + name + " steepness: " + steepness + " skiResort: " + skiResort;
    }
}