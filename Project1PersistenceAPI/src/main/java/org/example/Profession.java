package org.example;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
class Profession {
    @Id
    String name;
    int baseArmor;
    @OneToMany(mappedBy = "profession", cascade = CascadeType.REMOVE)
    List<Character> characters;

    public Profession(String name, int baseArmor) {
        this.name = name;
        this.baseArmor = baseArmor;
        characters = new ArrayList<>();
    }

    public Profession() {}

    public String getName() {
        return name;
    }

    public String toString() {
        return "Name: " + name + " base armor: " + baseArmor + " characters: " + characters;
    }

    public void addCharacter(Character character) {
        characters.add(character);
    }

}
