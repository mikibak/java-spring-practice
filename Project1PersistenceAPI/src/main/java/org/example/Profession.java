package org.example;
import lombok.Builder;
import lombok.Getter;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
public class Profession implements Comparable<Profession>, Serializable {
    @Getter
    @Id
    String name;

    int baseArmor;
    @Getter
    @OneToMany(mappedBy = "profession", cascade = CascadeType.REMOVE)
    List<Character> characters;

    public Profession() {
        name = "";
        baseArmor = 0;
        characters = new ArrayList<>();
    }
    public Profession(String name, int baseArmor, List<Character> characters) {
        this.name = name;
        this.baseArmor = baseArmor;
        this.characters = characters;
    }

    public String toString() {
        return "Profession name: " + name + " base armor: " + baseArmor + " characters: " + characters;
    }

    public void addCharacter(Character character) {
        characters.add(character);
    }

    @Override public int compareTo(Profession o)
    {
        if (this.baseArmor > o.baseArmor) {
            return 1;
        }
        else if (this.baseArmor < o.baseArmor) {
            return -1;
        }
        else {
            return this.name.compareTo(o.name);
        }
    }

}
