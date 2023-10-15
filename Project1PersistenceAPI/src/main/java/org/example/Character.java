package org.example;
import lombok.Builder;

import jakarta.persistence.*;
import lombok.Getter;

import java.io.Serializable;

@Entity
@Builder
@Getter
public class Character implements Comparable<Character>, Serializable {
    @Id
    private final String name;
    private final int level;
    @ManyToOne
    private final Profession profession;

    public Character() {
        name = "";
        level = 0;
        profession = new Profession();
    }

    public Character(String name, int level, Profession profession) {
        this.name = name;
        this.level = level;
        this.profession = profession;
    }

    @Override
    public String toString() {
        return "Character name: " + name + " level: " + level + " profession: " + profession.getName();
    }

    @Override public int compareTo(Character o)
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
