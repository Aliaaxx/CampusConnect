import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    private static ArrayList<Person> persons = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\nManagement System Menu:");
            System.out.println("1. Add Person");
            System.out.println("2. Display All Persons");
            System.out.println("3. Display Person by ID");
            System.out.println("4. Update Person");
            System.out.println("5. Delete Person");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addPerson();
                    break;
                case 2:
                    displayAllPersons();
                    break;
                case 3:
                    displayPersonById();
                    break;
                case 4:
                    updatePerson();
                    break;
                case 5:
                    deletePerson();
                    break;
                case 6:
                    System.out.println("Exiting program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice != 6);
    }

    private static void addPerson() {
        System.out.print("Enter person type (1. Doctor, 2. Student, 3. Staff): ");
        int type = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        switch (type) {
            case 1:
                System.out.print("Enter specialization: ");
                String specialization = scanner.nextLine();
                persons.add(new Doctors(name, id, specialization));
                break;
            case 2:
                System.out.print("Enter course: ");
                String course = scanner.nextLine();
                persons.add(new Students(name, id, course));
                break;
            case 3:
                System.out.print("Enter role: ");
                String role = scanner.nextLine();
                persons.add(new Staff(name, id, role));
                break;
            default:
                System.out.println("Invalid person type.");
        }

        System.out.println("Person added successfully!");
    }

    private static void displayAllPersons() {
        if (persons.isEmpty()) {
            System.out.println("No persons to display.");
        } else {
            System.out.println("All Persons:");
            for (Person person : persons) {
                person.displayInfo();
            }
        }
    }

    private static void displayPersonById() {
        System.out.print("Enter ID of the person to display: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Person foundPerson = findPersonById(id);
        if (foundPerson != null) {
            System.out.println("Person Information (ID: " + id + "):");
            foundPerson.displayInfo();
        } else {
            System.out.println("Person not found with ID: " + id);
        }
    }

    private static void updatePerson() {
        System.out.print("Enter ID of the person to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Person foundPerson = findPersonById(id);
        if (foundPerson != null) {
            if (foundPerson instanceof Doctors) {
                updateDoctor((Doctors) foundPerson);
            } else if (foundPerson instanceof Students) {
                updateStudent((Students) foundPerson);
            } else if (foundPerson instanceof Staff) {
                updateStaff((Staff) foundPerson);
            } else {
                updateGeneralPersonInfo(foundPerson);
            }

            System.out.println("Person updated successfully!");
        } else {
            System.out.println("Person not found with ID: " + id);
        }
    }

    private static void updateDoctor(Doctors doctor) {
        System.out.print("Enter new name: ");
        String newName = scanner.nextLine();
        System.out.print("Enter new specialization: ");
        String newSpecialization = scanner.nextLine();
        System.out.print("Enter new ID: ");
        int newId = scanner.nextInt();

        doctor.id = newId;
        doctor.name = newName;
        doctor.specialization = newSpecialization;
    }

    private static void updateStudent(Students student) {
        System.out.print("Enter new name: ");
        String newName = scanner.nextLine();
        System.out.print("Enter new course: ");
        String newCourse = scanner.nextLine();
        System.out.print("Enter new ID: ");
        int newId = scanner.nextInt();

        student.id = newId;
        student.name = newName;
        student.course = newCourse;
    }

    private static void updateStaff(Staff staff) {
        System.out.print("Enter new name: ");
        String newName = scanner.nextLine();
        System.out.print("Enter new role: ");
        String newRole = scanner.nextLine();
        System.out.print("Enter new ID: ");
        int newId = scanner.nextInt();

        staff.id = newId;
        staff.name = newName;
        staff.role = newRole;
    }

    private static void updateGeneralPersonInfo(Person person) {
        System.out.print("Enter new name: ");
        String newName = scanner.nextLine();
        System.out.print("Enter new ID: ");
        int newId = scanner.nextInt();

        person.id = newId;
        person.name = newName;
    }


    private static void deletePerson() {
        System.out.print("Enter ID of the person to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Person foundPerson = findPersonById(id);
        if (foundPerson != null) {
            persons.remove(foundPerson);
            System.out.println("Person deleted successfully!");
        } else {
            System.out.println("Person not found with ID: " + id);
        }
    }

    private static Person findPersonById(int id) {
        for (Person person : persons) {
            if (person.id == id) {
                return person;
            }
        }
        return null;
    }
}