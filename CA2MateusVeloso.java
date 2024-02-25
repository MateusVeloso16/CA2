package ca2mateusveloso;

public class Employee {

    String name;
    String email;
    int empNum;
    static int nextEmpNum = 1;


    public Employee() {
        this.name = "John Doe";
        this.email = "john@example.com";
        this.empNum = nextEmpNum++;

    }

    public Employee(String name, String email) {
        this.name = name;
        this.email = email;
        this.empNum = nextEmpNum++;

    }
    
    public String getName(){
        return name;
    }

    public static void main(String[] args) {

        Employee defaultEmployee = new Employee();


        Employee parametersEmployee = new Employee("Jane Doe", "jane@example.com");
    }
}
