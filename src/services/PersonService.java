// File: src/services/PersonService.java
package services;

import models.Person;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PersonService {
    private final Map<String, Person> people;

    public PersonService() {
        this.people = new HashMap<>();
    }

    public void addPerson(String name, String address, String phoneNumber, String cvFilePath, List<String> rolesAppliedTo, List<String> skills) {
        people.put(name, new Person(name, address, phoneNumber, cvFilePath, rolesAppliedTo, skills));
        System.out.println("Person added: " + name);
    }

    public void editPerson(String name, String address, String phoneNumber) {
        Person person = people.get(name);
        if (person != null) {
            person.setAddress(address);
            person.setPhoneNumber(phoneNumber);
            System.out.println("Person updated: " + name);
        } else {
            System.out.println("Person not found!");
        }
    }

    public void addRoleToPerson(String name, String role) {
        Person person = people.get(name);
        if (person != null) {
            person.addRole(role);
            System.out.println("Role added to " + name + ": " + role);
        } else {
            System.out.println("Person not found!");
        }
    }

    public void addSkillToPerson(String name, String skill) {
        Person person = people.get(name);
        if (person != null) {
            person.addSkill(skill);
            System.out.println("Skill added to " + name + ": " + skill);
        } else {
            System.out.println("Person not found!");
        }
    }

    public void viewPersonDataOnDate(String name, LocalDateTime dateTime) {
        Person person = people.get(name);
        if (person != null) {
            Person dataAtDate = person.viewDataAt(dateTime);
            System.out.println("Data for " + name + " on " + dateTime + ": " + dataAtDate);
        } else {
            System.out.println("Person not found!");
        }
    }

    public void viewCurrentPersonData(String name) {
        Person person = people.get(name);
        if (person != null) {
            System.out.println("Current data for " + name + ": " + person);
        } else {
            System.out.println("Person not found!");
        }
    }
}
