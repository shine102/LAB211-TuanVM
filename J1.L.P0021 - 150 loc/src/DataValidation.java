
import java.util.Scanner;


public class DataValidation {
    private static final Scanner sc = new Scanner(System.in);

    int validateInt(int min, int max, String msg) {
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

    String validateString(String msg, String regex) {
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
                System.out.println("Input must match format!");
            }
        }
        return input;
    }
}
