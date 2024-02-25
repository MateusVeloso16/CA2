package ca2mateusveloso;

public class Employee {

    String name;
    String email;
    int empNum;

    public Employee() {
        this.name = "John Doe";
        this.email = "john@example.com";
    }

    public Employee(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public static void main(String[] args) {

        Employee defaultEmployee = new Employee();


        Employee parametersEmployee = new Employee("Jane Doe", "jane@example.com");
    }
}
