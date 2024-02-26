package ca2mateusveloso;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Employee {

    String name;
    String email;
    int empNum;
    static int nextEmpNum = 1;

    public Employee() {
        this("Jhow Jhow", "jhow@example.com");
    }

    public Employee(String name, String email) {
        this.name = name;
        this.email = email;
        this.empNum = nextEmpNum++;
    }

    public String getName(){
        return name;
    }

    public String getEmail(){
        if (email.length() > 3) {
        }
        return email;
    }

    public int getEmpNum(){
        return empNum;
    }

    public static void main(String[] args) {
        
        Employee employee = new Employee();

        System.out.println("Employee: " + employee.getName() + ", " + employee.getEmail());
        System.out.println(Employee.nextEmpNum);

        EmployeeTest employeeTest = employee.new EmployeeTest();

        employeeTest.main(args);
        
        Company company = new Employee().new Company();
        company.main(args);
        
    }

    
    class EmployeeTest {
        
        public void main(String[] args) {
            Employee[] projectGroup = new Employee[3];

            projectGroup[0] = new Employee("Joe Bloggs", "jb@gmail.com");
            projectGroup[1] = new Employee("Ann Banana", "ab@gmail.com");
            projectGroup[2] = new Employee("Tom Thumb", "tt@gmail.com");

            for (int i = 0; i < projectGroup.length; i++) {
                System.out.println("Employee " + (i+1) + ": " + projectGroup[i].getName() + ", " + projectGroup[i].getEmail());
            }

            int m = 0;

            System.out.println("Employees with Employee Number > " + m + ":");
            for (Employee employee : projectGroup) {
                if (employee.getEmpNum() > m) {
                    System.out.println(employee.getName());
                }
            }
        }
    }
    
    class Company {
        
        String companyName = "Gnomes Ltd";
        String name;
        String email;
        String managerUsername;
        String managerPassword;
        ArrayList<Employee> staff = new ArrayList<>();
        
                
        class ConsoleMenu {
            
                Scanner scanner;

                ConsoleMenu() {
                    scanner = new Scanner(System.in);
                }

                public void start() {
                    System.out.println(" Manager Username & Password");
                    System.out.print("Username: ");
                    String username = scanner.nextLine();
                    System.out.print("Password: ");
                    String password = scanner.nextLine();

                    if (username.equals("Gnomeo") && password.equals("smurf")) {
                        System.out.println("Logged");
                        boolean loggedIn = true;

                        while (loggedIn) {
                            System.out.println("\n Menu");
                            System.out.println("1- Acess staff");
                            System.out.println("2- Adicionar new staff");
                            System.out.println("3- Leave page");

                            System.out.print("Select your option from 1 to 3: ");
                            int choice = scanner.nextInt();

                            switch (choice) {
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
                                default:
                                    System.out.println("Wrong. Select from 1 to 3.");
                            }
                        }
                    } else {
                        System.out.println("Fail, please insert valid password and username");
                    }
                }   
        }
        
        
               
        public Company() {
            this("Gnomes Ltd", "123@gmail.com");
        }
        
        public Company(String name) {
            this(name, "123@gmail.com");
        }
        
        public Company(String name, String email) {
            this.name = name;
            this.email = email;
        }
        
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
                
        public void addNewStaff(String name, String email) {
            Employee employee = new Employee(name, email);
            staff.add(employee);
        }
        
        public int getStaffNumber() {
            return staff.size();
        }
        
        public void listEmployees(int empNumGiv) {
            
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
        
            Company [] staffGnomeo = new Company [3];
        
            staffGnomeo[0] = new Company("Joe Bloggs", "jb@gmail.com");
            staffGnomeo[1] = new Company("Ann Banana", "ab@gmail.com");
            staffGnomeo[2] = new Company("Tom Thumb", "tt@gmail.com");

            for (int i = 0; i < staffGnomeo.length; i++) {
                System.out.println("Company " + (i+1) + ":");
                System.out.println("Name: " + staffGnomeo[i].name);
                System.out.println("Email: " + staffGnomeo[i].email);
                System.out.println();
            }
        }
            
    }
}
