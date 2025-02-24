// Importing necessary packages
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Class representing a Person
class Person {
    // Encapsulation: private fields with public getters and setters
    private String name;
    private int age;

    // Constructor to initialize Person
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for age
    public int getAge() {
        return age;
    }

    // Setter for age
    public void setAge(int age) {
        this.age = age;
    }

    // Method to display person details
    public void displayInfo() {
        System.out.println(String.format("Name: %s, Age: %d", name, age));
    }
}

// Interface representing common behavior of employees
interface Employee {
    void work();  // Abstraction: defining what work should do, but not how
}

// Class representing a Software Engineer, inheriting from Person and implementing Employee
class SoftwareEngineer extends Person implements Employee {
    private String programmingLanguage;

    // Constructor to initialize SoftwareEngineer
    public SoftwareEngineer(String name, int age, String programmingLanguage) {
        super(name, age);  // Inheritance: calling superclass (Person) constructor
        this.programmingLanguage = programmingLanguage;
    }

    // Overriding the work method from Employee interface
    @Override
    public void work() {
        System.out.println(String.format("%s is writing code in %s", getName(), programmingLanguage));
    }

    // Overriding the displayInfo method from Person class
    @Override
    public void displayInfo() {
        super.displayInfo();  // Calling the superclass (Person) method
        System.out.println(String.format("Programming Language: %s", programmingLanguage));
    }
}

// Class representing a Team
class Team {
    private List<Person> members;

    // Constructor to initialize Team
    public Team() {
        members = new ArrayList<>();
    }

    // Method to add a member to the team
    public void addMember(Person person) {
        members.add(person);
    }

    // Method to get the size of the team
    public int getSize() {
        return members.size();
    }

    // Method to display all team members
    public void displayTeam() {
        for (Person p : members) {
            p.displayInfo();
        }
    }
}

// Class representing a Manager, inheriting from Person and implementing Employee
class Manager extends Person implements Employee {
    private Team team;

    // Constructor to initialize Manager
    public Manager(String name, int age) {
        super(name, age);
        team = new Team();
    }

    // Method to add a team member
    public void addTeamMember(Person person) {
        team.addMember(person);
    }

    // Overriding the work method from Employee interface
    @Override
    public void work() {
        System.out.println(String.format("%s is managing the team.", getName()));
    }

    // Overriding the displayInfo method from Person class
    @Override
    public void displayInfo() {
        super.displayInfo();  // Calling the superclass (Person) method
        System.out.println(String.format("Team size: %d", team.getSize()));
        team.displayTeam();
    }
}

// Main class to demonstrate OOP concepts
public class oop {
    // Helper method to get valid integer input
    private static int getValidIntInput(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Employee> employees = new ArrayList<>();

        while (true) {
            System.out.println("Enter 1 to add a Software Engineer, 2 to add a Manager, 3 to display all employees, 4 to exit:");
            int choice = getValidIntInput(scanner, "");

            switch (choice) {
                case 1:
                    // Add a Software Engineer
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    int age = getValidIntInput(scanner, "Enter age: ");
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter programming language: ");
                    String programmingLanguage = scanner.nextLine();
                    employees.add(new SoftwareEngineer(name, age, programmingLanguage));
                    break;

                case 2:
                    // Add a Manager
                    System.out.print("Enter name: ");
                    String mgrName = scanner.nextLine();
                    int mgrAge = getValidIntInput(scanner, "Enter age: ");
                    scanner.nextLine();  // Consume newline
                    Manager mgr = new Manager(mgrName, mgrAge);

                    int numTeamMembers = getValidIntInput(scanner, "Enter the number of team members: ");
                    scanner.nextLine();  // Consume newline

                    for (int i = 0; i < numTeamMembers; i++) {
                        System.out.print("Enter team member name: ");
                        String memberName = scanner.nextLine();
                        int memberAge = getValidIntInput(scanner, "Enter team member age: ");
                        scanner.nextLine();  // Consume newline
                        mgr.addTeamMember(new Person(memberName, memberAge));
                    }
                    employees.add(mgr);
                    break;

                case 3:
                    // Display all employees
                    for (Employee emp : employees) {
                        emp.work();
                        if (emp instanceof Person) {
                            ((Person) emp).displayInfo();
                        }
                        System.out.println();
                    }
                    break;

                case 4:
                    // Exit the program
                    System.out.println("Exiting the program.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

