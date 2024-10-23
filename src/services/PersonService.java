package services;

import models.Person;
import models.PersonSnapshot;
import repositories.PersonRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class PersonService implements PersonServiceInterface {
    private static PersonService instance; // Singleton instance
    private final PersonRepository repository;

    // Private constructor to prevent instantiation
    private PersonService(PersonRepository repository) {
        this.repository = repository;
    }

    // Public method to get the singleton instance
    public static PersonService getInstance(PersonRepository repository) {
        if (instance == null) {
            instance = new PersonService(repository); // Create a single instance
        }
        return instance;
    }

    @Override
    public void addPerson(String name, String address, String phoneNumber) {
        // Create empty ArrayLists for roles and skills to ensure compatibility with Java 8
        Person person = new Person(name, address, phoneNumber, new ArrayList<>(), new ArrayList<>());
        repository.addPerson(person);
        System.out.println("Person added: " + name);
    }

    @Override
    public void editPerson(String name, String address, String phoneNumber) {
        repository.updatePerson(name, address, phoneNumber);
        System.out.println("Person updated: " + name);
    }

    @Override
    public void addRoleToPerson(String name, String role) {
        Person person = repository.findPersonByName(name);
        if (person != null) {
            person.addRole(role);
            System.out.println("Role added: " + role + " for " + name);
        } else {
            System.out.println("Person not found.");
        }
    }

    @Override
    public void addSkillToPerson(String name, String skill) {
        Person person = repository.findPersonByName(name);
        if (person != null) {
            person.addSkill(skill);
            System.out.println("Skill added: " + skill + " for " + name);
        } else {
            System.out.println("Person not found.");
        }
    }

    @Override
    public void viewCurrentPersonData(String name) {
        Person person = repository.findPersonByName(name);
        if (person != null) {
            System.out.println("Current data for " + name + ": " + person);
        } else {
            System.out.println("Person not found.");
        }
    }

    @Override
    public void viewPersonDataOnDate(String name, LocalDateTime dateTime) {
        PersonSnapshot snapshot = repository.getPersonAtDate(name, dateTime);
        if (snapshot != null) {
            System.out.println("Data for " + name + " on " + dateTime + ": " + snapshot);
        } else {
            System.out.println("No data found for " + name + " on the specified date.");
        }
    }
}
