package edu.redwoods.assemble.assemble2;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Games {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    @OneToMany(mappedBy = "game")
    private Set<Meetup> meetups;

    // Getters and Setters
}
