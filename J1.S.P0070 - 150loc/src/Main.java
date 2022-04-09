
import java.util.Scanner;


public class Main { 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Validation valid = new Validation();
        LoginSystem ls = new LoginSystem();
        // loop until user end program
        while(true){
            //1. Display menu
            Display.displayMenu();
            //2. Get user's choice
            int choice = valid.validateInt(sc, 1, 3, "Please choice one option: ");
            //3. Perform check login function with selected language
            switch(choice){
                case 1: // switch to vietnamese and perform login function
                    ls.vietnamese();
                    break;
                case 2://keep english and perform login function
                    ls.english();
                    break;
                case 3: 
                    System.exit(0);
            }
        }
    }
}
