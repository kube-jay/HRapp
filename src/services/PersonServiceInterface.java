package services;

import java.time.LocalDateTime;

public interface PersonServiceInterface {
    void addPerson(String name, String address, String phoneNumber);
    void editPerson(String name, String address, String phoneNumber);
    void addRoleToPerson(String name, String role);
    void addSkillToPerson(String name, String skill);
    void viewCurrentPersonData(String name);
    void viewPersonDataOnDate(String name, LocalDateTime dateTime);
}
