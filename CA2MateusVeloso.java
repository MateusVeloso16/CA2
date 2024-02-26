package ca2mateusveloso;

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
            // Add your logic here if needed
        }
        return email;
    }

    public int getEmpNum(){
        return empNum;
    }

    public static void main(String[] args) {
        // Creating an Employee object using the default constructor
        Employee employee = new Employee();

        // Printing details of the employee
        System.out.println("Employee: " + employee.getName() + ", " + employee.getEmail());
        System.out.println(Employee.nextEmpNum);

        // Creating an instance of the inner class
        EmployeeTest employeeTest = employee.new EmployeeTest();

        // Invoking the main method of the inner class
        employeeTest.main(args);
    }

    // Inner class EmployeeTest
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

        Company(String joe_Bloggs, String jbgmailcom) {
        }
    
    String companyName = "Gnomes Ltd";
    
        public void main(String[] args) {
        
        Company [] staff = new Company [3];
        
        staff[0] = new Company("Joe Bloggs", "jb@gmail.com");
        staff[1] = new Company("Ann Banana", "ab@gmail.com");
        staff[2] = new Company("Tom Thumb", "tt@gmail.com");
        
        }
    
    }
    
}
