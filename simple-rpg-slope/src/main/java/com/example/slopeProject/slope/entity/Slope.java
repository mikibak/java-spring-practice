package com.example.slopeProject.slope.entity;
import com.example.slopeProject.skiResort.entity.SkiResort;
import lombok.*;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode
public class Slope implements Comparable<Slope>, Serializable {
    @Id
    @Column
    private UUID id;

    @Column
    @Setter
    private String name;

    @Setter
    @Column
    private int steepness;

    @JoinColumn(name = "ski_resort")
    @ManyToOne
    @Setter
    private SkiResort skiResort;

    @Override
    public String toString() {
        return "Slope ID: " + id + " Slope name: " + name + " steepness: " + steepness + " skiResort: " + skiResort.getName();
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
