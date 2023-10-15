package org.example;
import java.io.Serializable;

class CharacterDto implements Serializable{
    String name;
    int level;
    String profession;

    public CharacterDto(String name, int level, String profession) {
        this.name = name;
        this.level = level;
        this.profession = profession;
    }

    public String toString() {
        return "Character name: " + name + " level: " + level + " profession: " + profession;
    }
}