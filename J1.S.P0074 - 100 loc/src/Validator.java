
import java.util.Scanner;

public class Validator {
    int validateInt(Scanner sc, int min, int max, String msg){
        String input;
        int number;
        // loop to get input
        do {
            System.out.print(msg);
            input = sc.nextLine();
            //check input empty
            if (input.isEmpty()){
                System.out.println("Input cannot empty!");
                continue;
            }
            try {
                number = Integer.parseInt(input);
                // check number has value between max and min
                if (number >= min && number <= max){
                    break;
                } else {
                    System.out.println("Input must between " + min + " and " + max);
                }
            } catch(Exception e){
                System.out.println("Input wrong format!");
            }
        } while (true);
        return number;
    }
    
    int getValueMatrix(Scanner sc, String msg){
        String input;
        int number;
        // loop to get input
        do {
            System.out.print(msg);
            input = sc.nextLine();
            //check input empty
            if (input.isEmpty()) {
                System.out.println("Input cannot empty!");
                continue;
            }
            try {
                number = Integer.parseInt(input);
                // check number has value between max and min
                if (number >= Integer.MIN_VALUE && number <= Integer.MAX_VALUE) {
                    break;
                } else {
                    System.out.println("Input must between " + Integer.MIN_VALUE + " and " + Integer.MAX_VALUE);
                }
            } catch (Exception e) {
                System.out.println("Value of matrix is digit");
            }
        } while (true);
        return number;
    }
}
