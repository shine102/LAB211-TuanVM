
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DataValidation dv = new DataValidation();
        Scanner sc = new Scanner(System.in);
        Management mn = new Management();
        ArrayList<StudentSchedule> sList = new ArrayList<>();
        // loop until user end program
        while(true){
            //1. display the menu
            Display.displayMenu();
            //2. ask user enter the choice to continue
            int choice = dv.validateInt(sc, 1, 5, "Please enter your choice: ");
            //3. perform functions based on the choice entered
            switch(choice){
                case 1: // create student info
                    mn.create(sList);
                    break;
                case 2: // find and sort
                    mn.findSort(sList);
                    break;
                case 3: // update/delete
                    mn.updateDelete(sList);
                    break;
                case 4: //report
                    mn.report(sList);
                    break;
                case 5: // exit
                    System.exit(0);
            }
        }
        
    }
}
