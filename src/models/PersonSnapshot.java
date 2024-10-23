package models;

import java.util.List;

public class PersonSnapshot {
    private final String name;
    private final String address;
    private final String phoneNumber;
    private final List<String> rolesAppliedTo;
    private final List<String> skills;

    public PersonSnapshot(String name, String address, String phoneNumber, List<String> rolesAppliedTo, List<String> skills) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.rolesAppliedTo = List.copyOf(rolesAppliedTo);  // Create an immutable copy of the roles
        this.skills = List.copyOf(skills);  // Create an immutable copy of the skills
    }

    // Getters (no setters since this is immutable)
    public String getName() { return name; }
    public String getAddress() { return address; }
    public String getPhoneNumber() { return phoneNumber; }
    public List<String> getRolesAppliedTo() { return rolesAppliedTo; }
    public List<String> getSkills() { return skills; }

    @Override
    public String toString() {
        return "Name: " + name + ", Address: " + address + ", Phone: " + phoneNumber +
                ", Roles: " + rolesAppliedTo + ", Skills: " + skills;
    }
}
