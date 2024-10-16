package repository.character;

import com.speedment.jpastreamer.application.JPAStreamer;
import domain.character.Character;
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

    public CharacterJPAEntity findByName(String firstName, String lastName) {
        return entityManager.createQuery(
                        "SELECT c FROM CharacterJPAEntity c WHERE c.firstname = :firstName AND c.lastname = :lastName", CharacterJPAEntity.class)
                .setParameter("firstName", firstName)
                .setParameter("lastName", lastName)
                .getSingleResult();
    }


    public List<CharacterJPAEntity> getCharacters() {
        return jpaStreamer.stream(CharacterJPAEntity.class)
                .toList();
    }

    public void createCharacter(Character character) {
        var characterJPAEntity = new CharacterJPAEntity(character);
        entityManager.persist(characterJPAEntity);
    }

    public void updateCharacter(CharacterJPAEntity characterEntity) {
        entityManager.merge(characterEntity);
    }

    public void deleteCharacter(String id) {
        var character = entityManager.find(CharacterJPAEntity.class, id);
        if (character != null) {
            entityManager.remove(character);
        }
    }

    public void deleteByFirstNameAndLastName(String firstName, String lastName) {
        var character = findByName(firstName, lastName);
        if (character != null) {
            entityManager.remove(character);
        }
    }
}
