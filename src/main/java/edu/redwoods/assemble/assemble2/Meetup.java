package edu.redwoods.assemble.assemble2;

import javax.persistence.*;

@Entity
public class Meetup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String edition;
    private String description;
    private java.sql.Date date;
    private java.sql.Time time;
    private String locationId; // You may adjust this based on your actual table design

    @ManyToOne
    @JoinColumn(name = "location_locationId")
    private Location location;

    @ManyToOne
    @JoinColumn(name = "game_id")
    private Games game;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location){
        this.location = location;
    }
}
