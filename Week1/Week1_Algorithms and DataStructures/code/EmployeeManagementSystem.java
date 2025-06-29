class Employee {
    int employeeId;
    String name;
    String position;
    double salary;

    public Employee(int employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public String toString() {
        return "ID: " + employeeId + ", Name: " + name + ", Position: " + position + ", Salary: ₹" + salary;
    }
}


public class EmployeeManagementSystem {
    static final int MAX_EMPLOYEES = 100;
    static Employee[] employees = new Employee[MAX_EMPLOYEES];
    static int count = 0;

    public static void addEmployee(Employee e) {
        if (count < MAX_EMPLOYEES) {
            employees[count++] = e;
            System.out.println("Employee added.");
        } else {
            System.out.println(" Employee list full.");
        }
    }

    public static Employee searchEmployee(int id) {
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == id) {
                return employees[i];
            }
        }
        return null;
    }

    public static void displayAllEmployees() {
        if (count == 0) {
            System.out.println("No employees to show.");
            return;
        }
        for (int i = 0; i < count; i++) {
            System.out.println(employees[i]);
        }
    }

    public static void deleteEmployee(int id) {
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == id) {
                for (int j = i; j < count - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[--count] = null;
                System.out.println("Employee deleted.");
                return;
            }
        }
        System.out.println(" Employee not found.");
    }

    public static void main(String[] args) {
        addEmployee(new Employee(1, "Alice", "Manager", 70000));
        addEmployee(new Employee(2, "Bob", "Developer", 50000));
        addEmployee(new Employee(3, "Charlie", "Designer", 45000));

        System.out.println("\nEmployee List:");
        displayAllEmployees();

        System.out.println("\n Searching for ID 2:");
        Employee e = searchEmployee(2);
        System.out.println(e != null ? e : "Not found");

        System.out.println("\n Deleting ID 1:");
        deleteEmployee(1);

        System.out.println("\n Updated Employee List:");
        displayAllEmployees();
    }
}
