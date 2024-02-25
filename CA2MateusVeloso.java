package ca2mateusveloso;

public class Employee { //can be accessed outside the package since its public.

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
    
    public String getEmail(){
        
        if (email.length() > 3) {
        } 
        return email;
    }
    
    public int getNextEmpNum(){
        return nextEmpNum;
    }

    public static void main(String[] args) {

        Employee defaultEmployee = new Employee();


        Employee parametersEmployee = new Employee("Jane Doe", "jane@example.com");
        
        
        
    }
    
    
    
}

public class EmployeeTest{

    public static void main (String[] args){
    
    Employee joeBloggs = new Employee ("Joe Bloggs", "jb@gmail.com");
    Employee annBanana = new Employee ("Ann Banana", "ab@gmail.com");
    Employee tomThumb = new Employee ("Tom Thumb", "tt@gmail.com");
            
    
    }

}

    
