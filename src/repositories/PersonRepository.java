package repositories;

import models.Person;
import models.PersonSnapshot;

import java.time.LocalDateTime;

public interface PersonRepository {
    void addPerson(Person person);
    void updatePerson(String name, String address, String phoneNumber);
    Person findPersonByName(String name);
    PersonSnapshot getPersonAtDate(String name, LocalDateTime dateTime);
}
