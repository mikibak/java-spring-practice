package org.example;
import lombok.Builder;

import jakarta.persistence.*;
import lombok.Getter;

import java.io.Serializable;

@Entity
@Builder
@Getter
public class Slope implements Comparable<Slope>, Serializable {
    @Id
    private final String name;
    private final int steepness;
    @ManyToOne
    private final SkiResort skiResort;

    public Slope() {
        name = "";
        steepness = 0;
        skiResort = new SkiResort();
    }

    public Slope(String name, int steepness, SkiResort skiResort) {
        this.name = name;
        this.steepness = steepness;
        this.skiResort = skiResort;
    }

    @Override
    public String toString() {
        return "Slope name: " + name + " steepness: " + steepness + " skiResort: " + skiResort.getName();
    }

    @Override public int compareTo(Slope o)
    {
        if (this.steepness > o.steepness) {
            return 1;
        }
        else if (this.steepness < o.steepness) {
            return -1;
        }
        else {
            return this.name.compareTo(o.name);
        }
    }
}
