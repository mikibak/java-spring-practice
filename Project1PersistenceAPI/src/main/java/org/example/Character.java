package org.example;
import javax.persistence.*;

@Entity
public class Character implements Comparable<Character> {
    @Id
    String name;
    int level;
    @ManyToOne
    Profession profession;

    public Character(String name, int level, Profession profession) {
        this.name = name;
        this.level = level;
        this.profession = profession;
    }

    @Override
    public String toString() {
        return "Name: " + name + " level: " + level + " profession: " + profession.getName();
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
