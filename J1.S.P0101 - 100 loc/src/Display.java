
import java.util.ArrayList;


class Display {
    static void displayMenu(){
        System.out.println("========= Employee Management =========");
        System.out.println("\t1. Add employee.");
        System.out.println("\t2. Update employee.");
        System.out.println("\t3. Remove employee.");
        System.out.println("\t4. Search employee by name.");
        System.out.println("\t5. Sort employee by salary.");
        System.out.println("\t6. Exit");
    }
    
    static void displayUpdateMenu(){
        System.out.println("0. Update Id.");
        System.out.println("1. Update First Name.");
        System.out.println("2. Update Last Name.");
        System.out.println("3. Update Phone Number.");
        System.out.println("4. Update Email.");
        System.out.println("5. Update Address.");
        System.out.println("6. Update DOB.");
        System.out.println("7. Update Sex.");
        System.out.println("8. Update Salary.");
        System.out.println("9. Update Agency.");
    }

    static void displayAllEmployee(ArrayList<Employee> elist) {
        System.out.println("Employee list: ");
        System.out.format("%-4s | %-12s | %-12s | %-11s | %-14s | %-14s | %-10s | %-4s | %-10s | %-15s\n", "ID", "First Name", "Last Name", "Phone", "Email", "Address", "DOB", "Sex", "Salary", "Agency");
        // loop through every element in list
        for (Employee e : elist){
            displayEmployee(e); 
        }
    }
    
    static void displayEmployee(Employee e){
        System.out.format("%-4s | %-12s | %-12s | %-11s | %-14s | %-14s | %-10s | %-4s | %-10s | %-15s\n", e.getId(), e.getFirstName(), e.getLastName(), e.getPhone(), e.getEmail(), e.getAddress(), e.getDob().getDate() + "/" + (e.getDob().getMonth() + 1) + "/" + (e.getDob().getYear() + 1900), e.getSex().toUpperCase(), e.getSalary(), e.getAgency());
    }
}
