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
}
