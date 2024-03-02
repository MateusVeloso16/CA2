    // https://github.com/MateusVeloso16/CA2.git GITHUB-MATEUS VELOSO sba23162
package ca2mateusveloso; // Package declaration and imports for necessary classes and utilities.

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Employee {
    // Instance variables for employee name, email, and employee number.
    String name;
    String email;
    int empNum;
    static int nextEmpNum = 1; // Static variable for tracking the next employee number.

    public Employee() {
        this("Jhow Jhow", "jhow@example.com"); // Default constructor initializes name and email with default values.
    }

    public Employee(String name, String email) { // Parameterized constructor sets name, email, and increments employee number.
        this.name = name;
        this.email = email;
        this.empNum = nextEmpNum++;
    }
    // Getter methods for name, email, and employee number.
    public String getName() {
        return name;
    }

    public String getEmail() {
        if (email.length() > 3) {
        }
        return email;
    }

    public int getEmpNum() {
        return empNum;
    }

    // https://github.com/MateusVeloso16/CA2.git GITHUB-MATEUS VELOSO sba23162
    public static void main(String[] args) { // Main method to demonstrate Employee functionalities.

        Employee employee = new Employee();

        System.out.println("Employee: " + employee.getName() + ", " + employee.getEmail());
        System.out.println(Employee.nextEmpNum);

        EmployeeTest employeeTest = employee.new EmployeeTest();

        employeeTest.main(args);

        Company company = new Employee().new Company();
        company.main(args);

    }

    class EmployeeTest { // Nested class for testing Employee functionalities.

        public void main(String[] args) {
            Employee[] projectGroup = new Employee[3];

            projectGroup[0] = new Employee("Joe Bloggs", "jb@gmail.com");
            projectGroup[1] = new Employee("Ann Banana", "ab@gmail.com");
            projectGroup[2] = new Employee("Tom Thumb", "tt@gmail.com");

            for (int i = 0; i < projectGroup.length; i++) {
                System.out.println("Employee " + (i + 1) + ": " + projectGroup[i].getName() + ", " + projectGroup[i].getEmail());
            }

            System.out.println();
            System.out.println("Next employee number: " + nextEmpNum);
            System.out.println();

            int m = 4;
            System.out.println("Employees with Employee Number > " + m + ":");
            for (Employee employee : projectGroup) {
                if (employee.getEmpNum() > m) {
                    System.out.println(employee.getName());

                }
            }
            System.out.println();
        }
    }

    class Company { // Nested class for managing company operations.
        // Instance variables for company details, staff list, and staff number set.
        String companyName = "Gnomes Ltd";
        String name;
        String email;
        String managerUsername;
        String managerPassword;
        ArrayList<Employee> staff = new ArrayList<>();
        HashSet<Integer> staffSet = new HashSet<>();

        class ConsoleMenu { // Inner class to handle user input for company operations.

            Scanner scanner;

            ConsoleMenu() {
                scanner = new Scanner(System.in);
            }

            public void start() { // Method to start console menu for company operations.
                System.out.println(" Manager Username & Password");
                System.out.print("Username: ");
                String username = scanner.nextLine();
                System.out.print("Password: ");
                String password = scanner.nextLine();

                if (username.equals("Gnomeo") && password.equals("smurf")) { //Condition to check if username and password are correct.
                    System.out.println("Logged");
                    boolean loggedIn = true;

                    while (loggedIn) {
                        System.out.println("\n Menu");
                        System.out.println("1- Acess staff");
                        System.out.println("2- Adicionar new staff");
                        System.out.println("3- Leave page");
                        System.out.println("4- Remove Employee"); //Option added according to challenge that allow manager to remove employees.

                        System.out.print("Select your option from 1 to 4: ");
                        int choice = scanner.nextInt();

                        switch (choice) { //Case will be executed according to manager option inserted.
                            case 1:
                                listEmployees(0);
                                break;
                            case 2:
                                scanner.nextLine();
                                System.out.print("Insert staff name: ");
                                String name = scanner.nextLine();
                                System.out.print("Insert staff email: ");
                                String email = scanner.nextLine();
                                addNewStaff(name, email);
                                System.out.println("Staff added.");
                                break;
                            case 3:
                                System.out.println("Leaving");
                                loggedIn = false;
                                break;
                            case 4: //Case 4 was added according to challenge of removing employees.
                                System.out.print("Enter the employee number to remove: ");
                                int empNumToRemove = scanner.nextInt();
                                removeEmployee(empNumToRemove);
                                break;
                            default: // In case the user/manager dont insert a number from 1 to 4.
                                System.out.println("Wrong. Select from 1 to 4.");
                        }
                    }
                } else {
                    System.out.println("Invalid! Please insert valid password and username");//In case the user/manager insert invalid input
                }
            }
        }

        public Company() { // Constructors for company with different parameters.
            this("Gnomes Ltd", "123@gmail.com");
        }

        public Company(String name) {
            this(name, "123@gmail.com");
        }
          // Method for email validation using regular expressions.
        private boolean isValidEmail(String email) { //EEmail verification using regex
            String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(email);
            boolean isValid = matcher.matches();

            if (!isValid) {
                throw new UnsupportedOperationException("Invalid email address.");
            }

            return isValid;
        }

        public Company(String name, String email) { // Constructor for company with name and email, validating email.
            this.name = name;
            if (isValidEmail(email)) {
                this.email = email;
            } else {
                throw new IllegalArgumentException("Invalid email address: " + email);
            }
        }
         // Getter and setter methods for manager username and password.
        public String getManagerUsername() {
            return managerUsername;
        }

        public void setManagerUsername(String managerUsername) {
            this.managerUsername = managerUsername;
        }

        public String getManagerPassword() {
            return managerPassword;
        }

        public void setManagerPassword(String managerPassword) {
            this.managerPassword = managerPassword;
        }

        public void addNewStaff(String name, String email) { // Method to add new staff with name and email, ensuring no duplicate employee numbers.
            Employee employee = new Employee(name, email);
            if (!staffSet.contains(employee.getEmpNum())) {
                staff.add(employee);
                staffSet.add(employee.getEmpNum());
            } else {
                System.out.println("Employee with empNum " + employee.getEmpNum() + " is already being use.");
            }
        }

        public int getStaffNumber() { // Method to get the number of staff.
            return staff.size();
        }

        public void listEmployees(int empNumGiv) {  // Method to list employees with employee number greater than given number.

            Iterator<Employee> iterator = staff.iterator();
            System.out.println("Employees with Employee Number > " + empNumGiv + ":");
            while (iterator.hasNext()) {
                Employee employee = iterator.next();
                if (employee.getEmpNum() > empNumGiv) {
                    System.out.println(employee.getName());
                }
            }
        }

        public void main(String[] args) {

            ArrayList<Company> staffGnomeo = new ArrayList<>();  // ArrayList to hold company objects for testing.
            // Adding company objects with testing content to the ArrayList.
            staffGnomeo.add(new Company("Joe Bloggs", "jb@gmail.com")); //testing content
            staffGnomeo.add(new Company("Ann Banana", "ab@gmail.com")); //testing content
            staffGnomeo.add(new Company("Tom Thumb", "tt@gmail.com")); //testing content
            staffGnomeo.add(new Company("John Doe", "jd@gmail.com")); //testing content
            staffGnomeo.add(new Company("Jane Smith", "js@gmail.com")); //testing content
             // Iterating through the ArrayList and printing company details.
            for (int i = 0; i < staffGnomeo.size(); i++) {
                System.out.println("Company " + (i + 1) + ":");
                System.out.println("Name: " + staffGnomeo.get(i).name);
                System.out.println("Email: " + staffGnomeo.get(i).email);
                System.out.println();
            }
        }
         // Method to remove staff by employee number according to challenge part 2.
        public void removeStaff(int empNum) {
            Iterator<Employee> iterator = staff.iterator();
            while (iterator.hasNext()) {
                Employee employee = iterator.next();
                if (employee.getEmpNum() == empNum) {
                    iterator.remove();
                    staffSet.remove(empNum);
                    return;
                }
            }
            System.out.println("Employee with empNum " + empNum + " not found.");// Output message if employee with given empNum is not found.
        }

        public void removeEmployee(int empNum) { // Method to remove employee by employee number, using removeStaff method.
            this.removeStaff(empNum);
        }

    }
}
