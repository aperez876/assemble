package edu.redwoods.assemble.assemble2;

import javax.persistence.*;
import java.util.Set;
import java.util.List;

@Entity
@Table(name = "Business")
public class BusinessEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long businessId;

    private String name;
    private String description;
    private String openingTimes;

    @OneToMany(mappedBy = "business", cascade = CascadeType.ALL)
    private Set<Location> locations;

    /*@Embedded
    private BusinessProfile profile;  // Embed BusinessProfile*/

    @ElementCollection
    @CollectionTable(name = "BusinessGames", joinColumns = @JoinColumn(name = "business_id"))
    @Column(name = "game")
    private List<String> gamesAvailable; // Using List<String> properly

    // Getters and Setters
    public long getBusinessId() {
        return businessId;
    }

    public void setBusinessId(long businessId) {
        this.businessId = businessId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOpeningTimes() {
        return openingTimes;
    }

    public void setOpeningTimes(String openingTimes) {
        this.openingTimes = openingTimes;
    }

    public Set<Location> getLocations() {
        return locations;
    }

    public void setLocations(Set<Location> locations) {
        this.locations = locations;
    }

/*    public BusinessProfile getProfile() {
        return profile;
    }

    public void setProfile(BusinessProfile profile) {
        this.profile = profile;
    }*/

    public List<String> getGamesAvailable() {
        return gamesAvailable;
    }

    public void setGamesAvailable(List<String> gamesAvailable) {
        this.gamesAvailable = gamesAvailable;
    }
}
