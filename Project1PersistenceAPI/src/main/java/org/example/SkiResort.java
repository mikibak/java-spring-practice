package org.example;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@Data
public class SkiResort implements Comparable<SkiResort>, Serializable {
    @Id
    String name;

    int visitors;
    @OneToMany(mappedBy = "skiResort", cascade = CascadeType.REMOVE)
    List<Slope> slopes;

    public SkiResort() {
        name = "";
        visitors = 0;
        slopes = new ArrayList<>();
    }
    public SkiResort(String name, int visitors, List<Slope> slopes) {
        this.name = name;
        this.visitors = visitors;
        this.slopes = slopes;
    }

    public String toString() {
        return "SkiResort name: " + name + " visitors: " + visitors + " slopes: " + slopes;
    }

    public void addCharacter(Slope slope) {
        slopes.add(slope);
    }

    @Override public int compareTo(SkiResort o)
    {
        if (this.visitors > o.visitors) {
            return 1;
        }
        else if (this.visitors < o.visitors) {
            return -1;
        }
        else {
            return this.name.compareTo(o.name);
        }
    }

}
