package views;

import repositories.InMemoryPersonRepository;
import services.PersonService;
import services.PersonServiceInterface;

import java.time.LocalDateTime;
import java.util.Scanner;

public class ConsoleUI {
    private final PersonServiceInterface personService;
    private final Scanner scanner;

    public ConsoleUI() {
        // Use the singleton pattern to get the service instance
        personService = PersonService.getInstance(new InMemoryPersonRepository());
        scanner = new Scanner(System.in);
    }

    public void start() {
        boolean running = true;
        while (running) {
            System.out.println("\n--- Human Resources App ---");
            System.out.println("1. Add a new person");
            System.out.println("2. Edit a person's basic info");
            System.out.println("3. Add a role to a person");
            System.out.println("4. Add a skill to a person");
            System.out.println("5. View person's current data");
            System.out.println("6. View person's data on a specific date");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    addPerson();
                    break;
                case 2:
                    editPerson();
                    break;
                case 3:
                    addRoleToPerson();
                    break;
                case 4:
                    addSkillToPerson();
                    break;
                case 5:
                    viewCurrentPersonData();
                    break;
                case 6:
                    viewPersonDataOnDate();
                    break;
                case 7:
                    running = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }

    private void addPerson() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter address: ");
        String address = scanner.nextLine();
        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine();
        personService.addPerson(name, address, phoneNumber);
    }

    private void editPerson() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter new address: ");
        String address = scanner.nextLine();
        System.out.print("Enter new phone number: ");
        String phoneNumber = scanner.nextLine();
        personService.editPerson(name, address, phoneNumber);
    }

    private void addRoleToPerson() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter role: ");
        String role = scanner.nextLine();
        personService.addRoleToPerson(name, role);
    }

    private void addSkillToPerson() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter skill: ");
        String skill = scanner.nextLine();
        personService.addSkillToPerson(name, skill);
    }

    private void viewCurrentPersonData() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        personService.viewCurrentPersonData(name);
    }

    private void viewPersonDataOnDate() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter date and time (YYYY-MM-DDTHH:MM): ");
        String dateString = scanner.nextLine();
        LocalDateTime dateTime = LocalDateTime.parse(dateString);
        personService.viewPersonDataOnDate(name, dateTime);
    }
}
