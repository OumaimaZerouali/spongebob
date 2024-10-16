package domain.location;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class Location {
    private String name;
    private String description;
    private String owner;
    private String funFact;
    private String adress;

    private String imageUrl;

    public Location( String name, String description, String owner, String funFact, String adress, String imageUrl) {
        this.name = name;
        this.description = description;
        this.owner = owner;
        this.funFact = funFact;
        this.imageUrl = imageUrl;
        this.adress = adress;
    }
}
