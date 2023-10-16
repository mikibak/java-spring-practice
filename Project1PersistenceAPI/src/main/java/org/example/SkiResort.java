package org.example;
import lombok.Builder;
import lombok.Getter;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
public class SkiResort implements Comparable<SkiResort>, Serializable {
    @Getter
    @Id
    String name;

    int baseArmor;
    @Getter
    @OneToMany(mappedBy = "skiResort", cascade = CascadeType.REMOVE)
    List<Slope> slopes;

    public SkiResort() {
        name = "";
        baseArmor = 0;
        slopes = new ArrayList<>();
    }
    public SkiResort(String name, int baseArmor, List<Slope> slopes) {
        this.name = name;
        this.baseArmor = baseArmor;
        this.slopes = slopes;
    }

    public String toString() {
        return "SkiResort name: " + name + " base armor: " + baseArmor + " slopes: " + slopes;
    }

    public void addCharacter(Slope slope) {
        slopes.add(slope);
    }

    @Override public int compareTo(SkiResort o)
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
