package models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class Person {
    private String name;
    private String address;
    private String phoneNumber;
    private List<String> rolesAppliedTo;
    private List<String> skills;

    // A map to store history snapshots keyed by time
    private final Map<LocalDateTime, PersonSnapshot> history;

    public Person(String name, String address, String phoneNumber, List<String> rolesAppliedTo, List<String> skills) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.rolesAppliedTo = new ArrayList<>(rolesAppliedTo);  // Shallow copy of roles
        this.skills = new ArrayList<>(skills);  // Shallow copy of skills
        this.history = new HashMap<>();
        saveHistory();  // Save the initial state
    }

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; saveHistory(); }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; saveHistory(); }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; saveHistory(); }

    public List<String> getRolesAppliedTo() { return rolesAppliedTo; }
    public void addRole(String role) { this.rolesAppliedTo.add(role); saveHistory(); }

    public List<String> getSkills() { return skills; }
    public void addSkill(String skill) { this.skills.add(skill); saveHistory(); }

    // Save a snapshot of the current state to history
    private void saveHistory() {
        PersonSnapshot snapshot = new PersonSnapshot(this.name, this.address, this.phoneNumber,
                new ArrayList<>(this.rolesAppliedTo), new ArrayList<>(this.skills));  // Create a copy for history
        history.put(LocalDateTime.now(), snapshot);  // Save snapshot with current timestamp
    }

    // View data at a specific date
    public PersonSnapshot viewDataAt(LocalDateTime dateTime) {
        return history.getOrDefault(dateTime, new PersonSnapshot(this.name, this.address, this.phoneNumber,
                this.rolesAppliedTo, this.skills));  // Return a snapshot or latest if not found
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Address: " + address + ", Phone: " + phoneNumber +
                ", Roles: " + rolesAppliedTo + ", Skills: " + skills;
    }
}
