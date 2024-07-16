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
        System.out.println("Name: " + name + ", Age: " + age);
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
        System.out.println(getName() + " is writing code in " + programmingLanguage);
    }

    // Overriding the displayInfo method from Person class
    @Override
    public void displayInfo() {
        super.displayInfo();  // Calling the superclass (Person) method
        System.out.println("Programming Language: " + programmingLanguage);
    }
}

// Class representing a Manager, inheriting from Person and implementing Employee
class Manager extends Person implements Employee {
    private List<Person> team;

    // Constructor to initialize Manager
    public Manager(String name, int age) {
        super(name, age);
        team = new ArrayList<>();
    }

    // Method to add a person to the manager's team
    public void addTeamMember(Person person) {
        team.add(person);
    }

    // Overriding the work method from Employee interface
    @Override
    public void work() {
        System.out.println(getName() + " is managing the team.");
    }

    // Overriding the displayInfo method from Person class
    @Override
    public void displayInfo() {
        super.displayInfo();  // Calling the superclass (Person) method
        System.out.println("Team size: " + team.size());
        for (Person p : team) {
            p.displayInfo();
        }
    }
}

// Main class to demonstrate OOP concepts
public class oop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a list to store all employees
        List<Employee> employees = new ArrayList<>();

        while (true) {
            System.out.println("Enter 1 to add a Software Engineer, 2 to add a Manager, 3 to display all employees, 4 to exit:");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            if (choice == 1) {
                // Add a Software Engineer
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                System.out.print("Enter age: ");
                int age = scanner.nextInt();
                scanner.nextLine();  // Consume newline
                System.out.print("Enter programming language: ");
                String programmingLanguage = scanner.nextLine();
                SoftwareEngineer se = new SoftwareEngineer(name, age, programmingLanguage);
                employees.add(se);

            } else if (choice == 2) {
                // Add a Manager
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                System.out.print("Enter age: ");
                int age = scanner.nextInt();
                scanner.nextLine();  // Consume newline
                Manager mgr = new Manager(name, age);

                // Adding team members to the manager
                System.out.print("Enter the number of team members: ");
                int numTeamMembers = scanner.nextInt();
                scanner.nextLine();  // Consume newline

                for (int i = 0; i < numTeamMembers; i++) {
                    System.out.print("Enter team member name: ");
                    String memberName = scanner.nextLine();
                    System.out.print("Enter team member age: ");
                    int memberAge = scanner.nextInt();
                    scanner.nextLine();  // Consume newline

                    // Here we assume team members are generic persons. In real scenarios, they could be SoftwareEngineers or other types of employees.
                    Person teamMember = new Person(memberName, memberAge);
                    mgr.addTeamMember(teamMember);
                }
                employees.add(mgr);

            } else if (choice == 3) {
                // Display all employees
                for (Employee emp : employees) {
                    emp.work();
                    if (emp instanceof Person) {
                        ((Person) emp).displayInfo();
                    }
                    System.out.println();
                }

            } else if (choice == 4) {
                // Exit the program
                System.out.println("Exiting the program.");
                break;

            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}

