package repository.location;

import domain.location.Location;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "locations")
@NoArgsConstructor
public class LocationJPAEntity {

    @Id
    @Column(name = "id")
    @EqualsAndHashCode.Include
    private String id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "owner")
    private String owner;

    @Column(name = "funfact")
    private String funFact;

    @Column(name = "imageurl")
    private String imageUrl;

    @Column(name = "address")
    private String address;


    public void LocationEntity(Location location) {
        this.id = UUID.randomUUID().toString();
        this.name = location.getName();
        this.description = location.getDescription();
        this.owner = location.getOwner();
        this.funFact = location.getFunFact();
        this.imageUrl = location.getImageUrl();
        this.address = location.getAdress();
    }
}

