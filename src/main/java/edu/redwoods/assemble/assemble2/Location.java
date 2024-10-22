package edu.redwoods.assemble.assemble2;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "business_businessId")
    private BusinessEntity business;

    private String lon_lat; // Adjust as needed
    private String address;
    private String state;
    private String zip;

    @OneToMany(mappedBy = "location")
    private Set<Meetup> meetups;

    // Getters and Setters
}
