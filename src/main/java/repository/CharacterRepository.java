package repository;

import com.speedment.jpastreamer.application.JPAStreamer;
import domain.Character;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

import java.util.List;

@ApplicationScoped
public class CharacterRepository {

    @Inject
    JPAStreamer jpaStreamer;
    @Inject
    EntityManager entityManager;

    public CharacterJPAEntity getCharacterById(String id) {
        return jpaStreamer.stream(CharacterJPAEntity.class)
                .filter(characterJPAEntity -> characterJPAEntity.getId().equals(id))
                .findFirst()
                .orElse(null); // TODO: Change this handeling
    }

    public CharacterJPAEntity getCharacterByName(String firstName, String lastName) {
        return jpaStreamer.stream(CharacterJPAEntity.class)
                .filter(characterJPAEntity ->
                        characterJPAEntity.getFirstname().equals(firstName) &&
                                characterJPAEntity.getLastname().equals(lastName))
                .findFirst()
                .orElse(null); // TODO: Change this handling
    }

    public List<CharacterJPAEntity> getCharacters() {
        return jpaStreamer.stream(CharacterJPAEntity.class)
                .toList();
    }

    public void createCharacter(Character character) {
        CharacterJPAEntity characterJPAEntity = new CharacterJPAEntity(character);
        entityManager.persist(characterJPAEntity);
    }

    public void updateCharacter(CharacterJPAEntity characterEntity) {
        entityManager.merge(characterEntity);
    }

    public void deleteCharacter(String id) {
        CharacterJPAEntity character = entityManager.find(CharacterJPAEntity.class, id);
        if (character != null) {
            entityManager.remove(character);
        }
    }
}
