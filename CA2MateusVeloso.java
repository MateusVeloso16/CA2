package ca2mateusveloso;

public class CA2MateusVeloso {

    String name;
    String email;
     int empNum;

    public CA2MateusVeloso(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public static void main(String[] args) {

        CA2MateusVeloso employee = new CA2MateusVeloso("John Doe", "john@example.com");


        System.out.println("Name: " + employee.name);
        System.out.println("Email: " + employee.email);
    }
}
