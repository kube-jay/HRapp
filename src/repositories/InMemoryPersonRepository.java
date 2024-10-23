package repositories;

import models.Person;
import models.PersonSnapshot;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class InMemoryPersonRepository implements PersonRepository {
    private final Map<String, Person> people = new HashMap<>();

    @Override
    public void addPerson(Person person) {
        people.put(person.getName(), person);
    }

    @Override
    public void updatePerson(String name, String address, String phoneNumber) {
        Person person = people.get(name);
        if (person != null) {
            person.setAddress(address);
            person.setPhoneNumber(phoneNumber);
        }
    }

    @Override
    public Person findPersonByName(String name) {
        return people.get(name);
    }

    // Modify this method to return PersonSnapshot instead of Person
    @Override
    public PersonSnapshot getPersonAtDate(String name, LocalDateTime dateTime) {
        Person person = people.get(name);
        if (person != null) {
            // Call viewDataAt() which now returns a PersonSnapshot
            return person.viewDataAt(dateTime);
        }
        return null;  // Return null if person is not found
    }
}
