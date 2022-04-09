
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        Validation validation = new Validation();
        Management management = new Management();
        ArrayList<Employee> elist = new ArrayList<>();
        // loop until user stop the program
        while(true){
            //1. display a menu
            Display.displayMenu();
            //2. ask user to input an option
            int choice = validation.validateInt(sc, 1, 6, "Please enter your choice: ");
            //3. perform a function base on that option
            switch (choice) {
                case 1:
                    // add employee
                    management.addEmployee(elist);
                    break;
                case 2:
                    // update employee
                    management.updateEmployee(elist);
                    break;
                case 3:
                    // remove employee
                    management.removeEmployee(elist);
                    break;
                case 4:
                    // search employee by name
                    management.searchEmployee(elist);
                    break;
                case 5:
                    // sort employee by salary
                    management.sort(elist);
                    break;
                case 6:
                    System.exit(0);
            }
        }
    }
}
