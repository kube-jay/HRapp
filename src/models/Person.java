// File: src/models/Person.java
package models;

import java.time.LocalDateTime;
import java.util.*;

public class Person {
    private String name;
    private String address;
    private String phoneNumber;
    private String cvFilePath;
    private List<String> rolesAppliedTo;
    private List<String> skills;

    private final Map<LocalDateTime, Person> history;

    public Person(String name, String address, String phoneNumber, String cvFilePath, List<String> rolesAppliedTo, List<String> skills) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.cvFilePath = cvFilePath;
        this.rolesAppliedTo = new ArrayList<>(rolesAppliedTo);
        this.skills = new ArrayList<>(skills);
        this.history = new HashMap<>();
        saveHistory();
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; saveHistory(); }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; saveHistory(); }
    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; saveHistory(); }
    public String getCvFilePath() { return cvFilePath; }
    public void setCvFilePath(String cvFilePath) { this.cvFilePath = cvFilePath; saveHistory(); }
    public List<String> getRolesAppliedTo() { return rolesAppliedTo; }
    public void addRole(String role) { this.rolesAppliedTo.add(role); saveHistory(); }
    public List<String> getSkills() { return skills; }
    public void addSkill(String skill) { this.skills.add(skill); saveHistory(); }

    private void saveHistory() {
        history.put(LocalDateTime.now(), new Person(this.name, this.address, this.phoneNumber, this.cvFilePath, this.rolesAppliedTo, this.skills));
    }

    public Person viewDataAt(LocalDateTime dateTime) {
        return history.getOrDefault(dateTime, this);
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Address: " + address + ", Phone: " + phoneNumber + ", CV: " + cvFilePath +
                ", Roles: " + rolesAppliedTo + ", Skills: " + skills;
    }
}
