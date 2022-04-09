
import java.util.Scanner;

/**
 *
 * @author la
 */
public class Validation {
    int validateInt(Scanner sc, int min, int max, String msg) {
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
                if (number >= min && number <= max) {
                    break;
                } else {
                    System.out.println("Input must between " + min + " and " + max);
                }
            } catch (Exception e) {
                System.out.println("Input wrong format!");
            }
        } while (true);
        return number;
    }

    String validateString(Scanner sc, String msg, String regex, String alert) {
        String input;
        // loop to get input
        while (true) {
            System.out.print(msg);
            input = sc.nextLine();
            // check input empty
            if (input.isEmpty()) {
                System.out.println("Input cannot empty!");
                continue;
            }
            // check if regex is empty or not
            if (regex.isEmpty()) {
                break;
            }
            // check input match the regex
            if (input.matches(regex)) {
                break;
            } else {
                System.out.println(alert);
            }
        }
        return input;
    }

    String validatePassword(Scanner sc, String msg, String alert) {
        String input;
        // loop to get input
        while (true) {
            System.out.print(msg);
            input = sc.nextLine();
            // check input empty
            if (input.isEmpty()) {
                System.out.println("Input cannot empty!");
                continue;
            }
            // check if the input length is between 8 and 31 or not
            if (input.length() > 31 || input.length() < 8){
                System.out.println(alert);
                continue;
            }
            /*
                .: matches any character except line breaks
                *: matches 0 or more of the preceding token
                [0-9]: matches a character in the range "0" to "9"
            */
            if (!input.matches(".*[0-9].*")){
                System.out.println(alert);
                continue;
            }
            /*
                .: matches any character except line breaks
                *: matches 0 or more of the preceding token
                [A-Za-z]: matches a character in the range "A" to "Z" and "a" to "z"
             */
            if (!input.matches(".*[A-Za-z].*")){
                System.out.println(alert);
                continue;
            }
            break;
        }
        return input;
    }
}
