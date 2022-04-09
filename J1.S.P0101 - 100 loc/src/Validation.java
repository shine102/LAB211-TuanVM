
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


class Validation {
    int validateInt(Scanner sc, int min, int max, String msg){
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

    String validateString(Scanner sc, String regex, String msg) {
        String input;
        // loop to get input
        while (true) {
            System.out.print(msg);
            input = sc.nextLine();
            // check input empty
            if (input.isEmpty()) {
                System.err.println("Input cannot empty!");
                continue;
            }
            if (input.contains(";")) {
                System.err.println("Input must not have ; character!");
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
                System.err.println("Input must match format!");
            }
        }
        return input;
    }

    Date validateDate(Scanner sc, String msg) {
        String input;
        //loop to get input
        while (true) {
            try {
                System.out.print(msg);
                input = sc.nextLine();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                simpleDateFormat.setLenient(false);
                Date date = simpleDateFormat.parse(input);
                return date;
            } catch (Exception e){
                System.err.println("Wrong date format, or date not existed!");
            }
        }
    }
}
