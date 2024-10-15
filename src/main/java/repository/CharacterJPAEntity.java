package repository;

import domain.Character;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "characters")
@NoArgsConstructor
public class CharacterJPAEntity {
    @Id
    @Column(name = "id")
    @EqualsAndHashCode.Include
    private String id;

    @NotNull
    @Column(name = "firstname", nullable = false, length = 100)
    private String firstname;

    @NotNull
    @Column(name = "lastname", nullable = false, length = 100)
    private String lastname;

    @Column(name = "occupation")
    private String occupation;

    @Column(name = "motto")
    private String motto;

    @Column(name = "imageurl")
    private String imageurl;

    protected CharacterJPAEntity(Character character) {
        this.id = UUID.randomUUID().toString();
        this.firstname = character.getFirstName();
        this.lastname = character.getLastName();
        this.occupation = character.getOccupation();
        this.motto = character.getMotto();
        this.imageurl = character.getImageUrl();
    }
}