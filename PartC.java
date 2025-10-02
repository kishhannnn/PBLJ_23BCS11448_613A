package Demo;
import java.io.*;
import java.util.*;

class Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String name;
    private String designation;
    private double salary;

    public Employee(String id, String name, String designation, double salary) {
        this.id = id;
        this.name = name;
        this.designation = designation;
        this.salary = salary;
    }

    public void display() {
        System.out.println("ID: " + id + ", Name: " + name +
                ", Designation: " + designation + ", Salary: " + salary);
    }
}

public class PartC {
    private static final String FILE_NAME = "employees.ser";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n=== Employee Management System ===");
            System.out.println("1. Add Employee");
            System.out.println("2. Display All Employees");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    addEmployee(sc);
                    break;
                case "2":
                    displayEmployees();
                    break;
                case "3":
                    System.out.println("Exiting... Goodbye!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void addEmployee(Scanner sc) {
        try {
            System.out.print("Enter Employee ID: ");
            String id = sc.nextLine();
            System.out.print("Enter Name: ");
            String name = sc.nextLine();
            System.out.print("Enter Designation: ");
            String designation = sc.nextLine();
            System.out.print("Enter Salary: ");
            double salary = Double.parseDouble(sc.nextLine());

            Employee emp = new Employee(id, name, designation, salary);

            List<Employee> employees = readAllEmployees();
            employees.add(emp);
            saveAllEmployees(employees);

            System.out.println("Employee added successfully!");
        } catch (Exception e) {
            System.out.println("Error adding employee: " + e.getMessage());
        }
    }

    private static void displayEmployees() {
        List<Employee> employees = readAllEmployees();
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
        } else {
            System.out.println("\n--- Employee Records ---");
            for (Employee emp : employees) {
                emp.display();
            }
        }
    }

    @SuppressWarnings("unchecked")
    private static List<Employee> readAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            employees = (List<Employee>) in.readObject();
        } catch (FileNotFoundException e) {
            // First run, no file yet
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error reading employees: " + e.getMessage());
        }
        return employees;
    }

    private static void saveAllEmployees(List<Employee> employees) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            out.writeObject(employees);
        } catch (IOException e) {
            System.out.println("Error saving employees: " + e.getMessage());
        }
    }
}
