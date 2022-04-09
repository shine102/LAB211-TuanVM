
import static java.lang.System.exit;
import java.util.Scanner;


/**
 *
 * @author la
 */
public class main {
    public static void askContinue(Scanner sc){
        // loop to get user input
        while(true) {
            System.out.println("==========================================================");
            System.out.println("Do you want to continue? Y/N ");
            String choice;
            choice = sc.nextLine();
            // [YN]: match with Y or N
            // check if choice match with regex 
            if (choice.matches("[YN]")) {
                // check if choice equal with Y
                if (choice.equals("Y")){
                    break;
                } else {
                    exit(0);
                }
            } else {
                System.out.println("You must enter Y for Yes or N for No!!!");
            }
        }
        
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GetInput getInput = new GetInput();
        Convert cv = new Convert();
        while(true) {
            // 1. get from base
            int fromBase = getInput.getBase(sc, "in");
            // 2. get to base
            int toBase = getInput.getBase(sc, "out");
            // 3. get input number
            String fromNumber = getInput.getNumber(sc, fromBase);
            // 4. convert and display output
            cv.convertBaseToBase(fromBase, toBase, fromNumber);
            // 5. ask user to continue or not
            askContinue(sc);
        }
    }
}
