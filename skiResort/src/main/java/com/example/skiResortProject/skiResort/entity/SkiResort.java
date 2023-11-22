package com.example.skiResortProject.skiResort.entity;
import lombok.*;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "ski_resorts")

public class SkiResort implements Comparable<SkiResort>, Serializable {
    @Id
    @Column
    private UUID id;

    @Column
    private String name;

    @Column
    int visitors;
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
