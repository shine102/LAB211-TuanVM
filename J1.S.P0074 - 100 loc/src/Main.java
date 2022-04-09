
import static java.lang.System.exit;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Validator validate = new Validator();
        Scanner sc = new Scanner(System.in);
        MatrixCalculator mc = new MatrixCalculator();
        // loop until user quit program
        while(true){
            // 1. display menu 
            Display.displayMenu();
            // 2. ask user to select an option
            int choice = validate.validateInt(sc, 1, 4, "Your choice: ");
            // 3. perform function base on the selected option
            switch(choice){
                case 1: // addition 2 matrix
                    mc.additionMatrix(sc, validate);
                    break;
                case 2: // substraction 2 matrix
                    mc.subtractionMatrix(sc, validate);
                    break;
                case 3: // multiplication 2 matrix
                    mc.multiplicationMatrix(sc, validate);
                    break; 
                case 4: // exit program
                    exit(0);
            }
        }  
    }
}
