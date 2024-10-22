package edu.redwoods.assemble.assemble2;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String googleAccountId;
    private Boolean notificationsEnabled;

    @ManyToMany
    @JoinTable(
            name = "User_Favorite_Games",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "game_id"))
    private Set<Games> favoriteGames;

    @ManyToMany
    @JoinTable(
            name = "User_Favorite_Locations",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "location_id"))
    private Set<Location> favoriteLocations;

    // Getters and Setters
}
