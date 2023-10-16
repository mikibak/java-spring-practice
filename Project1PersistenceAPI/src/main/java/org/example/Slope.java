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
    private final int level;
    @ManyToOne
    private final SkiResort skiResort;

    public Slope() {
        name = "";
        level = 0;
        skiResort = new SkiResort();
    }

    public Slope(String name, int level, SkiResort skiResort) {
        this.name = name;
        this.level = level;
        this.skiResort = skiResort;
    }

    @Override
    public String toString() {
        return "Slope name: " + name + " level: " + level + " skiResort: " + skiResort.getName();
    }

    @Override public int compareTo(Slope o)
    {
        if (this.level > o.level) {
            return 1;
        }
        else if (this.level < o.level) {
            return -1;
        }
        else {
            return this.name.compareTo(o.name);
        }
    }
}
