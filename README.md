# OOPexampleProg
Java program showing examples of object-orientated programming (OOP)

Explanation of OOP Concepts in the Program:

Classes and Objects:
Person, SoftwareEngineer, and Manager are classes.
SE and Mgr are objects of SoftwareEngineer and Manager classes, respectively.

Encapsulation:
The Person class has private fields with public getters and setters to encapsulate the data.

Inheritance:
SoftwareEngineer and Manager classes inherit from the Person class using the extends keyword.
They use the super keyword to call the constructor of the Person class.

Polymorphism:
A Manager object is assigned to a Person reference (person), demonstrating polymorphism.
The overridden displayInfo method of the Manager class is called through the person reference.
The Employee interface reference (employee) is used to call the work method on a SoftwareEngineer object.

Abstraction:
The Employee interface defines an abstract method work, which is implemented by SoftwareEngineer and Manager classes.

Overriding:
SoftwareEngineer and Manager override the displayInfo method of the Person class.
SoftwareEngineer and Manager provide their own implementations of the work method from the Employee interface.

----------------------------------------------------------------------------------------------------
User Input:

The program now uses Scanner to take user input for creating SoftwareEngineer and Manager objects.

The user can choose to add a software engineer, add a manager, display all employees, or exit the program.

Storing Employees:
Employees are stored in a list to keep track of them and display their details when required.

Team Members for Manager:
The program allows adding multiple team members to a manager.

Display and Exit Options:
Users can choose to display all employees or exit the program.

How to Use:
Run the program.
Follow the prompts to add a SoftwareEngineer or Manager.
Input the required details when prompted.
Choose to display all employees or exit the program as needed.
