package domain.character;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class Character {
    private String firstName;
    private String lastName;
    private String occupation;
    private String motto;
    private String imageUrl;

    public Character(String firstName, String lastName, String occupation, String motto, String imageUrl) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.occupation = occupation;
        this.motto = motto;
        this.imageUrl = imageUrl;
    }
}
