package ca2mateusveloso;

public class CA2MateusVeloso {

    String name;
    String email;
    int empNum;

    public CA2MateusVeloso() {
        this.name = "John Doe";
        this.email = "john@example.com";
    }

    public CA2MateusVeloso(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public static void main(String[] args) {

        CA2MateusVeloso defaultEmployee = new CA2MateusVeloso();


        CA2MateusVeloso parametersEmployee = new CA2MateusVeloso("Jane Doe", "jane@example.com");
    }
}
